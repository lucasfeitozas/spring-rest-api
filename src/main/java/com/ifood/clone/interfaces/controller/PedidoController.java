package com.ifood.clone.interfaces.controller;

import com.ifood.clone.application.dto.PedidoDTO;
import com.ifood.clone.application.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> criar(@Valid @RequestBody PedidoDTO dto) {
        return ResponseEntity.ok(pedidoService.salvar(dto));
    }
}
