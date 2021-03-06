import Books.BookList;
import GUI.Login;
import LBMS.Library;
import LBMS.Model;
import Requests.RegisterRequest;
import Requests.Request;
import Requests.Response;
import Requests.VisitRequest;
import Visit.LocalLibrary;

import javax.swing.*;
import java.util.Scanner;

/**
 * This class represents the client and it performs
 * the operations that are going to be handled by the LBMS
 * @author Freddy Rondon
 * @author Shantanav Saurav
 */
public class ClientPTUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame ();
        Model model = new Model();
        JPanel loginPanel = new Login(frame, model);

        BookList books = new BookList("src/books.txt");
        Library LBMS = new LocalLibrary(books);
        Scanner input = new Scanner(System.in);
        String in = "";
        do {
            System.out.print(">>> ");
            in = input.nextLine();
            Request request = processInput(in);
            Response response = LBMS.processRequest(request);
            if(request != null) System.out.println("Req: " + request.getTextString());
            System.out.println("Res: " + response.getTextString());
        } while (!in.equals("quit"));
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
