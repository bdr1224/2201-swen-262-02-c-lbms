package LBMS;

import java.util.ArrayList;
import java.util.HashMap;

import Books.BookList;
import Visitor.LBMSEntry;
import Visitor.Visitor;
import Visitor.VisitorObserver;

public class Library implements VisitorObserver, TimeHandler {
    private HashMap<String, String> visitors;
    private ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
    private BookList books;
    private LibraryStatus status;

    public Library(BookList books) {
        this.books = books;
    }
    
    public void setStatus(LibraryStatus status) { this.status = status; }
    
    public void update(LBMSEntry event, Visitor visitor) {
        if (event == LBMSEntry.ENTER) {
            this.currentVisitors.add(visitor);
        } else {
            this.currentVisitors.remove(visitor);
        }
    }
    
    /**
     * Handle shutdown of the system
     *      Ends all visits
     *      Writes state to files TODO
     */
    private void shutdown() {
        currentVisitors.forEach(visitor -> visitor.notify(LBMSEntry.EXIT));
        this.setStatus(new ClosedStatus());
    }
    
    /**
     * Restore state of the program
     */
    private void open() {
        // TODO restore from state
        this.setStatus(new OpenStatus());
    }
    
    public void handleTimeEvent(TimeEvent te) {
        if (te.getHour() == 19) {
            this.shutdown();
        } else if (te.getHour() == 8) {
            this.open();
        }
    }
    
    public void processRequest(String in) {
        String[] params = in.split(",");
        switch(params[0]) {
            case "quit": System.out.println("Goodbye!");break;
            default: System.out.println("Unrecognized command"); break;
        }
    }
}
