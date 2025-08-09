package com.ifood.clone.infrastructure.repository;

import com.ifood.clone.domain.entity.Restaurante;
import com.ifood.clone.domain.repository.RestauranteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteJpaRepository extends RestauranteRepository, JpaRepository<Restaurante, Long> {
}
