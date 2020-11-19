package Visit;

import Books.BookList;
import LBMS.Library;
import Requests.Request;
import Requests.Response;

public class LocalLibrary extends Library {
    ProxyLibrary libraryProxy;

    public LocalLibrary(BookList books) {
        super(books);
        this.libraryProxy = new ProxyLibrary(books);
    }

    @Override
    public Response processRequest(Request req) {
        return libraryProxy.request(req);
    }
}
