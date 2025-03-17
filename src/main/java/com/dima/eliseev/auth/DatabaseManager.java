package com.dima.eliseev.auth;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5433/deeplom";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";

    private Connection connection;
    private LoginFrame frame; // Добавляем ссылку на LoginFrame

    public DatabaseManager(String login, String password, int hash, LoginFrame frame) {
        this.frame = frame; // Инициализация LoginFrame
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Подключение к БД успешно!");
            checkUserCredentials(login, password, hash); // Выполняем проверку при создании объекта
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка подключения к БД");
        }
    }

    public boolean checkUserCredentials(String login, String password, int hash) {
        String query = "SELECT login, passwordd FROM log_pass WHERE hesh = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, hash); // Сначала ищем по хэшу

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String dbLogin = resultSet.getString("login");
                    String dbPassword = resultSet.getString("passwordd");

                    if (dbLogin.equals(login) && dbPassword.equals(password)) {
                        System.out.println("Успешный вход: " + dbLogin);
                        frame.isAuth(2); // Меняем фон на "успешный вход"
                        return true;
                    }
                }
                System.out.println("Пользователь не найден или данные неверны.");
                frame.isAuth(3); // Меняем фон на "неудачный вход"
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
            if (connection != null) {
                connection.close();
                System.out.println("Соединение с БД закрыто.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
