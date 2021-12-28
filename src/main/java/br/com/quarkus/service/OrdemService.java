package br.com.quarkus.service;

import br.com.quarkus.model.Ordem;
import br.com.quarkus.model.Usuario;
import br.com.quarkus.model.enuns.Status;
import br.com.quarkus.repository.OrdemRepository;
import io.quarkus.security.jpa.Username;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    @Inject
    private OrdemRepository ordemRepository;

    public Response insertOrdem(SecurityContext context, Ordem ordem){
        Optional<Usuario> optional = Usuario.findByIdOptional(ordem.getUsuario().getId());
        Usuario user = optional.orElseThrow();
        if(!user.getUsername().equals(context.getUserPrincipal().getName())){
            throw  new RuntimeException("Usuário logado não condiz");
        }
        ordem.setDate(LocalDate.now());
        ordem.setStatus(Status.ENVIADA);
        ordem.setUsuario(Usuario.findById(ordem.getUsuario().getId()));
        ordemRepository.persist(ordem);
        return  Response.ok(ordem).status(Response.Status.CREATED).build();
    }

    public List<Ordem> findAll(){
        return ordemRepository.listAll();
    }

}
