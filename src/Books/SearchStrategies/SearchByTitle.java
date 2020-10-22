package Books.SearchStrategies;

import Books.Book;
import Books.BookSearcher;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteStrategy to search by title
 *
 * @author Shantanav Saurav
 */
public class SearchByTitle implements BookSearcher {
    
    /**
     * Function to search for a query by title
     * @param books list of books to search
     * @param query query string
     * @return list of books matched
     */
    public List<Book> searchFor(List<Book> books, String query) {
        List<Book> results = new ArrayList<>();
        // Lambda to iterate over books and add any matches to results list
        books.forEach(book -> { if (book.getTitle().equals(query)) { results.add(book); } });
        return results;
    }
}
