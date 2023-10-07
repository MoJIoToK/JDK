package org.example.client;

import org.example.Server;

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
    //JPanel jPanelUserList = new JPanel(new FlowLayout());
    private static final String FILENAME = "Log.txt";
    private static boolean isLogin = false;
    Server server;
    private String name;

    ClientGUI(Server server){
        this.server = server;

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
//                isLogin = true;
//                if (server.isServerWorking){
//                    msgArea.setText(String.valueOf(readLogFromFile()));
//                } else {
//                    msgArea.setText("Server is stopped. Please try again later!");
//                }
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disconnectFromServer();
//                isLogin = false;
//                msgArea.setText("");
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
        if (server.connectUser(this)){
            appendLog("You are successfully connected!\n");
            isLogin = true;
            name = login.getText();
            String log = server.getLog();
            if (log != null){
                appendLog(log);
            }
        } else {
            appendLog("Подключение не удалось");
        }
    }

    @Override
    public void showMessage(String text) {

    }

    public void disconnectFromServer(){
        if (isLogin){
            isLogin = false;
            server.disconnectUser(this);
            appendLog("Вы были отключены от сервера!");
        }
    }

    public void sendMessage(){
        if (isLogin){
            String text = msgField.getText();
            if (!text.equals("")){
                server.message(name + ": " + text);
                //msgArea.setText("");
            }
        } else {
            appendLog("Нет подключения к серверу");
        }
    }

    public void answer(String text){
        appendLog(text);
    }

    private void appendLog(String text){
        msgArea.append(text + "\n");
    }


//    protected void writeLogToFile(String data){
//        try (FileWriter writer = new FileWriter(Client.FILENAME, true); BufferedWriter bwr = new BufferedWriter(writer)) {
//            bwr.write(data);
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//    }

//    protected static StringBuffer readLogFromFile() {
//        StringBuffer stringBuffer = new StringBuffer();
//        try (FileReader reader = new FileReader(Client.FILENAME); BufferedReader brr = new BufferedReader(reader)) {
//
//            String line = brr.readLine();
//            if (line == null || line.isBlank()) {
//                System.out.println("Log is empty.");
//                return stringBuffer.append("Log is empty.\n");
//            }
//
//            while (line != null) {
//                stringBuffer.append(line);
//                stringBuffer.append("\n");
//                line = brr.readLine();
//            }
//
//            return stringBuffer;
//
//        } catch (IOException ioe) {
//            System.out.println("Log file is not found: " + FILENAME);
//        }
//        return stringBuffer.append("Log file is not found: " + FILENAME + "\n");
//    }

}
