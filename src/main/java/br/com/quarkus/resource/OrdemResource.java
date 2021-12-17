package br.com.quarkus.resource;

import br.com.quarkus.model.Ordem;
import br.com.quarkus.model.Usuario;
import br.com.quarkus.model.enuns.Status;
import br.com.quarkus.repository.OrdemRepository;
import br.com.quarkus.service.OrdemService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;

@Path("/ordens")
public class OrdemResource {
    @Inject
    private OrdemService ordemService;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed({"USER"})
    public void insert(Ordem ordem, @Context SecurityContext securityContext){
        this.ordemService.insertOrdem(securityContext, ordem);
    }

}
