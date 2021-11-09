package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    DataOutputStream dos;
    DataInputStream dis;
    Socket socket;
    String clientName;
    boolean isExit = false;

    public ClientHandler(DataOutputStream dos, DataInputStream dis, Socket socket, String clientName) {
        this.dos = dos;
        this.dis = dis;
        this.socket = socket;
        this.clientName = clientName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String clientMsg = dis.readUTF();
                System.out.println(clientName + " Message : " + clientMsg);

                if (clientMsg.equals("exit")) {
                    this.isExit = true;
                    dos.writeUTF("exit");
                    this.socket.close();
                    break;
                }

                if (clientMsg.contains("#")) {
                    String[] split = clientMsg.split("#");
                    String msgText = split[0];
                    String recipient = split[1];

                    for (ClientHandler handler : Server.allClients) {
                        if (handler.clientName.equals(recipient)) {
                            if (!handler.isExit) {
                                handler.dos.writeUTF("New Message From " + this.clientName + " : " + msgText);
                                break;
                            } else {
                                dos.writeUTF(handler.clientName + " exited!");
                            }
                        }
                    }
                } else {
                    dos.writeUTF("Write message in this format : {message}#{client_name}");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            dos.close();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
