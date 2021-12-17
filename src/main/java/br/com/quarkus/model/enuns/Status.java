package br.com.quarkus.model.enuns;

import javax.ws.rs.NotFoundException;
import java.util.Arrays;

public enum Status {
    ENVIADA(1),
    PENDENTE(2),
    ANALISE(3),
    APROVADA(4);

    private int id;

    Status(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Status forStatus(Integer intStatus) {
        return Arrays.stream(Status.values())
                .filter(type -> type.getId() == intStatus)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("intStatus not found"));
    }
}
