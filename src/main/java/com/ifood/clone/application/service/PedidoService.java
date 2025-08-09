package com.ifood.clone.application.service;

import com.ifood.clone.application.dto.PedidoDTO;
import com.ifood.clone.domain.entity.Pedido;
import com.ifood.clone.domain.entity.Prato;
import com.ifood.clone.domain.repository.PedidoRepository;
import com.ifood.clone.domain.repository.PratoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PratoRepository pratoRepository;
    private final ModelMapper modelMapper;

    public PedidoService(PedidoRepository pedidoRepository, PratoRepository pratoRepository, ModelMapper modelMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pratoRepository = pratoRepository;
        this.modelMapper = modelMapper;
    }

    public PedidoDTO salvar(PedidoDTO dto) {
    Pedido pedido = new Pedido();
    List<Prato> pratos = dto.getPratosIds().stream()
        .map(id -> pratoRepository.findById(id)
            .orElseThrow(() -> new com.ifood.clone.application.exception.EntidadeNaoEncontradaException("Prato não encontrado: " + id)))
        .collect(Collectors.toList());
    pedido.setPratos(pratos);
    pedido.setValorTotal(dto.getValorTotal());
    Pedido salvo = pedidoRepository.save(pedido);
    return modelMapper.map(salvo, PedidoDTO.class);
    }
}
