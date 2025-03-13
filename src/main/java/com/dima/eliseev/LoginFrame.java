package com.dima.eliseev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    String backgraund_img_path = "E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\background_image.png";

    public LoginFrame() {

        setTitle("Login");
        setSize(495, 520);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Устанавливаем иконку окна
        ImageIcon img = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\img.jpg");
        setIconImage(img.getImage());

        // Отключаем стандартный LayoutManager
        setLayout(null);

        // Фон
        JLabel label = new JLabel();
        ImageIcon backgrIMG = new ImageIcon(backgraund_img_path);
        label.setIcon(backgrIMG);
        label.setBounds(0, 0, 495, 520); // Указываем размер фона

        // Добавляем фон
        add(label);

        setVisible(true);

        new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isAuth(true);
                label.setIcon(new ImageIcon(backgraund_img_path)); // Меняем фон
            }
        }).start();
    }

    private void isAuth(boolean A){
        if (A){
            backgraund_img_path = "E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\Tauth.png";
        } else{
            backgraund_img_path = "E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\Fauth.png";
        }
    }

}
