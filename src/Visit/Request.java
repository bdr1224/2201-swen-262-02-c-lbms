package Visit;

import java.io.Serializable;

public class Request<E extends Serializable> implements Serializable {
    private E data;

    public Request(E data) {
        this.data = data;
    }

    public boolean execute() {
        return false;
    }

    public E getData() { return data; }

    @Override
    public String toString() {
        return "Request{" +
                "data=" + data +
                '}';
    }
}
