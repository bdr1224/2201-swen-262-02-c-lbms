package Visit;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static ServerSocket serverSocket;
    private static ArrayList<ProxyLibrary> clients;

    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Program arguments: 'port'");
        } else {
            try {
                int port = Integer.parseInt(args[0]);

                serverSocket = new ServerSocket(port);
                connectClients();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void connectClients() throws IOException {
        clients = new ArrayList<>();

        while(true) {
            Socket clientSocket = serverSocket.accept();

            ObjectInputStream networkIn = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream networkOut = new ObjectOutputStream(clientSocket.getOutputStream());

            ProxyLibrary proxyLibrary = new ProxyLibrary()
        }
    }
}
