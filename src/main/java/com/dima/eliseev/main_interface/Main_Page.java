package com.dima.eliseev.main_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_Page extends JFrame {
    private JList<String> leftList;
    private DefaultListModel<String> leftListModel;
    private JList<String> rightList;
    private DefaultListModel<String> rightListModel;
    private JTextField searchField;

    public Main_Page() {
        setTitle("Адаптивный Фрейм");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Разворачиваем на весь экран
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Верхний бар с меню
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createMenu("Файл"));
        menuBar.add(createMenu("Редактировать"));
        menuBar.add(createMenu("Справка"));
        setJMenuBar(menuBar);

        // Основной контейнер (левый и правый блоки)
        JSplitPane mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainSplitPane.setResizeWeight(0.3); // Левый блок занимает 30% ширины

        // Левый список (можно кликать)
        leftListModel = new DefaultListModel<>();
        leftListModel.addElement("Элемент 1");
        leftListModel.addElement("Элемент 2");
        leftListModel.addElement("Элемент 3");
        leftList = new JList<>(leftListModel);
        leftList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        leftList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedValue = leftList.getSelectedValue();
                JOptionPane.showMessageDialog(this, "Вы выбрали: " + selectedValue);
            }
        });

        // Оборачиваем список в панель с прокруткой
        JScrollPane leftScrollPane = new JScrollPane(leftList);
        mainSplitPane.setLeftComponent(leftScrollPane);

        // Правый контейнер (поиск + список элементов)
        JPanel rightPanel = new JPanel(new BorderLayout());

        // Строка поиска
        searchField = new JTextField();
        searchField.addActionListener(e -> filterRightList());

        rightPanel.add(searchField, BorderLayout.NORTH);

        // Список с элементами (несколько полей)
        rightListModel = new DefaultListModel<>();
        for (int i = 1; i <= 10; i++) {
            rightListModel.addElement("Запись " + i + " | Поле 1: X | Поле 2: Y");
        }
        rightList = new JList<>(rightListModel);
        JScrollPane rightScrollPane = new JScrollPane(rightList);

        rightPanel.add(rightScrollPane, BorderLayout.CENTER);

        // Добавляем правый контейнер в основной
        mainSplitPane.setRightComponent(rightPanel);

        // Добавляем основной контейнер в окно
        getContentPane().add(mainSplitPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Создание меню
    private JMenu createMenu(String name) {
        JMenu menu = new JMenu(name);
        JMenuItem item1 = new JMenuItem(name + " -> Действие 1");
        JMenuItem item2 = new JMenuItem(name + " -> Действие 2");
        menu.add(item1);
        menu.add(item2);
        return menu;
    }

    // Фильтрация списка справа
    private void filterRightList() {
        String filterText = searchField.getText().toLowerCase();
        rightListModel.clear();
        for (int i = 1; i <= 10; i++) {
            String item = "Запись " + i + " | Поле 1: X | Поле 2: Y";
            if (item.toLowerCase().contains(filterText)) {
                rightListModel.addElement(item);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main_Page::new);
    }
}
