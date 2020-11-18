package Visit;

import LBMS.Library;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ProxyLibrary extends Library {
    private Socket clientSocket;
    private ObjectInputStream networkIn;
    private ObjectOutputStream networkOut;

    public ProxyLibrary (String host, int port) {
        try {
            this.clientSocket = new Socket(host, port);
            this.networkIn = new ObjectInputStream(this.clientSocket.getInputStream());
            this.networkOut = new ObjectOutputStream(this.clientSocket.getOutputStream());

            networkOut.writeUnshared(new ConnectRequest());

            boolean proceed = false;
            while (!proceed) {
                Request request = (Request) this.networkIn.readUnshared();
                request.execute();
                System.out.println(request.getTextString());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}