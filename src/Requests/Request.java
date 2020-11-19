package Requests;

import LBMS.Library;

public interface Request{
    public Response execute(Library library);
    public String getTextString();
    public String[] getParams();
    public boolean isPartial();
}
