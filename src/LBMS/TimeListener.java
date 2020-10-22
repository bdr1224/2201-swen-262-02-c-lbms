package LBMS;

public interface TimeListener {
    void register(TimeHandler handler);
    void deregister(TimeHandler handler);
    void notify(TimeEvent te);
}
