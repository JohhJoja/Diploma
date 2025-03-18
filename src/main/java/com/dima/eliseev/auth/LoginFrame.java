package com.dima.eliseev.auth;

import com.dima.eliseev.main_interface.Main_Page;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private static JLabel label;
    private Auth_TextField LoginField;
    private Auth_TextField PasswordField;
    private Buttom SubButt;
    private Timer closeTimer; // Добавляем переменную для таймера

    public LoginFrame() {
        setTitle("Login");
        setSize(495, 520);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);

        // Создаём текстовое поле и кнопку
        LoginField = new Auth_TextField("USERNAME", 7, 194);
        PasswordField = new Auth_TextField("PASSWORD", 7, 241);
        SubButt = new Buttom("submit", LoginField, PasswordField, 299, this);

        PasswordField.SetClick(SubButt);

        add(LoginField);
        add(PasswordField);
        add(SubButt);

        // Фон
        label = new JLabel();
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
            backgrIMG = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\images\\background_image.png");
        } else if (i == 2) {
            backgrIMG = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\images\\Tauth.png");

            // Удаляем текстовые поля, чтобы они больше не отображались
            remove(LoginField);
            remove(PasswordField);
            remove(SubButt);

            LoginField = null;
            PasswordField = null;
            SubButt = null;

            // Проверяем, запущен ли уже таймер
            if (closeTimer == null || !closeTimer.isRunning()) {
                closeTimer = new Timer(2000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose(); // Закрываем окно
                        new Main_Page(); // Открываем главное окно
                        closeTimer.stop(); // Останавливаем таймер
                    }
                });
                closeTimer.setRepeats(false); // Таймер сработает только один раз
                closeTimer.start();
            }

        } else {
            backgrIMG = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\images\\Fauth.png");
        }
        label.setIcon(backgrIMG);
        revalidate();
        repaint();
    }
}
