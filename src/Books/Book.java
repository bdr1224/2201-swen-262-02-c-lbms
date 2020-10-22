package Books;

import java.util.Date;

/**
 * Represents a book in BWL
 *
 * @author Shantanav Saurav
 * @author Owen Racette
 */
public class Book {
    
    /**
     * Title of the book
     */
    private final String title;
    /**
     * Author of book
     */
    private final String author;
    /**
     * ISBN of the book
     */
    private final String isbn;
    /**
     * Number of pages in book
     */
    private final int pages;
    /**
     * Number of copies the library owns
     */
    private final int copies;
    /**
     * Number of copies currently loaned out
     */
    private int checkedOut;
    /**
     * Published date
     */
    private final Date publishedDate;
    
    /**
     * Parametrized constructor to create a book
     * @param title Book title
     * @param author Book author
     * @param isbn Book isbn
     * @param pages number of pages
     * @param copies number of owned copies
     * @param checkedOut number of checked out books
     * @param publishedDate book published date
     */
    public Book(String title, String author, String isbn, int pages, int copies, int checkedOut, Date publishedDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.copies = copies;
        this.checkedOut = checkedOut;
        this.publishedDate = publishedDate;
    }
    
    /**
     * Fetches book title
     * @return book title
     */
    public String getTitle() { return title; }
    
    /**
     * Fetches Author
     * @return Author
     */
    public String getAuthor() { return author; }
    
    /**
     * Fetches ISBN
     * @return ISBN
     */
    public String getIsbn() { return this.isbn; }
    
    /**
     * Fetches number of pages
     * @return number of pages
     */
    public int getPages() { return pages; }
    
    /**
     * Fetches number of checked out books
     * @return number of checked out books
     */
    public int getCheckedOut() { return checkedOut; }
    
    /**
     * Fetches number of owned copies
     * @return number of owned copies
     */
    public int getCopies() { return copies; }
    
    /**
     * Fetches whether the book is in stock
     * @return whether the book is in stock
     */
    public boolean isInStock() { return copies - checkedOut > 0; }
    
    /**
     * Fetches date published
     * @return date published
     */
    public Date getPublishedDateDate() { return publishedDate; }
    
    /**
     * Check out a copy of this book
     */
    public void checkOut() { this.checkedOut++; }
    
    /**
     * Return a copy of this book
     */
    public void returnBook()  { this.checkedOut--; }
}
