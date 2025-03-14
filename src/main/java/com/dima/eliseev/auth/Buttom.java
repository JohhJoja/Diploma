package com.dima.eliseev.auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import static com.dima.eliseev.css.CSS.CSS_Buttom;

class Buttom extends JButton implements ActionListener {

    JTextField log;
    JTextField pass;
    LoginFrame FRAME;

    public Buttom(String text, JTextField log, JTextField pass, int y, LoginFrame FRAME){
        super(text); // Устанавливаем текст кнопки
        CSS_Buttom(this, y);
        this.log = log;
        this.pass = pass;
        this.FRAME = FRAME;
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        int arcSize = 38;
        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize));
        g2.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this){
            String login = log.getText();
            String password = pass.getText();
            int hash = login.hashCode() + password.hashCode();

            // Создаем объект DatabaseManager и передаем ему необходимые параметры
            new DatabaseManager(login, password, hash, FRAME);

            log.setText("");
            pass.setText("");
        }
    }
}
