package br.com.quarkus.resource;

import br.com.quarkus.model.Usuario;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UsuarioResource {

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public void insertUser(Usuario user){
        Usuario.addUser(user);
    }

    @Path("/all")
    @GET
    @RolesAllowed({"USER","ADMIN"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listAll(){
        return Usuario.listAll();
    }
}
