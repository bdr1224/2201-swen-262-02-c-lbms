package Visitor;

/**
 * Interface to represent a visitor state
 *
 * @author Shantanav Saurav
 */
public interface VisitorRegistration {
    /**
     * Define operation for when a visitor enters the BWL
     */
    void handleEntry();
    
    /**
     * Define operation for when a visitor enters the BWL
     */
    void handleExit();
}
