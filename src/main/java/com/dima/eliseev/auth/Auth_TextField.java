package com.dima.eliseev.auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.RoundRectangle2D;

class Auth_TextField extends JTextField {
    private int arcSize = 10; // Радиус скругления углов
    private String placeholder; // Текст плейсхолдера

    public Auth_TextField(String placeholder, int columns, int y) {
        super(columns);
        this.placeholder = placeholder;

        setOpaque(false); // Отключаем стандартную заливку
        setMargin(new Insets(0, 10, 0, 0)); // Отступ слева на 10 пикселей
        setBounds(125, y, 245, 33);

        // Добавляем слушатель фокуса для обработки плейсхолдера
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                repaint(); // Перерисовываем поле при фокусе
            }

            @Override
            public void focusLost(FocusEvent e) {
                repaint(); // Перерисовываем поле при потере фокуса
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Заливка фона
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), arcSize, arcSize));

        super.paintComponent(g);

        // Рисуем плейсхолдер, если поле пустое и не в фокусе
        if (getText().isEmpty() && !isFocusOwner()) {
            g2.setFont(getFont().deriveFont(Font.ITALIC));
            g2.setColor(Color.GRAY);
            g2.drawString(placeholder, getInsets().left, getHeight() / 2 + getFont().getSize() / 2 - 2);
        }

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Чёрный контур
        g2.setColor(Color.BLACK);
        g2.draw(new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize));

        g2.dispose();
    }
}
