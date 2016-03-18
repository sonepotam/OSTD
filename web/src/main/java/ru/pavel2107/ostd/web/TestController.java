package ru.pavel2107.ostd.web;

import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by admin on 14.03.2016.
 */

/*
@Path("/test")
public class TestController {

    @GET
    @Produces("text/html")
    public String getString(){
        return "hello";
    }
}
*/

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
 
/**
 * Root resource (exposed at "helloworld" path)
 */
@Path("helloworld")
public class TestController {
 
    /** Creates a new instance of HelloWorld */
    public TestController() {
    }
 
    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
    }
}
