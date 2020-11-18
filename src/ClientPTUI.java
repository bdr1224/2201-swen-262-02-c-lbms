import Books.Book;
import Books.BookList;
import Books.BookSearcher;
import Books.BookSorter;
import Books.OrderStrategies.OrderByCopies;
import Books.OrderStrategies.OrderByTitle;
import Books.SearchStrategies.SearchByTitle;

import java.util.*;

/**
 * This class represents the client and it performs
 * the operations that are going to be handled by the LBMS
 * @author Freddy Rondon
 */
public class ClientPTUI {

    public static void main(String[] args) {
        BookList books = new BookList("src/books.txt");
        System.out.println(books.toString());
    }
}
