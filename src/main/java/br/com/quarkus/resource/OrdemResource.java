package br.com.quarkus.resource;

import br.com.quarkus.model.Ordem;
import br.com.quarkus.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.Arrays;
import java.util.List;

@Path("/ordens")
public class OrdemResource {
    @Inject
    private OrdemService ordemService;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"USER"})
    public Response insert(@Context SecurityContext securityContext, Ordem ordem){
        this.ordemService.insertOrdem(securityContext, ordem);
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @Path("/all")
    @GET
    @RolesAllowed({"ADMIN"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ordem> listAll(){
        return ordemService.listAll();
    }

//    @Path("/user")
//    @GET
//    @RolesAllowed({"USER", "ADMIN"})
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Ordem> listAll(@Context SecurityContext securityContext){
//        return ordemService.listAllOrdemForUser(securityContext.getUserPrincipal().getName());
//    }
}
