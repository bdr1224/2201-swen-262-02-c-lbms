package Books.OrderStrategies;

import Books.Book;
import Books.BookSorter;

import java.util.Comparator;
import java.util.List;

public class OrderByTitle implements BookSorter {

    public List<Book> sortBy(List<Book> books) {
        books.sort(Comparator.comparing(Book::getTitle));
        return books;
    }

}
