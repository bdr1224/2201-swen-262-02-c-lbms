package Books;
/**
 * Return command for return out a book that can be undone
 *
 * @author Ben Radley
 * */
import Visitor.Command;
import Visitor.Application;
import Visitor.UndoRedoManager;

import java.util.ArrayList;


public class Return implements Command{
    private Long visitorID;
    private ArrayList<String> bookISBN;
    private boolean canUndo;

    public Return(Long visitorID, ArrayList<String> bookISBN, boolean canUndo) {
        this.visitorID = visitorID;
        this.bookISBN = bookISBN;
        this.canUndo = canUndo;
    }

    @Override
    public String execute(){
        try{
            if(this.canUndo){
                Borrow b = new Borrow(this.visitorID, this.bookISBN, false);
                Application a = new Application(b);
                UndoRedoManager.getManager().getUndoStack().add(a);
            }
            else{
                Return r = new Return(this.visitorID, this.bookISBN, false);
                Application a = new Application(r);
                UndoRedoManager.getManager().getRedoStack().add(a);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
}
