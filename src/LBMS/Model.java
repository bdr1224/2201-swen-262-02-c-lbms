package LBMS;

import Books.BookList;
import Requests.RegisterRequest;
import Requests.Request;
import Requests.Response;
import Requests.VisitRequest;

public class Model {
    private BookList books;
    private Library LBMS;

    public Model () {
        this.books = new BookList("src/books.txt");
        this.LBMS = new Library(books);
    }

    public String[] processCommand(String query){
        if (query.equals("quit")) System.exit(0);
        Request request = processInput(query);
        String[] toPrint = new String[2];

        Response response = LBMS.processRequest(request);
        if(request != null) toPrint[0] = request.getTextString();
        else toPrint[0] = query;
        toPrint[1] = response.getTextString();
        return toPrint;
    }

    public static Request processInput(String in) {
        String[] params = in.split(",");
        switch(params[0]) {
            case "connect":
                return new VisitRequest(in);
            case "register":
                return new RegisterRequest(in);
            default: return null;
        }
    }

}
