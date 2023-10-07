package org.example.client;

import org.example.Server;



public class Client  {

    private ClientView clientView;
    private static final String FILENAME = "Log.txt";
    private static boolean isLogin = false;
    Server server;
    private String name;

    Client(ClientView clientView,Server server){
        this.clientView = clientView;
        this.server = server;
    }

    private boolean connectToServer(String name){
        this.name = name;
        if (server.connectUser(this)){
            appendLog("You are successfully connected!\n");
            isLogin = true;
            String log = server.getLog();
            if (log != null){
                appendLog(log);
            }
            return true;
        } else {
            appendLog("Подключение не удалось");
        }
        return false;
    }

    public void disconnectFromServer(){
        if (isLogin){
            isLogin = false;
            clientView.disconnectFromServer();
            server.disconnectUser(this);
            appendLog("Вы были отключены от сервера!");
        }
    }

    public void sendMessage(String message){
        if (isLogin){
            if (!message.isEmpty()){
                server.message(name + ": " + message);
            }
        } else {
            appendLog("Нет подключения к серверу");
        }
    }

    public void serverAnswer(String text){
        appendLog(text);
    }

    private void appendLog(String text){
        clientView.showMessage(text);
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
