package com.ifood.clone.domain.repository;

import com.ifood.clone.domain.entity.Prato;
import com.ifood.clone.domain.entity.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PratoRepository extends JpaRepository<Prato, Long> {
    List<Prato> findByRestaurante(Restaurante restaurante);
}
