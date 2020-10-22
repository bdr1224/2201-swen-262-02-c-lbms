package Books.OrderStrategies;

import Books.Book;
import Books.BookSorter;

import java.util.Comparator;
import java.util.List;

public class OrderByPages implements BookSorter {

    public List<Book> sortBy(List<Book> books) {
        books.sort(Comparator.comparing(Book::getPages));
        return books;
    }

}
