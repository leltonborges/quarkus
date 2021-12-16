package br.com.quarkus.model;

import br.com.quarkus.model.enuns.Status;
import br.com.quarkus.model.enuns.Type;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Ordem extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonbProperty("preco")
    @Column(name = "preco")
    private Double price;
    @JsonbProperty("tipo")
    @Column(name = "tipo")
    private Type type;
    @JsonbProperty("data")
    @Column(name = "data")
    private LocalDate date;
    private Status status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setType(Integer type) {
        this.type = Type.forType(type);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", Status='" + status + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
