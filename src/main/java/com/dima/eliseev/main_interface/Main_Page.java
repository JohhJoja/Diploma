package com.dima.eliseev.main_interface;

import static com.dima.eliseev.css.CSS.CSS_LoginFrame;
import javax.swing.*;

public class Main_Page extends JFrame {

    public Main_Page(){
        CSS_LoginFrame(this);
        setVisible(true);
        JLabel label = new JLabel("Дарова");
        label.setBounds(100,100,100,100);
        add(label);
    }

    public static void main(String[] args) {
        new Main_Page();
    }

}
