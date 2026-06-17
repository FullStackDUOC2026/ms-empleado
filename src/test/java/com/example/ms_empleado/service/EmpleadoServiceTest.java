package com.example.ms_empleado.service;

import com.example.ms_empleado.dto.EmpleadoRequestDTO;
import com.example.ms_empleado.dto.EmpleadoResponseDTO;
import com.example.ms_empleado.mapper.EmpleadoMapper;
import com.example.ms_empleado.model.Empleado;
import com.example.ms_empleado.repository.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmpleadoServiceTest {
    @Mock
    private EmpleadoRepository empleadoRepositoryTest;
    @Mock
    private EmpleadoMapper mapperTest;
    @InjectMocks
    private EmpleadoService empleadoService;

    @Test
    void localFindById_Existe() {
        //ARRANGE
        Empleado varEmpleado = Empleado.builder()
                .id(1L)
                .nombre("JESUS")
                .build();
        when(empleadoRepositoryTest.findById(1L)).thenReturn(Optional.of(varEmpleado));

        //ACT
        Empleado resultado = empleadoService.localFindById(1L);

        //Assert
        assertEquals(1L,resultado.getId());
        assertEquals("JESUS",resultado.getNombre());
    }
    @Test
    void crear() {
        //Arrange
        Empleado varEmpleado = Empleado.builder()
                .id(1L)
                .nombre("Juan")
                .apellido("Cortez")
                .dni("23.863.872-0")
                .email("pat.ormazabal@duocuc.cl")
                .telefono("+569 9999 9999")
                .cargo("Gerente")
                .departamento("Departamento Informatico")
                .salario(15D)
                .build();

        EmpleadoRequestDTO request = EmpleadoRequestDTO.builder()
                .nombre("Juan")
                .apellido("Cortez")
                .dni("23.863.872-0")
                .email("pat.ormazabal@duocuc.cl")
                .telefono("+569 9999 9999")
                .cargo("Gerente")
                .departamento("Departamento Informatico")
                .salario(15D)
                .build();

        EmpleadoResponseDTO response = EmpleadoResponseDTO.builder()
                .nombre("Juan")
                .apellido("Cortez")
                .dni("23.863.872-0")
                .email("pat.ormazabal@duocuc.cl")
                .telefono("+569 9999 9999")
                .cargo("Gerente")
                .departamento("Departamento Informatico")
                .salario(15D)
                .build();

        when(empleadoRepositoryTest.save(varEmpleado)).thenReturn(varEmpleado);

        //ACT
        EmpleadoResponseDTO respuesta = empleadoService.crear(request);

        //assert
        assertEquals("Juan",respuesta.getNombre());
        assertEquals("Cortez",respuesta.getApellido());
        assertEquals("23.863.872-0",respuesta.getDni());
        assertEquals("pat.ormazabal@duocuc.cl",respuesta.getEmail());
        assertEquals("+569 9999 9999",respuesta.getTelefono());
        assertEquals("Gerente",respuesta.getCargo());
        assertEquals("Departamento Informatico",respuesta.getDepartamento());
        assertEquals(15D,respuesta.getSalario());


    }

    @Test
    void listarTodo() {
    }

    @Test
    void listarPorId() {
    }

    @Test
    void eliminar() {
    }

    @Test
    void actualizar() {
    }
}