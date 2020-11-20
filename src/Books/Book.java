package Books;

import java.util.ArrayList;

/**
 * Represents a book in BWL
 *
 * @author Shantanav Saurav
 * @author Owen Racette
 * @author Ben Radley
 */
public class Book {
    
    /**
     * Title of the book
     */
    private final String title;
    /**
     * Author of book
     */
    private final ArrayList<String> author;
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
    private int numCheckedOut;
    /**
     * This book's publisher
     */
    private final String publisher;
    /**
     * Published date
     */
    private final String publishedDate;
    
    /**
     * Parametrized constructor to create a book
     * @param title Book title
     * @param author Book author
     * @param isbn Book isbn
     * @param pages number of pages
     * @param copies number of owned copies
     * @param numCheckedOut number of checked out books
     * @param publishedDate book published date
     */
    public Book(String isbn, String title, ArrayList<String> author, String publisher,
                String publishedDate, int copies, int numCheckedOut, int pages) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.pages = pages;
        this.copies = copies;
        this.numCheckedOut = numCheckedOut;
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
    public ArrayList<String> getAuthor() { return author; }
    
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
    public int getCheckedOut() { return numCheckedOut; }
    
    /**
     * Fetches number of owned copies
     * @return number of owned copies
     */
    public int getCopies() { return copies; }
    
    /**
     * Fetches whether the book is in stock
     * @return whether the book is in stock
     */
    public boolean isInStock() { return copies - numCheckedOut > 0; }
    
    /**
     * Fetches date published
     * @return date published
     */
    public String getPublishedDateDate() { return publishedDate; }
    
    /**
     * Check out a copy of this book
     */
    public void checkOut() { this.numCheckedOut++; }
    
    /**
     * Return a copy of this book
     */
    public void returnBook()  { this.numCheckedOut--; }
    
    /**
     * String representation of a book
     * @return String representation of a book
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author(s)='" + author.toString() + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pages=" + pages +
                ", copies=" + copies +
                ", numCheckedOut=" + numCheckedOut +
                ", publishedDate=" + publishedDate +
                '}';
    }
    
    /**
     * Get the publisher of this book
     * @return publisher of this book
     */
    public String getPublisher() { return this.publisher; }
}
