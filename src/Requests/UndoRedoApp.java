package Requests;
/**
 * Client object for Command pattern
 *
 * @author Ben Radley
 * */
import Requests.Request;
public class UndoRedoApp {
    private Request state;
    //Tracks the state of undo/redo command



    /**
     *
     * @param state
     * */
    public UndoRedoApp(Request state){
        this.state=state;
    }

    /**
     *
     * @return state
     */
    public Request getState(){
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(Request state) {
        this.state = state;
    }
}
