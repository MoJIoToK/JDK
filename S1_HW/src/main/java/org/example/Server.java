package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server extends JFrame {
    private static final int WIDTH = 555;
    private static final int HEIGHT = 507;
    private static final int WINDOW_POSX = 1000;
    private static final int WINDOW_POSY = 250;

    private JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
    private JButton btnStart = new JButton("Start");
    private JButton btnStop = new JButton("Stop");
    private JTextArea msgArea = new JTextArea();
    private static boolean isServerWorking;

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

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    msgArea.setText("Server is already running.");
                } else {
                    msgArea.setText("Server is started.");;
                }
                isServerWorking = true;
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!isServerWorking) {
                    msgArea.setText("Server is already stopped.");
                } else {
                    msgArea.setText("Server stopped.");
                }
                isServerWorking = false;
            }
        });

    }
}
