package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("localhost", 1040);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        Thread readMessage = new Thread(() -> {
            while (true) {
                try {
                    String msg = dis.readUTF();
                    if (msg.equals("exit")) {
                        break;
                    }
                    System.out.println(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread sendMessage = new Thread(() -> {
            while (true) {
                try {
                    String msg = scanner.nextLine();
                    dos.writeUTF(msg);
                    if (msg.equals("exit")) {
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        readMessage.start();
        sendMessage.start();

    }
}
