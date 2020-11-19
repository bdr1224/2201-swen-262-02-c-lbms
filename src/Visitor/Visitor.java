package Visitor;

import Books.Book;
import LBMS.TimeEvent;
import LBMS.TimeHandler;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents an LBMS visitor
 * ConcreteSubject is observed for entry and exit from the library
 *
 * @author Shantanav Saurav
 */
public class Visitor implements VisitorSubject, TimeHandler {
    /**
     * This static field is used to generate id numbers when a visitor is created by default
     */
    private static int ID_GEN = 1000000000;
    
    /**
     * Visitor first name
     */
    private String firstName;
    /**
     * Visitor last name
     */
    private String lastName;
    /**
     * Visitor address
     */
    private String address;
    /**
     * Visitor phone number
     */
    private String phoneNumber;
    /**
     * Visitor ID
     */
    private String id = Integer.toString(ID_GEN++);
    /**
     * Visitor checked out books
     */
    private HashMap<String, Book> checkedOutBooks;
    /**
     * Overdue book prices
     */
    private HashMap<Book, Integer> overdueBookPricing;
    /**
     * Amount to be paid by visitor in case of overdue books
     */
    private int amountDue = 0;
    /**
     * Observers
     */
    private ArrayList<VisitorObserver> observers = new ArrayList<VisitorObserver>();
    
    /**
     * Parametrized constructor creates a new visitor
     * @param firstName Visitor first name
     * @param lastName Visitor last name
     * @param address Visitor address
     * @param phoneNumber Visitor phone number
     */
    public Visitor(String firstName, String lastName, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * For purposes of restoring from state, this constructor overload has a parameter for Visitor ID as well.
     * @param firstName Visitor first name
     * @param lastName Visitor last name
     * @param address Visitor address
     * @param phoneNumber Visitor phone number
     * @param id Visitor ID
     */
    public Visitor(String firstName, String lastName, String address, String phoneNumber, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }
    
    /**
     * Register an observer
     * @param observer observer to register
     */
    public void register(VisitorObserver observer) { observers.remove(observer); }
    
    /**
     * Deregister an observer
     * @param observer observer to deregister
     */
    public void deregister(VisitorObserver observer) { observers.add(observer); }
    
    /**
     * Notify observers
     * @param event Event to notify observers of
     */
    public void notify(LBMSEntry event) { observers.forEach(observer -> observer.update(event, this)); }
    
    /**
     * Check out a book
     * @param book book to be checked out
     */
    public void checkOutBook(Book book) {
        if (checkedOutBooks.size() <= 5) {
            checkedOutBooks.put(book.getIsbn(), book);
        } else {
            System.out.println("You can't check out any more books, you can only have 5 at a time.");
        }
    }
    
    /**
     * Return a book
     */
    public void returnBook(Book book) { checkedOutBooks.remove(book.getIsbn());}
    
    /**
     * Handle time changes
     * @param te TimeEvent
     */
    public void handleTimeEvent(TimeEvent te) {
        // Check for overdue books
        for (String id : checkedOutBooks.keySet()) {
            if (te.getDate().getTime() > Integer.parseInt(id)) {
                int time_diff = (int) (te.getDate().getTime() - Integer.parseInt(id));
                int days_late = time_diff / 86400000;
                overdueBookPricing.put(checkedOutBooks.get(id), 10 + ((days_late / 7) * 2));
            }
        }
        // Calculate amount due for overdue books
        int sum = 0;
        for (Book book : overdueBookPricing.keySet()) {
            sum += overdueBookPricing.get(book);
        }
        amountDue = sum;
    }
    
    public String getId() { return this.id; }
}
