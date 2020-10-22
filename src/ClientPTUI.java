import Books.Book;
import Books.BookSorter;
import Books.OrderStrategies.OrderByTitle;

import java.util.*;

/**
 * This class represents the client and it performs
 * the operations that are going to be handled by the LBMS
 * @author Freddy Rondon
 */
public class ClientPTUI {

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        for (int i=0; i < 10; i++){
            books.add(new Book("Book #"+i,
                    "Author #"+i,
                    "ISBN #"+i,
                    100+i,
                    5+i,
                    0,
                    new Date(2008,  11, 21)));
        }

        BookSorter bookSorter = new OrderByTitle();
        bookSorter.sortBy(books);
        for (Book b: books) {
            System.out.println(b);
        }

    }


}
