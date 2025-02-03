package ejem1;

import java.util.ArrayList;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/personas")
public class Personas {
    static ArrayList<Persona> personas;

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response guardar(Persona persona){
        this.personas.add(persona);
        return Response.ok(persona).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Persona> listar(){
        return this.personas;
    }

    // @GET
    // @Produces(MediaType.APPLICATION_JSON)
      
}
