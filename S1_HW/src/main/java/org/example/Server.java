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
    private JPanel topPanel = new JPanel(new BorderLayout());
    private static JButton btnStart = new JButton("Start");
    private JButton btnStop = new JButton("Stop");
    private JTextArea msgArea = new JTextArea();
    private JTextField statusServer = new JTextField();
    private JScrollPane scrollLog = new JScrollPane(msgArea);
    protected static boolean isServerWorking;

    private final String STATUS_OFF = "Server stopped";
    private final String STATUS_YET_OFF = "Server is already stopped";
    private final String STATUS_ON = "Server is started";
    private final String STATUS_YET_ON = "Server is already running";

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

        statusServer.setText(STATUS_OFF);
        topPanel.add(statusServer);
        add(topPanel, BorderLayout.NORTH);
        msgArea.setEditable(false);
        add(scrollLog);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    statusServer.setText(STATUS_YET_ON);
                } else {
                    statusServer.setText(STATUS_ON);
                    msgArea.setText(String.valueOf(Client.readLogFromFile()));
                }
                isServerWorking = true;
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!isServerWorking) {
                    statusServer.setText(STATUS_YET_OFF);
                } else {
                    statusServer.setText(STATUS_OFF);
                }
                isServerWorking = false;
            }
        });

    }

}
