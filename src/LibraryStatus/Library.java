package LibraryStatus;

import LibraryStatus.LibraryStatus;

import java.util.ArrayList;

public class Library {
    long time;
    ArrayList<String> vistors;
    ArrayList<String> books;
    LibraryStatus status;

    public void setStatus(boolean isOpen) {
        if (isOpen) {
            status = new OpenStatus();
        } else {
            status = new ClosedStatus();
        }
    }
}
