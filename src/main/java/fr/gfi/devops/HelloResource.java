package fr.gfi.devops;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("hello")
public class HelloResource {
    public HelloResource() { }
    
    @GET
    public String getHello() {
        return "Bonjour GFI";
    }
    
    @GET
    @Path("{id}")
    public String getHello(@PathParam("id") String id,
                           @DefaultValue("DevOps Team") @HeaderParam("name") String name) {
        return "Bonjour " + id + " de la part de " + name;
    }
    
    	
    @GET
    @Path("providers/{id}")
    public Response getHelloWithHeaders(@PathParam("id") String id,
                                        @DefaultValue("DevOpsTeam") @HeaderParam("name") String name) {
        return Response.ok().header("name", name).entity("Bonjour " + id + " de la part de (voir l'en-tête).").build();
    }
}

