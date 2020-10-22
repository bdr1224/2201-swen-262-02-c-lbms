package Book;

public class Book{
    protected String isbn;
    protected String title;
    protected String author;
    protected String publisher;
    protected String pubDate;
    protected int pageCount;
    protected int copies;

    private BookStatus bookStatus;

    public Book(boolean inStock, String isbn, String title, String author, String publisher, String pubDate, int pageCount, int copies) {
        this.inStock = inStock;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pubDate = pubDate;
        this.pageCount = pageCount;
        this.copies = copies;
        bookStatus = new InStock();
    }

    public void setStatus(BookStatus status){
        bookStatus = status;
    }

    public boolean getStatus(){
        bookStatus.isBookAvailable();
    }
}