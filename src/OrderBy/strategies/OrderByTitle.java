package OrderBy.strategies;

import OrderBy.Book;
import OrderBy.BookSorter;

import java.util.Comparator;
import java.util.List;

public class OrderByTitle implements BookSorter {

    public List<Book> sort(List<Book> books) {
        books.sort(Comparator.comparing(Book::getTitle));
        return books;
    }

}
