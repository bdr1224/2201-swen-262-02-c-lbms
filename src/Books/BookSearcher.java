package Books;

import java.util.List;

/**
 * Strategy interface to search for books
 *
 * @author Shantanav Saurav
 */
public interface BookSearcher {
    /**
     * Function to search for a query
     * @param books list of books to search
     * @param query query string
     * @return List of books that match query
     */
    List<Book> searchFor(List<Book> books, String query);
}
