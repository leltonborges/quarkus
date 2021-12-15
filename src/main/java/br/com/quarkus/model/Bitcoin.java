package br.com.quarkus.model;

import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;

public class Bitcoin {
    private Long id;
    @JsonbProperty("preco")
    private Double price;
    @JsonbProperty("tipo")
    private String type;
    @JsonbProperty("data")
    private LocalDate localDate;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
