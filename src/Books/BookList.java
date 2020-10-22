package Books;

import java.util.ArrayList;
import java.util.List;

public class BookList {

    private BookSorter sorter;
    private BookSearcher searcher;
    private ArrayList<Book> books;
    
    /**
     * Stub function to read in books from file on startup
     * @param filename name of file
     */
    public BookList(String filename) {
    
    }
    
    public void setSorter(BookSorter sorter) {
        this.sorter = sorter;
    }
    
    public void setSearcher(BookSearcher searcher) { this.searcher = searcher; }

    public List<Book> search(String query) {
        return sorter.sortBy(searcher.searchFor(books, query));
    }
}
