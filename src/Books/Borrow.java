package Books;
/**
 * Borrow command for taking out a book that can be undone
 *
 * @author Ben Radley
 * */
import Visitor.Command;
import Visitor.Application;
import Visitor.UndoRedoManager;

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
                Return r = new Return(this.visitorID, this.bookISBN, false);
                Application a = new Application(r);
                UndoRedoManager.getManager().getRedoStack().add(a);
            }
            else{
                Return r = new Return(this.visitorID, this.bookISBN, false);
                Application a = new Application(r);
                UndoRedoManager.getManager().getUndoStack().add(a);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
