package com.dentinhofeliz.dto;

import lombok.Data;

@Data
public class RespostaDTO {

    private Long id;
    private Long usuarioId;
    private Long quizId;
    private String respostaUsuario;
    private boolean correta;
}
