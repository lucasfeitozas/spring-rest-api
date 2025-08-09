package com.ifood.clone.infrastructure.repository;

import com.ifood.clone.domain.entity.Pedido;
import com.ifood.clone.domain.repository.PedidoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoJpaRepository extends PedidoRepository, JpaRepository<Pedido, Long> {
}
