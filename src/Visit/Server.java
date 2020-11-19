package Visit;

public class Server {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Program arguments: 'port'");
        } else {
            int port = Integer.parseInt(args[0]);
            ProxyLibrary server = new ProxyLibrary(port);
            server.startServer();
        }
    }
}
