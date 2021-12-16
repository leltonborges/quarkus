package br.com.quarkus.resource;

import br.com.quarkus.model.Ordem;
import br.com.quarkus.model.Usuario;
import br.com.quarkus.repository.OrdemRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/ordens")
public class OrdemResource {
    @Inject
    private OrdemRepository ordemRepository;

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Ordem ordem){
        System.out.println(ordem);
        ordem.setDate(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordem.setUsuario(Usuario.findById(ordem.getUsuario().getId()));
//        ordem.setUsuario(user);
//        System.out.println(user);
        ordemRepository.persist(ordem);

    }

}
