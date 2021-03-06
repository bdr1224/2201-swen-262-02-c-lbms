package Requests;

/**
 * This class represents a LBMS Response. It is very similar to an LBMS Request,
 * but only stores a text string and does not contain an execute functionality.
 *
 * @author Jake Waclawski
 */
public class Response {
    private Request request;
    private String textString;
    private String[] params;
    private boolean isPartial;

    public Response(String textString) {
        String endingChar = textString.substring(textString.length() - 1);
        if(endingChar.equals(";")) {
            this.textString = textString;
            this.isPartial = false;
        } else if (endingChar.equals(",")) {
            this.textString = textString;
            this.isPartial = true;
        } else {
            this.textString = textString + ";";
            this.isPartial = false;
        }

        this.params = this.textString.split(",");
    }

    public Response(Request request, String textString) {
        if(request.isPartial()) {
            this.textString = request.getTextString() + " ";
        } else {
            this.textString = request.getTextString().substring(0, request.getTextString().length() - 1) + ", ";
        }

        String endingChar = textString.substring(textString.length() - 1);
        if(endingChar.equals(";")) {
            this.textString += textString;
            this.isPartial = false;
        } else if (endingChar.equals(",")) {
            this.textString += textString;
            this.isPartial = true;
        } else {
            this.textString += textString + ";";
        }

        this.params = this.textString.split(",");
        this.request = request;
    }

    public void addResponse(String textString) {
        this.textString += textString + ", ";
    }

    public String getTextString() { return this.textString; }
}
