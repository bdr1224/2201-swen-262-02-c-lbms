package Visit;

public class Request {
    private String textString;

    public Request(String textString) {
        this.textString = textString + ";";
    }

    public boolean execute() {
        return false;
    }

    public String getTextString() { return textString; }
}
