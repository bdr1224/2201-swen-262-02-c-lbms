package Requests;

import LBMS.Library;

/**
 * This interface defines a LBMS request. Each request contains a text string
 * and stores whether or not the request is a partial request. Each type of
 * request has a different execute functionality that returns a LBMS Response.
 *
 * @author Jake Waclawski
 */
public interface Request{
    public Response execute(Library library);
    public String getTextString();
    public String[] getParams();
    public boolean isPartial();
}
