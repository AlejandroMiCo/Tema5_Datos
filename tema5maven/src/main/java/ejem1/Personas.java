package ejem1;

import java.util.ArrayList;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/personas")
public class Personas {
    static ArrayList<Persona> personas = new ArrayList<>();

    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response guardar(Persona per) {
        personas.add(per);
        return Response.ok(per).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ArrayList<Persona> listar() {
        return personas;
    }

    @GET
    @Path("{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Persona ver(@PathParam("nombre") String nom) {

        for (Persona persona : personas) {
            if (persona.getNombre().equals(nom)) {
                return persona;
            }
        }
        return null;
    }

    @GET
    @Path("buscar")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public ArrayList<Persona> verBuscar(@DefaultValue("") @QueryParam("query") String query) {
        ArrayList<Persona> personasBuscadas = new ArrayList<>();

        for (Persona persona : personas) {
            if (persona.getNombre().toUpperCase().contains(query.toUpperCase())) {
                personasBuscadas.add(persona);
            }
        }
        return personasBuscadas;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response guardarPersonaFrom(@FormParam("nombre") int id, @FormParam("nombre") String nombre,
            @FormParam("sexo") String sexo, @FormParam("casado") boolean casado) {
        Persona persna = new Persona();
        persna.setId(id);
        persna.setNombre(nombre);
        persna.setCasado(casado);
        persna.setSexo(sexo);
        return Response.ok(persna).build();
    }

    // @POST
    // @Consumes(MediaType.APPLICATION_JSON)
    // public Response guardarPersona(Persona[] personasToAdd) {
    //     for (Persona persona : personasToAdd) {
    //         personas.add(persona);
    //     }
    //     return Response.ok(personas).build();
    // }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response eliminarPersona(@QueryParam("id") int id) {
        int numPersonasb4 = personas.size();
        for (Persona persona : personas) {
            if (persona.getId() == id) {
                personas.remove(persona);
            }
        }
        if (numPersonasb4 == personas.size()) {
            return Response.status(404).build();
        } else {
            return Response.ok(personas).build();
        }
    }

    @GET
    @Path("XML")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Persona devolvPersona(@QueryParam("id") int id) {
        for (Persona persona : personas) {
            if (persona.getId() == id) {
                return persona;
            }
        }
        return null;
    }

    @POST
    @Path("gallego")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PersonaGal devolvPersonaGal(Persona per) {
        PersonaGal perGal = new PersonaGal(per.getId(), per.getNombre(), per.isCasado(), per.getSexo());
        return perGal;
    }
}
