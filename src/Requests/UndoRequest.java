package Requests;
/**
 * This class is to process Undo requests from the User
 *
 * @author Ben Radley
 * */
import Requests.Request;
import java.util.ArrayList;
import LBMS.Library;

public class UndoRequest implements Request{
    private UndoRedoApp appl;
    public UndoRequest(){
        this.appl = UndoRedoManager.getManager().getUndoStack().pop();
    }

    @Override
    public Response execute(Library library){
        /*
        this.appl.getState().execute();
        return "undo,success;";*/
        System.out.println("Executing request");
        this.appl = UndoRedoManager.getManager().getUndoStack().pop();
        return new Response(this, "Undone");
    }

    @Override
    public String getTextString() {
        return null;
    }

    @Override
    public String[] getParams() {
        return new String[0];
    }

    @Override
    public boolean isPartial() {
        return false;
    }
}
