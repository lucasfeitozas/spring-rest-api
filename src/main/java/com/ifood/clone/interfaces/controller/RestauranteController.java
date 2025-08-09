package com.ifood.clone.interfaces.controller;

import com.ifood.clone.application.dto.RestauranteDTO;
import com.ifood.clone.application.service.RestauranteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    @PostMapping
    public ResponseEntity<RestauranteDTO> cadastrar(@Valid @RequestBody RestauranteDTO dto) {
        return ResponseEntity.ok(restauranteService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> listar() {
        return ResponseEntity.ok(restauranteService.listarTodos());
    }
}
