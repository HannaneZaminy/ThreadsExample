package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    static List<ClientHandler> allClients = new ArrayList<>();
    static int counter = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1040);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client requested : " + socket);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String clientName = "client " + counter;
            ClientHandler clientHandler = new ClientHandler(dos, dis, socket, clientName);
            Thread clientThread = new Thread(clientHandler);
            clientThread.start();

            System.out.println("Adding " + clientName + " to all clients list");
            allClients.add(clientHandler);

            counter++;
        }
    }
}
