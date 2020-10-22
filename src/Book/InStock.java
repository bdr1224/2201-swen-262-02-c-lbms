package Book;

public class InStock{
    protected Book book;

    public InStock(Book book) {
        this.book = book;
    }
    public boolean isBookAvailable(){
        return false;
    }
}