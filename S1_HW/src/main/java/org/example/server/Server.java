package org.example.server;

import org.example.client.Client;

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Server {
//    private static final int WIDTH = 555;
//    private static final int HEIGHT = 507;
//    private static final int WINDOW_POSX = 1000;
//    private static final int WINDOW_POSY = 250;
//
//    private JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
//    private JPanel topPanel = new JPanel(new BorderLayout());
//    private static JButton btnStart = new JButton("Start");
//    private JButton btnStop = new JButton("Stop");
//    private JTextArea msgArea = new JTextArea();
//    private JTextField statusServer = new JTextField();
//    private JScrollPane scrollLog = new JScrollPane(msgArea);

    private final String STATUS_OFF = "Server stopped";
    private final String STATUS_YET_OFF = "Server is already stopped";
    private final String STATUS_ON = "Server is started";
    private final String STATUS_YET_ON = "Server is already running";
    protected static boolean isServerWorking;
    private ServerView serverView;
    private ServerGUI serverGUI;
//    private final String STATUS_OFF = "Server stopped";
//    private final String STATUS_YET_OFF = "Server is already stopped";
//    private final String STATUS_ON = "Server is started";
//    private final String STATUS_YET_ON = "Server is already running";
    ArrayList<Client> clientList;
    public static final String LOG_PATH = "Log.txt";

    public Server(){
        this.serverView = new ServerGUI(this);
        clientList = new ArrayList<>();
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(WIDTH, HEIGHT);
//        setLocation(WINDOW_POSX, WINDOW_POSY);
//        setAlwaysOnTop(true);
//        setTitle("Chat server");
//
//        createPanel();
//        setVisible(true);
    }

//    private void createPanel() {
//        add(createBottomPanel(), BorderLayout.SOUTH);
//        msgArea.setEditable(false);
//        add(scrollLog);
//        add(createTopPanel(), BorderLayout.NORTH);
//
//    }

//    private Component createTopPanel() {
//        statusServer.setText(STATUS_OFF);
//        topPanel.add(statusServer);
//        return topPanel;
//    }
//
//    private Component createBottomPanel() {
//        bottomPanel.add(btnStart);
//        bottomPanel.add(btnStop);
//        btnStart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (isServerWorking) {
//                    statusServer.setText(STATUS_YET_ON);
//                } else {
//                    statusServer.setText(STATUS_ON);
//                    msgArea.setText(readLog());
//                }
//                isServerWorking = true;
//            }
//        });
//
//        btnStop.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                if (!isServerWorking) {
//                    statusServer.setText(STATUS_YET_OFF);
//                } else {
//                    statusServer.setText(STATUS_OFF);
//                }
//                isServerWorking = false;
//            }
//        });
//        return bottomPanel;
//    }

    public boolean connectUser(Client client){
        if(!serverGUI.isServerWorking){
            return false;
        }
        clientList.add(client);
        return true;
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if(clientList != null){
            client.disconnect();
        }
    }

    public void message(String text){
        if (!isServerWorking){
            return;
        }
        text +="";
        printText(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.serverAnswer(text);
        }
    }

    private void printText(String text){
        serverView.showLog(text + "\n");
        //msgArea.append(text + "\n");
    }

    public String getLog() {
        return readLog();
    }

    private void saveInLog(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    public void start() {
//        if (isServerWorking) {
//            serverGUI.setStatus(STATUS_YET_ON);
//        } else {
//            serverGUI.setStatus(STATUS_ON);
//            serverView.showLog(getLog());
//        }
//        isServerWorking = true;
//    }
}
