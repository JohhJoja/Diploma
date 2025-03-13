package com.dima.eliseev;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private static JLabel label;
    Auth_TextField LoginField;
    Auth_TextField PasswordField;

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
        LoginField = new Auth_TextField( "USERNAME",7, 194);
        PasswordField = new Auth_TextField("PASSWORD",7, 241);

        add(LoginField);
        add(PasswordField);

        // Фон
        label = new JLabel();
        //ImageIcon backgrIMG = new ImageIcon(backgroundImgPath);
        isAuth(1);

        label.setBounds(0, 0, 495, 520);
        label.setOpaque(false); // Делаем фон прозрачным для компонентов поверх него

        add(new Buttom("submit", LoginField, PasswordField, 299, this));
        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
    void isAuth(int i){
        ImageIcon backgrIMG = null;
        if (i==1){
            backgrIMG = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\background_image.png");
        } else if (i==2) {
            backgrIMG = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\Tauth.png");
            LoginField = null;
            PasswordField = null;
        } else {
            backgrIMG = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\Fauth.png");
        }
        label.setIcon(backgrIMG);
    }
}
