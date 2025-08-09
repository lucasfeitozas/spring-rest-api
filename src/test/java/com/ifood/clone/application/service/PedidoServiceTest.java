package com.ifood.clone.application.service;

import com.ifood.clone.application.dto.PedidoDTO;
import com.ifood.clone.domain.entity.Pedido;
import com.ifood.clone.domain.entity.Prato;
import com.ifood.clone.domain.repository.PedidoRepository;
import com.ifood.clone.domain.repository.PratoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoServiceTest {
    @Mock
    private PedidoRepository pedidoRepository;
    @Mock
    private PratoRepository pratoRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarPedido() {
        PedidoDTO dto = new PedidoDTO();
        dto.setPratosIds(Arrays.asList(1L, 2L));
        dto.setValorTotal(BigDecimal.TEN);
        when(pratoRepository.findById(anyLong())).thenReturn(Optional.of(new Prato()));
        when(pedidoRepository.save(any(Pedido.class))).thenReturn(new Pedido());
        when(modelMapper.map(any(Pedido.class), eq(PedidoDTO.class))).thenReturn(new PedidoDTO());
        PedidoDTO result = pedidoService.salvar(dto);
        assertNotNull(result);
    }
}
