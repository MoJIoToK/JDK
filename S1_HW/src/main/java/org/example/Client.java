package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame {
    private static final int WIDTH = 555;
    private static final int HEIGHT = 507;
    private static final int WINDOW_POSX = 1000;
    private static final int WINDOW_POSY = 250;

    private JTextField ipAddress = new JTextField("ip address: ");
    private JTextField port = new JTextField("port: ");
    private JTextField login = new JTextField("login: ");
    private JTextField password = new JTextField("password: ");
    private final JPanel panelBotom = new JPanel(new BorderLayout());
    private final JButton btnSend = new JButton("Send");
    private final JButton btnLogin = new JButton("Login");
    private final JTextField msgField = new JTextField();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private JTextArea msgArea = new JTextArea();

    Client(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setAlwaysOnTop(true);
        setVisible(true);
        setTitle("Chat client");

        panelTop.add(ipAddress);
        panelTop.add(port);
        panelTop.add(login);
        panelTop.add(password);
        panelTop.add(btnLogin);

        add(panelTop, BorderLayout.NORTH);

        add(msgArea);
        msgArea.setEditable(false);

        panelBotom.add(msgField, BorderLayout.CENTER);
        panelBotom.add(btnSend, BorderLayout.EAST);

        add(panelBotom, BorderLayout.SOUTH);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });



    }



}
