package Visit;

import Books.BookList;
import LBMS.Library;
import Requests.Request;
import Requests.Response;

public class ProxyLibrary extends Library {
    public ProxyLibrary(BookList books) {
        super(books);
    }

    public Response request(Request r) {
        if(r == null) return new Response("Unknown command");
        return r.execute(this);
    }
}
