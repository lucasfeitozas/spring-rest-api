package com.ifood.clone.application.service;

import com.ifood.clone.application.dto.RestauranteDTO;
import com.ifood.clone.domain.entity.Restaurante;
import com.ifood.clone.domain.repository.RestauranteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteService {
    private final RestauranteRepository restauranteRepository;
    private final ModelMapper modelMapper;

    public RestauranteService(RestauranteRepository restauranteRepository, ModelMapper modelMapper) {
        this.restauranteRepository = restauranteRepository;
        this.modelMapper = modelMapper;
    }

    public RestauranteDTO salvar(RestauranteDTO dto) {
        Restaurante restaurante = modelMapper.map(dto, Restaurante.class);
        Restaurante salvo = restauranteRepository.save(restaurante);
        return modelMapper.map(salvo, RestauranteDTO.class);
    }

    public List<RestauranteDTO> listarTodos() {
        return restauranteRepository.findAll().stream()
                .map(r -> modelMapper.map(r, RestauranteDTO.class))
                .collect(Collectors.toList());
    }
}
