package org.example.server;

import org.example.client.Client;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Server {

    public static final String LOG_PATH = "Log.txt";
    protected static boolean isServerWorking;
    private final String STATUS_OFF = "Server stopped";
    private final String STATUS_YET_OFF = "Server is already stopped";
    private final String STATUS_ON = "Server is started";
    private final String STATUS_YET_ON = "Server is already running";
    ArrayList<Client> clientList;
    private final ServerView serverView;

    public Server() {
        this.serverView = new ServerGUI(this);
        clientList = new ArrayList<>();
    }

    public void start() {
        if (isServerWorking) {
            serverView.setStatus(STATUS_YET_ON);
        } else {
            serverView.setStatus(STATUS_ON);
            serverView.showLog(getLog());
        }
        isServerWorking = true;
    }

    public void stop() {
        if (!isServerWorking) {
            serverView.setStatus(STATUS_YET_OFF);
        } else {
            serverView.setStatus(STATUS_OFF);
        }
        isServerWorking = false;
    }

    public boolean connectUser(Client client) {
        if (!isServerWorking || clientList.contains(client)) {
            return false;
        }
        clientList.add(client);
        return true;
    }

    public void disconnectUser(Client client) {
        clientList.remove(client);
        if (clientList != null) {
            client.disconnect();
        }
    }

    public void message(String text) {
        if (!isServerWorking) {
            return;
        }
        text += "";
        printText(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text) {
        for (Client client : clientList) {
            client.serverAnswer(text);
        }
    }

    private void printText(String text) {
        serverView.showLog(text);
    }

    public String getLog() {
        return readLog();
    }

    private void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
