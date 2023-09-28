package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");
    Map map;
    SettingsWindow settings;
    //Конструктор:
    GameWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);//команда которая говорит что делать при нажатии на крестик
        //Программа завершается при закрытии окна
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe"); //Заголовок
        setResizable(false); //запрет пользователю менять размер окна

        map = new Map();
        settings = new SettingsWindow(this); //Передаем методу объект, который вызывает этот метод.Основное окно передает ссылку на себя
        settings.setVisible(true);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JPanel panBottom = new JPanel(new GridLayout(1,2)); //создание экземляра панели
        panBottom.add(btnStart); //add button, экземляр класса компонент
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH); //панель помещается поверх компонента, а на панели две кнопки
        add(map);
        setVisible(true);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
