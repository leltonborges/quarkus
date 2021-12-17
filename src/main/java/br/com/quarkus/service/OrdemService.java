package br.com.quarkus.service;

import br.com.quarkus.model.Ordem;
import br.com.quarkus.model.Usuario;
import br.com.quarkus.model.enuns.Status;
import br.com.quarkus.repository.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;
import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
public class OrdemService {

    @Inject
    private OrdemRepository ordemRepository;

    public void insertOrdem(SecurityContext context, Ordem ordem){
        Optional<Usuario> optional = Usuario.findByIdOptional(ordem.getUsuario().getId());
        Usuario user = optional.orElseThrow();
        if(!user.getUsername().equals(context.getUserPrincipal().getName())){
            throw  new RuntimeException("Usuário logado não condiz");
        }
        ordem.setDate(LocalDate.now());
        ordem.setStatus(Status.ENVIADA);
        ordem.setUsuario(Usuario.findById(ordem.getUsuario().getId()));
        System.out.println(ordem);
        ordemRepository.persist(ordem);
    }

}
