package com.ifood.clone.infrastructure.repository;

import com.ifood.clone.domain.entity.Prato;
import com.ifood.clone.domain.entity.Restaurante;
import com.ifood.clone.domain.repository.PratoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PratoJpaRepository extends PratoRepository, JpaRepository<Prato, Long> {
    List<Prato> findByRestaurante(Restaurante restaurante);
}
