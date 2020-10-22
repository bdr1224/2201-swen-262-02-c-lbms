package Visitor;

public interface VisitorSubject {
    void register(VisitorObserver observer);
    void deregister(VisitorObserver observer);
    void notify(LBMSEntry event);
}
