package com.dima.eliseev.css;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class CSS {

    public static void CSS_LoginFrame(JFrame frame){
        frame.setTitle("Login");
        frame.setSize(495, 520);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Устанавливаем иконку окна
        ImageIcon img = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\images\\img.jpg");
        frame.setIconImage(img.getImage());

        frame.setLayout(null);
//        String login = "", password = "d";
//
//        String query = "SELECT login, passwordd FROM log_pass WHERE login = '"
//                       + login + "' AND passwordd = '" + password + "'";
//
//        query.toLowerCase();
    }

    public static void CSS_Buttom(JButton button, int y){
        button.setFocusPainted(false); // Убираем рамку фокуса
        button.setContentAreaFilled(false); // Убираем стандартную заливку
        button.setBorderPainted(false); // Убираем стандартную границу
        button.setOpaque(false); // Отключаем непрозрачность
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Шрифт
        button.setForeground(Color.WHITE); // Цвет текста
        button.setBounds(167, y, 149, 40); // Размещение кнопки
        button.setBackground(new Color(0x0C2F54));
        button.addActionListener((ActionListener) button);
    }

    public static void CSS_Auth_TextField(JTextField field, int y){
        field.setOpaque(false); // Отключаем стандартную заливку
        field.setMargin(new Insets(0, 10, 0, 0)); // Отступ слева на 10 пикселей
        field.setBounds(125, y, 245, 33);

        // Добавляем слушатель фокуса для обработки плейсхолдера
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                field.repaint(); // Перерисовываем поле при фокусе
            }

            @Override
            public void focusLost(FocusEvent e) {
                field.repaint(); // Перерисовываем поле при потере фокуса
            }
        });
    }

}
