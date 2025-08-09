package com.ifood.clone.application.service;

import com.ifood.clone.application.dto.PratoDTO;
import com.ifood.clone.domain.entity.Prato;
import com.ifood.clone.domain.entity.Restaurante;
import com.ifood.clone.domain.repository.PratoRepository;
import com.ifood.clone.domain.repository.RestauranteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PratoService {
    private final PratoRepository pratoRepository;
    private final RestauranteRepository restauranteRepository;
    private final ModelMapper modelMapper;

    public PratoService(PratoRepository pratoRepository, RestauranteRepository restauranteRepository, ModelMapper modelMapper) {
        this.pratoRepository = pratoRepository;
        this.restauranteRepository = restauranteRepository;
        this.modelMapper = modelMapper;
    }

    public PratoDTO salvar(PratoDTO dto) {
    Prato prato = modelMapper.map(dto, Prato.class);
    Restaurante restaurante = restauranteRepository.findById(dto.getRestauranteId())
        .orElseThrow(() -> new com.ifood.clone.application.exception.EntidadeNaoEncontradaException("Restaurante não encontrado"));
    prato.setRestaurante(restaurante);
    Prato salvo = pratoRepository.save(prato);
    return modelMapper.map(salvo, PratoDTO.class);
    }

    public List<PratoDTO> listarPorRestaurante(Long restauranteId) {
    Restaurante restaurante = restauranteRepository.findById(restauranteId)
        .orElseThrow(() -> new com.ifood.clone.application.exception.EntidadeNaoEncontradaException("Restaurante não encontrado"));
    return pratoRepository.findByRestaurante(restaurante).stream()
        .map(p -> modelMapper.map(p, PratoDTO.class))
        .collect(Collectors.toList());
    }
}
