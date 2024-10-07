package com.dentinhofeliz.dto;

import java.time.LocalTime;

public class AlarmeDTO {

    private Long id;
    private LocalTime hora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
