package Visit;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

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

                System.out.println("Server started up, listening for clients...");
                connectClients();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private static void connectClients() throws  IOException {
        clients = new ArrayList<>();

        while (true) {
            Socket clientSocket = serverSocket.accept();

            ObjectOutputStream networkOut = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream networkIn = new ObjectInputStream(clientSocket.getInputStream());

            ProxyLibrary client = new ProxyLibrary(networkIn, networkOut);

            addClient(client);

            client.listen();
        }
    }

    private static int addClient(ProxyLibrary client) {
        if(client.getClientId() == -1) {
            boolean randClientId = false;
            int id = -1;
            while(!randClientId) {
                Random rand = new Random();
                id = rand.nextInt();
                boolean failed = false;
                for (ProxyLibrary c : clients) {
                    if (c.getClientId() == client.getClientId()) failed = true;
                }
                if(!failed) randClientId = true;
            }

            client.setClientId(id);
            clients.add(client);

            return id;
        }
        return -1;
    }

    public static void removeClient(ProxyLibrary client) { clients.remove(client); }
}
