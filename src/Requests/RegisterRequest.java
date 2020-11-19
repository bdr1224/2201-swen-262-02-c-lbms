package Requests;

import LBMS.Library;

/**
 * This class represents a LBMS register request. Visitors of the library
 * are able to register an account providing their name, address, and phone
 * number.
 *
 * @author Jake Waclawski
 */
public class RegisterRequest implements Request {
    private String textString;
    private String[] params;
    private boolean isPartial;

    public RegisterRequest(String textString) {
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
        System.out.println(this.textString);
        this.params = this.textString.split(",");
    }

    @Override
    public Response execute(Library library) {
        System.out.println("Executing request: " + this.textString);
        if(!this.isPartial) {
            if(this.params.length == 5) return new Response(this, library.createNewVisitor(params[1], params[2], params[3], params[4]));
            return new Response(this, "Invalid arguments");
        }

        return new Response(this, "TODO: Process partial command");
    }

    @Override
    public String getTextString() { return this.textString; }

    @Override
    public String[] getParams() { return this.params; }

    @Override
    public boolean isPartial() { return this.isPartial; }
}
