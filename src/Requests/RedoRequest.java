package Requests;

/**
 * This class is to process Undo requests from the User
 *
 * @author Ben Radley
 * */
import LBMS.Library;
import Requests.Request;
import java.util.ArrayList;

public class RedoRequest implements Request{
    private UndoRedoApp appl;
    public RedoRequest(){
        this.appl = UndoRedoManager.getManager().getRedoStack().pop();
    }

    @Override
    public Response execute(Library library){
        /*
        this.appl.getState().execute();
        return "redo,success;";*/
        System.out.println("Executing request");
        this.appl = UndoRedoManager.getManager().getUndoStack().pop();
        return new Response(this, "Redone");
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
