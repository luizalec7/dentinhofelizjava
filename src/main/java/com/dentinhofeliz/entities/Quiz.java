package com.dentinhofeliz.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String pergunta;

    @Column(nullable = false)
    private String respostaCorreta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
