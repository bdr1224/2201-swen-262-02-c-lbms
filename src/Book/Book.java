package Book;

public class Book{
    protected boolean inStock;
    protected String isbn;
    protected String title;
    protected String author;
    protected String publisher;
    protected String pubDate;
    protected int pageCount;

    public Book(boolean inStock, String isbn, String title, String author, String publisher, String pubDate, int pageCount) {
        this.inStock = inStock;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pubDate = pubDate;
        this.pageCount = pageCount;
    }
}