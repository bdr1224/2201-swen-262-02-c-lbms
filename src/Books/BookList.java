package Books;

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class BookList {

    private BookSorter sorter;
    private BookSearcher searcher;
    private ArrayList<Book> books;
    
    /**
     * Read in books from file on startup
     * @param filename name of file
     */
    public BookList(String filename) {
        this.books = new ArrayList<>();
        try (Scanner fileReader = new Scanner(new File(filename))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                // Copied from Books constructor
                String isbn = ""; String title = ""; ArrayList<String> author = new ArrayList<>();
                        String publisher = ""; String publishedDate = ""; int copies = 1;
                        int numCheckedOut = 0; int pages = 0;
                        
                // ISBN
                Pattern pattern = Pattern.compile("^[\\d]{13}");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) { isbn = matcher.group(0); }
                
                // Authors
                pattern = Pattern.compile("[{][\\p{ASCII}]+[}]");
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    author = new ArrayList<>(Arrays.asList(matcher.group(0)
                                                            .substring(1, matcher.group(0).length() - 1)
                                                            .strip().split(","))
                    );
                }
                
                // Title
                pattern = Pattern.compile("[,][\"][\\p{ASCII}]+[\"][,][{]");
                matcher = pattern.matcher(line);
                if (matcher.find()) { title = matcher.group(0).substring(2, matcher.group(0).length() - 3); }
                
                // Publisher
                pattern = Pattern.compile("[}][,][\"][\\p{ASCII}]+[\"][,]");
                matcher = pattern.matcher(line);
                if (matcher.find()) { publisher = matcher.group(0).substring(3, matcher.group(0).length() - 2); }
                
                // Published Date, Pages
                String[] lineSplit = line.split(",");
                publishedDate = lineSplit[lineSplit.length - 2];
                pages = Integer.parseInt(lineSplit[lineSplit.length - 1]);
                
                // FINALLY make the book
                this.books.add(new Book(isbn, title, author, publisher, publishedDate, copies, numCheckedOut, pages));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File with that name wasn't found.");
        }
    }
    
    /**
     * Set the sorter for the books results
     * @param sorter Sorter to set
     */
    public void setSorter(BookSorter sorter) {
        this.sorter = sorter;
    }
    
    /**
     * Set the searcher for the books
     * @param searcher Searcher to set
     */
    public void setSearcher(BookSearcher searcher) { this.searcher = searcher; }
    
    /**
     * Get a list of books searched and sorted by the according strategies
     * @param query The query to search
     * @return Books to search
     */
    public List<Book> search(String query) {
        return sorter.sortBy(searcher.searchFor(books, query));
    }
    
    /**
     * String representation of a list of books
     * @return string representation of a list of books
     */
    @Override
    public String toString() {
        StringBuilder retval = new StringBuilder();
        for (Book book : books) {
            retval.append(book.toString()).append("\n");
        }
        return retval.toString();
    }
}
