package LBMS;

import java.util.ArrayList;
import Visitor.LBMSEntry;
import Visitor.Visitor;
import Visitor.VisitorObserver;

public class Library implements VisitorObserver {
    private long time;
    private ArrayList<String> visitors;
    private ArrayList<Visitor> currentVisitors = new ArrayList<Visitor>();
    private ArrayList<String> books;
    private LibraryStatus status;

    public void setStatus(boolean isOpen) {
        if (isOpen) {
            status = new OpenStatus();
        } else {
            status = new ClosedStatus();
        }
    }
    
    public void update(LBMSEntry event, Visitor visitor) {
        if (event == LBMSEntry.ENTER) {
            this.currentVisitors.add(visitor);
        } else {
            this.currentVisitors.remove(visitor);
        }
    }
}
