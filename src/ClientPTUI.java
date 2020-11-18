import Books.Book;
import Books.BookSearcher;
import Books.BookSorter;
import Books.OrderStrategies.OrderByCopies;
import Books.OrderStrategies.OrderByTitle;
import Books.SearchStrategies.SearchByTitle;
import LBMS.Library;
import Visit.LibraryUI;

import java.lang.reflect.Array;
import java.util.*;

/**
 * This class represents the client and it performs
 * the operations that are going to be handled by the LBMS
 * @author Freddy Rondon
 */
public class ClientPTUI {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        Random random = new Random();

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        LibraryUI libraryUI = new LibraryUI(host, port);

        for (int i=0; i < 10; i++){
            ArrayList<String> author = new ArrayList<>();
            author.add("Author #" + i);
            books.add(new Book("Book #" + i,
                    author,
                    random.nextInt(1000)+"-"
                            +random.nextInt(10)+"-"
                            +random.nextInt(100)+"-"
                            +random.nextInt(1000000)+"-"
                            +random.nextInt(10),
                    random.nextInt(1000),
                    random.nextInt(100),
                    0,
                    new Date(2008,  11, 21)));
        }

        // Sort by Title
        BookSorter bookSorter = new OrderByTitle();
        bookSorter.sortBy(books);
        System.out.println("Books sorted by Title:");
        for (Book b: books) {
            System.out.println(b);
        }

        // Sort by Copies
        bookSorter = new OrderByCopies();
        bookSorter.sortBy(books);
        System.out.println("\nBooks sorted by Copies:");
        for (Book b: books) {
            System.out.println(b);
        }

        // Search By title
        BookSearcher bookSearcher = new SearchByTitle();
        List<Book> result = bookSearcher.searchFor(books,"Book #2");
        System.out.println("\nBooks search by Title:");
        for (Book b : result) {
            System.out.println(b);
        }


    }


}
