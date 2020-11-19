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
    private HashMap<String, Visitor> visitors;
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
        String[] params = request.getParams();
        switch(params[0]) {
            case "connect":
                request.execute();
                return new Response(request, "client_id");
            case "quit":
                System.out.println("Goodbye!");
                System.exit(0);
            case "register":
                return new Response(request, this.createNewVisitor(params[1], params[2], params[3], params[4]));
            default: return new Response(request, "Unrecognized command");
        }
    }
    
    private String createNewVisitor(String firstName, String lastName, String address, String phoneNumber) {
        Visitor visitor = new Visitor(firstName, lastName, address, phoneNumber);
        this.visitors.put(visitor.getId(), visitor);
        return "register," + visitor.getId() + "," + (new Date().getDate());
    }
}
