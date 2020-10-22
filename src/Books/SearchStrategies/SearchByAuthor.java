package Books.SearchStrategies;

import Books.Book;
import Books.BookSearcher;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteStrategy to search by Author
 *
 * @author Shantanav Saurav
 */
public class SearchByAuthor implements BookSearcher {
    
    /**
     * Function to search for a query by author
     * @param books list of books to search
     * @param query query string
     * @return list of books matched
     */
    public List<Book> searchFor(List<Book> books, String query) {
        List<Book> results = new ArrayList<>();
        // Lambda to iterate over books and add any matches to results list
        books.forEach(book -> { if (book.getAuthor().equals(query)) { results.add(book); } });
        return results;
    }
}
