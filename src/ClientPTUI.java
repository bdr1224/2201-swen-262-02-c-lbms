import Books.BookList;
import LBMS.Library;

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
            System.out.println(LBMS.processRequest(in));
        } while (!in.equals("quit"));
    }
}
