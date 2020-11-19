package Visit;

import java.io.Serializable;

public class Response<E extends Serializable> implements Serializable {
    private E data;

    public Response(E data) {
        this.data = data;
    }

    public E getData() { return data; }

    @Override
    public String toString() {
        return "Response{" +
                "data=" + data +
                '}';
    }
}
