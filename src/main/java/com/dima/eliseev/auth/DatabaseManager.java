package com.dima.eliseev.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5433/deeplom";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";

    private Connection connection;
    private LoginFrame frame; // Ссылка на LoginFrame

    public DatabaseManager(String login, String password, int hash, LoginFrame frame) {
        this.frame = frame;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Подключение к БД успешно!");
            checkUserCredentials(login, password, hash);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка подключения к БД");
        }
    }

    public boolean checkUserCredentials(String login, String password, int hash) {
        String query = "SELECT login, passwordd FROM log_pass WHERE hash = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, hash); // Ищем по хешу логина

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String dbLogin = resultSet.getString("login");
                    String dbHashedPassword = resultSet.getString("passwordd"); // Хеш пароля в БД

                    if (!dbLogin.equals(login)) continue; // Проверяем логин

                    // Хешируем введенный пользователем пароль
                    String hashedInputPassword = hashPassword(password);
                    System.out.println(hashedInputPassword);
                    // Безопасное сравнение хешей
                    if (MessageDigest.isEqual(dbHashedPassword.getBytes(), hashedInputPassword.getBytes())) {
                        System.out.println("Успешный вход: " + dbLogin);
                        frame.isAuth(2);
                        return true;
                    }
                }
                System.out.println("Пользователь не найден или данные неверны.");
                frame.isAuth(3);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка выполнения запроса");
        }
        return false;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Соединение с БД закрыто.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для хеширования пароля (SHA-256)
    static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            System.out.println("Dimasik");
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Ошибка хеширования пароля", e);
        }
    }
}
