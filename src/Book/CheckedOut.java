package Book;

public class CheckedOut implements BookStatus{
    @Override
    public boolean isBookAvailable(){
        return false;
    }
}