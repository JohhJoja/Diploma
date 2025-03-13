package com.dima.eliseev;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private static JLabel label;
    Auth_TextField LoginField;
    Auth_TextField PasswordField;
    Buttom SubButt;

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
        SubButt = new Buttom("submit", LoginField, PasswordField, 299, this);

        add(LoginField);
        add(PasswordField);
        add(SubButt);

        // Фон
        label = new JLabel();
        //ImageIcon backgrIMG = new ImageIcon(backgroundImgPath);
        isAuth(1);

        label.setBounds(0, 0, 495, 520);
        label.setOpaque(false); // Делаем фон прозрачным для компонентов поверх него

        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
    void isAuth(int i) {
        ImageIcon backgrIMG = null;
        if (i == 1) {
            backgrIMG = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\background_image.png");
        } else if (i == 2) {
            backgrIMG = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\Tauth.png");

            // Удаляем текстовые поля, чтобы они больше не отображались
            remove(LoginField);
            remove(PasswordField);
            remove(SubButt);
            // Очищаем переменные
            LoginField = null;
            PasswordField = null;
//            try {
//                Thread.sleep(5000); // Задержка на 2 секунды
//            } catch (InterruptedException e) {e.printStackTrace();}
//            dispose();
        } else {
            backgrIMG = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\Fauth.png");
        }
        label.setIcon(backgrIMG);
        revalidate(); // Обновляем контейнер после удаления компонентов
        repaint();    // Перерисовываем окно
    }

}
