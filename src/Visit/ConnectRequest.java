package Visit;

public class ConnectRequest extends Request {
    public ConnectRequest() {
        super("connect");
    }

    @Override
    public boolean execute() {
        System.out.println("LOGIN REQUEST");

        return super.execute();
    }
}
