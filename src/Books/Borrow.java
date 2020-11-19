package Books;

import Visitor.Command;
import Visitor.Application;
import java.util.ArrayList;


public class Borrow implements Command{
    private Long visitorID;
    private ArrayList<String> bookISBN;
    private boolean canUndo;

    public Borrow(Long visitorID, ArrayList<String> bookISBN, boolean canUndo){
        this.visitorID=visitorID;
        this.bookISBN=bookISBN;
        this.canUndo=canUndo;
    }

    @Override
    public String execute(){
        try{
            if(this.canUndo){
                //Application a = new Application();
            }
            else{
                return "";
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
