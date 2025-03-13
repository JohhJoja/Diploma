package com.dima.eliseev;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    String backgroundImgPath = "E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\background_image.png";

    public LoginFrame() {
        setTitle("Login");
        setSize(495, 520);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Устанавливаем иконку окна
        ImageIcon img = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\img.jpg");
        setIconImage(img.getImage());

        setLayout(null);

        // Создаём текстовое поле
        Auth_TextField LoginField = new Auth_TextField( "USERNAME",7, 194);
        Auth_TextField PasswordField = new Auth_TextField("PASSWORD",7, 241);

        add(LoginField);
        add(PasswordField);

        // Фон
        JLabel label = new JLabel();
        ImageIcon backgrIMG = new ImageIcon(backgroundImgPath);
        label.setIcon(backgrIMG);
        label.setBounds(0, 0, 495, 520);
        label.setOpaque(false); // Делаем фон прозрачным для компонентов поверх него

        add(label); // Фон добавляем ПОСЛЕ текстового поля

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
