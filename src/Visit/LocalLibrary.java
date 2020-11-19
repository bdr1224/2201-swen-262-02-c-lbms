package Visit;

import LBMS.Library;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class LocalLibrary extends Library {
    private Socket clientSocket;
    private ObjectInputStream networkIn;
    private ObjectOutputStream networkOut;
    private boolean run;

    public LocalLibrary (String host, int port) {
        try {
            this.clientSocket = new Socket(host, port);
            this.networkOut = new ObjectOutputStream(this.clientSocket.getOutputStream());
            this.networkIn = new ObjectInputStream(this.clientSocket.getInputStream());
            this.run = true;

            connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        try {
            networkOut.writeObject(new ConnectRequest());

            boolean proceed = false;
            while (!proceed) {
                Response<?> response = (Response<?>) this.networkIn.readObject();
                System.out.println(response.getData());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void shutDown() {
        try {
            clientSocket.shutdownOutput();
            clientSocket.shutdownInput();
            clientSocket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}