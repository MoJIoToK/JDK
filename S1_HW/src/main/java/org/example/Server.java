package org.example;

import javax.swing.*;
import java.awt.*;

public class Server extends JFrame {
    private static final int WIDTH = 555;
    private static final int HEIGHT = 507;
    private static final int WINDOW_POSX = 1000;
    private static final int WINDOW_POSY = 250;

    private JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
    private JButton btnStart = new JButton("Start");
    private JButton btnStop = new JButton("Stop");
    private JTextArea msgArea = new JTextArea();

    Server(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setAlwaysOnTop(true);
        setVisible(true);
        setTitle("Chat server");

        bottomPanel.add(btnStart);
        bottomPanel.add(btnStop);
        add(bottomPanel, BorderLayout.SOUTH);

        add(msgArea);
        msgArea.setEditable(false);
    }
}
