package br.com.quarkus.model;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.IgnoreProperty;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

@Entity
@UserDefinition
@Table(name = "Usuario")
public class Usuario extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonbProperty("nome")
    @Column(name = "nome")
    private String name;
    private String cpf;
    @Username
    private String username;

    @Password
    private String password;
    @Roles
    private String profile;

    public Usuario() {}

    public Usuario(Long id, String name, String cpf, String username, String password, String profiles) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.username = username;
        this.password = password;
        this.profile = profiles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonbTransient
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public static void addUser(Usuario usuario){
        usuario.password = BcryptUtil.bcryptHash(usuario.password);
        usuario.profile = usuario.valideUsername(usuario.username);
        usuario.persist();
    }

    private String valideUsername(String username){
        if(username.equals("beta")) return "ADMIN";
        else return "USER";
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
