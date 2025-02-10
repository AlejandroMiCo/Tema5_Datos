package ejem1;

import java.util.ArrayList;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.annotation.XmlElement;

@Path("/personas")
public class Personas {
    static ArrayList<Persona> personas = new ArrayList<>();

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response guardar(Persona per){
        personas.add(per);
        return Response.ok(per).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Persona> listar(){
        return personas;
    }   

    @GET
    @Path("{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona ver(@PathParam("nombre") String nom){

        for (Persona persona : personas) {
            if (persona.getNombre().equals(nom)) {
                return persona; 
            }
        }
        return null;
    }

    @GET
    @Path("buscar")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Persona> verBuscar(@QueryParam("query")String query){
        ArrayList<Persona> personasBuscadas = new ArrayList<>();

        for (Persona persona :personas) {
            if (persona.getNombre().toUpperCase().contains(query.toUpperCase())) {
                personasBuscadas.add(persona);
            }
        }
        return personasBuscadas;
    }


}
