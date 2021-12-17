package br.com.quarkus.model.enuns;

import javax.ws.rs.NotFoundException;
import java.util.Arrays;

public enum Type {
    COMPRA(1),
    VENDA(2);

    private Integer id;

    Type(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Type forType(Integer intType) {
        return Arrays.stream(Type.values())
                .filter(type -> type.getId() == intType)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("intType not found"));
    }
}
