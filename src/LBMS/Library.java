package LBMS;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Books.BookList;
import Requests.RegisterRequest;
import Requests.Request;
import Requests.Response;
import Requests.VisitRequest;
import Visitor.LBMSEntry;
import Visitor.Visitor;
import Visitor.VisitorObserver;

public class Library implements VisitorObserver, TimeHandler {
    private HashMap<String, Visitor> visitors = new HashMap<String, Visitor>();
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
    
    public Response processRequest(Request request) {
        if(request == null) return new Response("Unknown command");
        return request.execute(this);
    }
    
    public String createNewVisitor(String firstName, String lastName, String address, String phoneNumber) {
        Visitor visitor = new Visitor(firstName, lastName, address, phoneNumber);
        System.out.println(visitor.getId());
        this.visitors.put(visitor.getId(), visitor);
        return visitor.getId() + "," + (new Date().getDate());
    }
}
