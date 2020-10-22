package Books;

import java.util.List;

/**
 * Strategy for sorting methods
 *
 * @author Owen Racette
 */
public interface BookSorter {

    List<Book> sortBy(List<Book> book);

}
