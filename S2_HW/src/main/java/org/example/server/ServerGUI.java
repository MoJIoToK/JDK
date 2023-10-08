package org.example.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerGUI extends JFrame implements ServerView {
    private static final int WIDTH = 555;
    private static final int HEIGHT = 507;
    private static final int WINDOW_POSX = 1000;
    private static final int WINDOW_POSY = 250;
    private static final JButton btnStart = new JButton("Start");
    private final String STATUS_OFF = "Server stopped";
    private final JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
    private final JPanel topPanel = new JPanel(new BorderLayout());
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea msgArea = new JTextArea();
    private final JTextField statusServer = new JTextField();
    private final JScrollPane scrollLog = new JScrollPane(msgArea);
    private final Server server;

    public ServerGUI(Server server) {
        this.server = server;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setAlwaysOnTop(true);
        setTitle("Chat server");
        createPanel();
        setVisible(true);
    }

    private void createPanel() {
        add(createBottomPanel(), BorderLayout.SOUTH);
        msgArea.setEditable(false);
        add(scrollLog);
        add(createTopPanel(), BorderLayout.NORTH);
    }

    private Component createTopPanel() {
        statusServer.setText(STATUS_OFF);
        topPanel.add(statusServer);
        return topPanel;
    }

    private Component createBottomPanel() {
        bottomPanel.add(btnStart);
        bottomPanel.add(btnStop);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startServer();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopServer();
            }
        });
        return bottomPanel;
    }

    private void startServer() {
        server.start();
    }

    private void stopServer() {
        server.stop();
    }

    @Override
    public void showLog(String text) {
        msgArea.append(text + "\n");
    }

    public void setStatus(String text) {
        statusServer.setText(text);
    }
}
