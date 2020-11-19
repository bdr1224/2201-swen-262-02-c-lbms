package Requests;

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
        }

        this.params = this.textString.split(",");
    }

    @Override
    public void execute() {
        System.out.println("Executing RegisterRequest");
    }

    @Override
    public String getTextString() { return this.textString; }

    @Override
    public String[] getParams() { return this.params; }

    @Override
    public boolean isPartial() { return this.isPartial; }
}
