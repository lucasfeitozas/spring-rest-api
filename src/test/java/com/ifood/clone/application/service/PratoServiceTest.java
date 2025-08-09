package com.ifood.clone.application.service;

import com.ifood.clone.application.dto.PratoDTO;
import com.ifood.clone.domain.entity.Prato;
import com.ifood.clone.domain.entity.Restaurante;
import com.ifood.clone.domain.repository.PratoRepository;
import com.ifood.clone.domain.repository.RestauranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PratoServiceTest {
    @Mock
    private PratoRepository pratoRepository;
    @Mock
    private RestauranteRepository restauranteRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private PratoService pratoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarPrato() {
        PratoDTO dto = new PratoDTO();
        dto.setNome("Pizza");
        dto.setPreco(BigDecimal.TEN);
        dto.setRestauranteId(1L);
        Restaurante restaurante = new Restaurante();
        when(restauranteRepository.findById(1L)).thenReturn(Optional.of(restaurante));
        when(modelMapper.map(dto, Prato.class)).thenReturn(new Prato());
        when(pratoRepository.save(any(Prato.class))).thenReturn(new Prato());
        when(modelMapper.map(any(Prato.class), eq(PratoDTO.class))).thenReturn(new PratoDTO());
        PratoDTO result = pratoService.salvar(dto);
        assertNotNull(result);
    }
}
