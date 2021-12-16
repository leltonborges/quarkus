package br.com.quarkus.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Ordem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    private String type;
    private LocalDate date;
    private String Status;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @Column(name = "user_id")
    private Usuario usuario;

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
