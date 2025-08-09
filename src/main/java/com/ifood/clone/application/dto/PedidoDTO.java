package com.ifood.clone.application.dto;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {
    private Long id;
    @NotNull
    private List<Long> pratosIds;
    @NotNull
    private BigDecimal valorTotal;
    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<Long> getPratosIds() { return pratosIds; }
    public void setPratosIds(List<Long> pratosIds) { this.pratosIds = pratosIds; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
}
