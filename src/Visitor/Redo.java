package Visitor;

import Books.*;
import java.util.ArrayList;

/**
 * Concrete Command for command pattern, redoes the most recent command
 *
 * @author Ben Radley
 */
public class Redo implements Command{
    private Application command;
    public Redo(){
        this.command = UndoRedoManager.getManager().getRedoStack().pop();
    }

    @Override
    public String execute(){
        this.command.getState().execute();
        return "redo,success;";
    }
}
