package com.dima.eliseev;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;

class Buttom extends JButton implements ActionListener {

    JTextField log;
    JTextField pass;

    public Buttom(String text, JTextField log, JTextField pass, int y){
        super(text); // Устанавливаем текст кнопки
        setFocusPainted(false); // Убираем рамку фокуса
        setContentAreaFilled(false); // Убираем стандартную заливку
        setBorderPainted(false); // Убираем стандартную границу
        setOpaque(false); // Отключаем непрозрачность
        setFont(new Font("Arial", Font.BOLD, 14)); // Шрифт
        setForeground(Color.WHITE); // Цвет текста
        setBounds(167, y, 149, 40); // Размещение кнопки
        setBackground(new Color(0x0C2F54));
        addActionListener(this);

        this.log = log;
        this.pass = pass;
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Чёрный контур кнопки
        g2.setColor(Color.BLACK);
        // Радиус скругления углов
        int arcSize = 38;
        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize));
        g2.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this){
            String login = log.getText();
            String password = pass.getText();
            int hash = login.hashCode();

            System.out.println(login +" "+password+" "+hash);

            log.setText("");
            pass.setText("");
        }
    }
}