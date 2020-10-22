package Books.OrderStrategies;

import Books.Book;
import Books.BookSorter;

import java.util.Comparator;
import java.util.List;

public class OrderByCopies implements BookSorter {

    public List<Book> sortBy(List<Book> books) {
        books.sort(Comparator.comparing(Book::getCopies));
        return books;
    }

}
