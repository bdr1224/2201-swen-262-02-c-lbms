package Visitor;

/**
 * This class represents an LBMS visitor
 * Context class for VisitorRegistration State design pattern
 *
 * @author Shantanav Saurav
 */
public class Visitor {
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
    private int id = ID_GEN++;
    /**
     * Visitor registration state
     */
    private VisitorRegistration registration;
    
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
    public Visitor(String firstName, String lastName, String address, String phoneNumber, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;
    }
    
    /**
     * Set registration state for this visitor
     *
     * @param registration Registration to be set
     */
    public void setRegistration(VisitorRegistration registration) { this.registration = registration; }
    
    /**
     * Handle a visitor entry
     */
    public void enterLibrary() { this.registration.handleEntry(); }
    
    /**
     * Handle a visitor entry
     */
    public void exitLibrary() { this.registration.handleExit(); }
}
