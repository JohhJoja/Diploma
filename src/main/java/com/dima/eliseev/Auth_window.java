package com.dima.eliseev;

import javax.swing.*;
import java.awt.*;

public class Auth_window extends JFrame {

    public Auth_window() throws HeadlessException {

        setVisible(true);
        ImageIcon img = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\img.jpg");
        setIconImage(img.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setSize(495,520);
        setResizable(false);

        JLabel label = new JLabel();
        ImageIcon backgrIMG = new ImageIcon("E:\\Java\\deeplomka\\OHPTIIFVOD\\src\\main\\java\\com\\dima\\eliseev\\background_image.png");
        label.setIcon(backgrIMG);

        add(label);




    }
}
