package org.example.client;

import org.example.server.Server;
import org.example.server.ServerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame implements ClientView {
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
    private final JButton btnLogout = new JButton("Logout");
    private final JTextField msgField = new JTextField("Введите Ваше сообщение");
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private JTextArea msgArea = new JTextArea();
    private JScrollPane scrollLog = new JScrollPane(msgArea);
    private static boolean isLogin = false;
    Server server;
    private String name;
    private Client client;

    public ClientGUI(Server server){
        this.client = new Client(this, server);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setAlwaysOnTop(true);
        setTitle("Chat client");
        createPanel();
        setVisible(true);
    }

    private void createPanel(){
        add(createPanelTop(), BorderLayout.NORTH);
        add(scrollLog);
        add(createPanelBotom(), BorderLayout.SOUTH);
    }

    private Component createPanelTop(){
        panelTop.add(ipAddress);
        panelTop.add(port);
        panelTop.add(login);
        panelTop.add(password);
        panelTop.add(btnLogin);
        panelTop.add(btnLogout);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });
        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disconnectFromServer();
            }
        });
        return panelTop;
    }

    private Component createPanelBotom() {
        msgField.grabFocus();
        msgField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                msgField.setText("");
            }
        });
        msgArea.setEditable(false);
        panelBotom.add(msgField, BorderLayout.CENTER);
        panelBotom.add(btnSend, BorderLayout.EAST);
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        msgField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n'){
                    btnSend.doClick();
                }
            }
        });
        return panelBotom;
    }

    private void connectToServer(){
        client.connectToServer(login.getText());
    }

    @Override
    public void showMessage(String text) {
        appendLog(text);
    }

    public void disconnectFromServer(){
        client.disconnect();
    }

    public void sendMessage(){
        client.sendMessage(msgField.getText());
        msgArea.setText("");
    }

    private void appendLog(String text){
        msgArea.append(text + "\n");
    }
}
