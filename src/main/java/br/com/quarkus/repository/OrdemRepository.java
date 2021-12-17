package br.com.quarkus.repository;

import br.com.quarkus.model.Ordem;
import br.com.quarkus.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@ApplicationScoped
//public class OrdemRepository implements PanacheRepository<Ordem> {
@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {
//    @Query("select o from Ordem o letf join o.usuario u where u.userName = :username ")
//    List<Ordem> findByOrderByUsuario(@Param("username") String userName);
}
