package br.com.quarkus.resource;

import br.com.quarkus.model.Usuario;

import javax.annotation.security.PermitAll;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/users")
public class UsuarioResource {

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @PermitAll
    public void insertUser(Usuario user){
        Usuario.addUser(user);
    }
}
