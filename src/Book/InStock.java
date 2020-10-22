package Book;

public class InStock implements BookStatus{
    @Override
    public boolean isBookAvailable(){
        return false;
    }
}