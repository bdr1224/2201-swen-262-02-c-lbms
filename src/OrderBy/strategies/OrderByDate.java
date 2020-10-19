package OrderBy.strategies;

import OrderBy.Book;
import OrderBy.BookSorter;

import java.util.Comparator;
import java.util.List;

public class OrderByDate implements BookSorter {

    public List<Book> sort(List<Book> books) {
        books.sort(Comparator.comparing(Book::getDate));
        return books;
    }

}
