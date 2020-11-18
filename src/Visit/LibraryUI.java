package Visit;

public class LibraryUI {
    private LocalLibrary serverConnection;

    public LibraryUI(String host, int port) {
        this.serverConnection = new LocalLibrary(host, port);
    }
}
