package Requests;


import java.util.Stack;

/**
 * Invoker for Command pattern with stacks for storing commands to fall back upon.
 *
 * @author Ben Radley
 */
public class UndoRedoManager {
    private Stack<UndoRedoApp> undoStack;
    private Stack<UndoRedoApp> redoStack;

    private static final UndoRedoManager Manager = new UndoRedoManager();

    //Constructor for stack objects
    public UndoRedoManager(){
        this.undoStack = new Stack<>();
        this.redoStack = new Stack<>();
    }

    public Stack<UndoRedoApp> getUndoStack() {
        return undoStack;
    }

    public Stack<UndoRedoApp> getRedoStack() {
        return redoStack;
    }

    public static UndoRedoManager getManager(){
        return Manager;
    }

}