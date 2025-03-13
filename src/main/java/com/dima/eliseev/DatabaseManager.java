package com.dima.eliseev;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5433/deeplom";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1";

    private Connection connection;

    public DatabaseManager() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Подключение к БД успешно!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка подключения к БД");
        }
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

    public void getUserData() {
        String query = "SELECT login, passwordd, hesh FROM log_pass"; // Измени название таблицы, если нужно

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String password = resultSet.getString("passwordd");
                String hash = resultSet.getString("hesh");

                System.out.println("Логин: " + login + ", Пароль: " + password + ", Хеш: " + hash);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка выполнения запроса");
        }
    }

    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        dbManager.getUserData();
        dbManager.closeConnection();
    }
}
