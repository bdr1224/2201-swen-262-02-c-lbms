package Visitor;

import Books.*;
import java.util.ArrayList;

/**
 * Concrete Command for command pattern, undoes the most recent command
 *
 * @author Ben Radley
 */
public class Undo implements Command{
    private Application command;
    public Undo(){
        this.command = UndoRedoManager.getManager().getUndoStack().pop();
    }

    @Override
    public String execute(){
        this.command.getState().execute();
        return "undo,success;";
    }
}
