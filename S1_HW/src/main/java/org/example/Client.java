package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    private final JTextField msgField = new JTextField("Введите Ваше сообщение");
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private JTextArea msgArea = new JTextArea();
    private JScrollPane scrollLog = new JScrollPane(msgArea);
    JPanel jPanelUserList = new JPanel(new FlowLayout());
    private static final String FILENAME = "Log.txt";

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

        //add(msgArea);
        msgField.grabFocus();
        msgField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                msgField.setText("");
            }
        });

        msgArea.setEditable(false);
        add(scrollLog);

        String[] users = {"Pavel", "Ivan", "Mariia",
                "Daria", "Oleg", "John", "Kate"};
        JList<String> userList = new JList<>(users);
        jPanelUserList.add(userList);
        add(jPanelUserList, BorderLayout.EAST);

        panelBotom.add(msgField, BorderLayout.CENTER);
        panelBotom.add(btnSend, BorderLayout.EAST);

        add(panelBotom, BorderLayout.SOUTH);


        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msgArea.setText(String.valueOf(readLogFromFile()));
            }
        });

        msgField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER){
                    btnSend.doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + ": " + msgField.getText() + "\n";
                msgArea.append(res);
                writeLogToFile(res);
                //msgArea.setText("");
            }
        });
    }

    private void writeLogToFile(String data){
        try (FileWriter writer = new FileWriter(Client.FILENAME, true); BufferedWriter bwr = new BufferedWriter(writer)) {
            bwr.write(data);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private StringBuffer readLogFromFile() {
        StringBuffer stringBuffer = new StringBuffer();
        try (FileReader reader = new FileReader(Client.FILENAME); BufferedReader brr = new BufferedReader(reader)) {

            String line = brr.readLine();
            if (line == null || line.isBlank()) {
                System.out.println("Log is empty.");
                return stringBuffer.append("Log is empty.\n");
            }

            while (line != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
                line = brr.readLine();
            }

            return stringBuffer;

        } catch (IOException ioe) {
            System.out.println("Log file is not found: " + FILENAME);
        }
        return stringBuffer.append("Log file is not found: " + FILENAME + "\n");
    }

}
