package com.dima.eliseev;

import javax.swing.*;
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
        String query = "SELECT login, passwordd, hesh FROM log_pass WHERE login = ? AND passwordd = ? AND hesh = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, login);   // Устанавливаем login
            preparedStatement.setString(2, password); // Устанавливаем password
            preparedStatement.setInt(3, hash);        // Устанавливаем hash

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Логин: " + resultSet.getString("login") +
                            ", Пароль: " + resultSet.getString("passwordd") +
                            ", Хеш: " + resultSet.getString("hesh"));
                    frame.isAuth(2); // Меняем фон на "успешный вход"
                    return true;
                } else {
                    System.out.println("Пользователь не найден.");
                    frame.isAuth(3); // Меняем фон на "неудачный вход"
                    return false;
                }
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
