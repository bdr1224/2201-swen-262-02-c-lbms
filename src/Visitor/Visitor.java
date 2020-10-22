package Visitor;

import java.util.ArrayList;

/**
 * This class represents an LBMS visitor
 * ConcreteSubject is observed for entry and exit from the library
 *
 * @author Shantanav Saurav
 */
public class Visitor implements VisitorSubject {
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
}
