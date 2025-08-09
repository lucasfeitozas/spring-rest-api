package com.ifood.clone.application.dto;

import jakarta.validation.constraints.NotBlank;

public class RestauranteDTO {
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String endereco;
    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
}
