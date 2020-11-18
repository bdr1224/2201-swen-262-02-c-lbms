package Visitor;
/**
 * Client object for Command pattern
 *
 * @author Ben Radley
 * */
public class Application {
    private Command state;
    //Tracks the state of undo/redo command



    /**
     *
     * @param state
     * */
    public Application(Command state){
        this.state=state;
    }

    /**
     *
     * @return state
     */
    public Command getState(){
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(Command state) {
        this.state = state;
    }
}
