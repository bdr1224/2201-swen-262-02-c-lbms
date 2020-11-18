import Books.Book;
import Books.BookList;
import Books.OrderStrategies.*;
import Books.SearchStrategies.*;

/**
 * This class represents the client and it performs
 * the operations that are going to be handled by the LBMS
 * @author Freddy Rondon
 * @author Shantanav Saurav
 */
public class ClientPTUI {

    public static void main(String[] args) {
        BookList books = new BookList("src/books.txt");
        books.setSearcher(new SearchByAuthor());
        books.setSorter(new OrderByTitle());
        books.search("J.K. Rowling").forEach(book -> System.out.println(book.toString()));
    }
}
