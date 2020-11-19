package Requests;

public interface Request{
    public void execute();
    public String getTextString();
    public String[] getParams();
    public boolean isPartial();
}
