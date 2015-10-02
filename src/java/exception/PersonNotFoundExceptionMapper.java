package exceptions;

import com.google.gson.JsonObject;
import exception.PersonNotFoundException;
import javax.servlet.ServletContext;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PersonNotFoundExceptionMapper implements ExceptionMapper<PersonNotFoundException> {
    
    @Context
    ServletContext context;
    @Override
    public Response toResponse(PersonNotFoundException e) {
        JsonObject jo = new JsonObject();
        
        if (Boolean.valueOf(context.getInitParameter("debug"))) {
            
            String err = "";
            
            StackTraceElement[] stack = e.getStackTrace();
            
            for (StackTraceElement elm : stack) {
                err += elm.toString() + "\n";
            }
            
            jo.addProperty("stackTrace", err);
        }
        
        jo.addProperty("code", 404);
        jo.addProperty("message", "No person with provided id found");
        return Response.status(Response.Status.NOT_FOUND).entity(jo.toString()).type(MediaType.APPLICATION_JSON).build();
    }
    
}