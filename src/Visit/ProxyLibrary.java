package Visit;

import LBMS.Library;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ProxyLibrary extends Library {
    private ServerSocket serverSocket;
    private int port;
    private ObjectInputStream networkIn;
    private ObjectOutputStream networkOut;
    private ArrayList<LocalLibrary> clients;

    public ProxyLibrary(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            this.serverSocket = new ServerSocket(this.port);
            Socket clientSocket = serverSocket.accept();

            this.networkOut = new ObjectOutputStream(clientSocket.getOutputStream());
            this.networkIn = new ObjectInputStream(clientSocket.getInputStream());

            listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        while(true) {
            try {
                Request request = (Request) networkIn.readObject();
                System.out.println(request.getTextString());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}