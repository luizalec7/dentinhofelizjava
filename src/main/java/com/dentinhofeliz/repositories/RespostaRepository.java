package com.dentinhofeliz.repositories;

import com.dentinhofeliz.entities.Resposta;
import com.dentinhofeliz.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {

    List<Resposta> findByUsuario(Usuario usuario);
}
