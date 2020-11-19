package Visit;

import LBMS.Library;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ProxyLibrary extends Library {
    private ObjectInputStream networkIn;
    private ObjectOutputStream networkOut;
    private int clientId;

    public ProxyLibrary(ObjectInputStream networkIn, ObjectOutputStream networkOut) {
        this.networkIn = networkIn;
        this.networkOut = networkOut;
        this.clientId = -1;
    }

    public void listen() {
        while(true) {
            try {
                Request<?> request = (Request<?>) networkIn.readObject();
                System.out.println("CLIENT REQUEST: " + request);

                switch ((String) request.getData()) {
                    case "connect;":
                        respond(new Response("connect," + this.clientId));
                        break;
                    default:
                        respond(new Response("unknown;"));
                        break;
                }
            } catch (IOException e) {
                Server.removeClient(this);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void respond(Response response) {
        try {
            networkOut.writeObject(response);
            networkOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setClientId(int id) { this.clientId = id; }

    public int getClientId() { return clientId; }
}