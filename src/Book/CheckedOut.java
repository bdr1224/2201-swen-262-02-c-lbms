package Book;

public class CheckedOut{
    protected Book book;

    public CheckedOut(Book book) {
        this.book = book;
    }
    public boolean isBookAvailable(){
        return false;
    }
}