package Visit;

import java.io.Serializable;

public class ConnectRequest<E extends Serializable> extends Request {
    public ConnectRequest(E data) {
        super(data);
    }

    @Override
    public boolean execute() {
        System.out.println("LOGIN REQUEST EXECUTE");

        return super.execute();
    }

    @Override
    public String toString() {
        return "Connect" + super.toString();
    }
}
