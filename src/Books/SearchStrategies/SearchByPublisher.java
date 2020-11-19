package Books.SearchStrategies;

import Books.Book;
import Books.BookSearcher;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteStrategy to search by Publisher
 *
 * @author Shantanav Saurav
 */
public class SearchByPublisher implements BookSearcher {
    
    /**
     * Function to search for a query
     * @param books list of books to search
     * @param query query string
     * @return List of books that match query
     */
    public List<Book> searchFor(List<Book> books, String query) {
        List<Book> results = new ArrayList<>();
        // Lambda to iterate over books and add any matches to results list
        books.forEach(book -> { if (book.getPublisher().equals(query)) { results.add(book); } });
        return results;
    }
}
