/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.Facade;
import utils.JSONConverter;

/**
 * REST Web Service
 *
 * @author Andreas
 */
@Path("persons")
public class GenericResource {

    Gson gson;

    @Context

    private UriInfo context;

    Facade facade;

    public GenericResource() {
        gson = new GsonBuilder().
                setPrettyPrinting().
                setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).
                create();
    }

    @GET
    @Produces("application/json")
    public Response getPersons() {
        String persons = JSONConverter.getJSONFromList(facade.getPersons());
        return Response
                .status(Response.Status.OK)
                .entity(persons.toString())
                .build();
    }

    @POST
    @Consumes("application/json")
    public Response createPerson(String json) {
        Person p = facade.addPerson(JSONConverter.getPersonFromJson(json));
        String res = JSONConverter.getJSONFromPerson(p);
        return Response
                .status(Response.Status.OK)
                .entity(res)
                .build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("id") int id) {
        Person p = facade.deletePerson(id);
        String res = JSONConverter.getJSONFromPerson(p);
        return Response
                .status(Response.Status.OK)
                .entity(res)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getPerson(@PathParam("id") int id) {
        String person = JSONConverter.getJSONFromPerson(facade.getPerson(id));
        return Response
                .status(Response.Status.OK)
                .entity(person.toString())
                .build();
    }
}
