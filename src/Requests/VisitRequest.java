package Requests;

import LBMS.Library;

/**
 * This class represents an LBMS visit request.
 *
 * @author Jake Waclawski
 */
public class VisitRequest implements Request {
    private String textString;
    private String[] params;
    private boolean isPartial;

    public VisitRequest(String textString) {
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

    @Override
    public Response execute(Library library) {
        System.out.println("Executing request: " + this.textString);
        return new Response(this, "VisitRequest response");
    }

    @Override
    public String getTextString() { return this.textString; }

    @Override
    public String[] getParams() { return this.params; }

    @Override
    public boolean isPartial() { return this.isPartial; }
}
