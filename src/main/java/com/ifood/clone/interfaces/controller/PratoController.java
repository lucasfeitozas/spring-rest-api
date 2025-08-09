package com.ifood.clone.interfaces.controller;

import com.ifood.clone.application.dto.PratoDTO;
import com.ifood.clone.application.service.PratoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PratoController {
    private final PratoService pratoService;

    public PratoController(PratoService pratoService) {
        this.pratoService = pratoService;
    }

    @PostMapping("/pratos")
    public ResponseEntity<PratoDTO> cadastrar(@Valid @RequestBody PratoDTO dto) {
        return ResponseEntity.ok(pratoService.salvar(dto));
    }

    @GetMapping("/restaurantes/{restauranteId}/pratos")
    public ResponseEntity<List<PratoDTO>> listarPorRestaurante(@PathVariable Long restauranteId) {
        return ResponseEntity.ok(pratoService.listarPorRestaurante(restauranteId));
    }
}
