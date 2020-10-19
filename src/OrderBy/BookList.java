package OrderBy;

import java.util.List;

public class BookList {

    BookSorter sorter;
    List<Book> books;

    public void setSorter(BookSorter sorter) {
        this.sorter = sorter;
    }

    public void orderBy() {
        sorter.sort(books);
    }

}
