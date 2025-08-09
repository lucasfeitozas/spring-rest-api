package com.ifood.clone.application.service;

import com.ifood.clone.application.dto.RestauranteDTO;
import com.ifood.clone.domain.entity.Restaurante;
import com.ifood.clone.domain.repository.RestauranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestauranteServiceTest {
    @Mock
    private RestauranteRepository restauranteRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private RestauranteService restauranteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveListarRestaurantes() {
        Restaurante restaurante = new Restaurante();
        when(restauranteRepository.findAll()).thenReturn(Collections.singletonList(restaurante));
        when(modelMapper.map(any(Restaurante.class), eq(RestauranteDTO.class))).thenReturn(new RestauranteDTO());
        List<RestauranteDTO> result = restauranteService.listarTodos();
        assertEquals(1, result.size());
    }
}
