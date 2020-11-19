import Books.BookList;
import LBMS.Library;
import Requests.RegisterRequest;
import Requests.Request;
import Requests.Response;
import Requests.VisitRequest;

import java.util.Scanner;

/**
 * This class represents the client and it performs
 * the operations that are going to be handled by the LBMS
 * @author Freddy Rondon
 * @author Shantanav Saurav
 */
public class ClientPTUI {

    public static void main(String[] args) {
        BookList books = new BookList("src/books.txt");
        Library LBMS = new Library(books);
        Scanner input = new Scanner(System.in);
        String in = "";
        do {
            System.out.print(">>> ");
            in = input.nextLine();
            Request request = processInput(in);
            if(request != null) {
                Response response = LBMS.processRequest(request);
                System.out.println(request.getTextString());
                System.out.println(response.getTextString());
            } else System.out.println("Unrecognized command!");
        } while (!in.equals("quit"));
    }

    public static Request processInput(String in) {
        String[] params = in.split(",");
        switch(params[0]) {
            case "connect":
                return new VisitRequest("connect");
            case "register":
                return new RegisterRequest("register");
            default: return null;
        }
    }
}
