package com.example.ms_empleado.service;

import com.example.ms_empleado.dto.EmpleadoRequestDTO;
import com.example.ms_empleado.dto.EmpleadoResponseDTO;
import com.example.ms_empleado.mapper.EmpleadoMapper;
import com.example.ms_empleado.model.Empleado;
import com.example.ms_empleado.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepository;
    private final EmpleadoMapper mapper;


    public Empleado localFindById(Long id){
        return empleadoRepository.findById(id).orElseThrow(()-> new RuntimeException("Empleado no encontrado"));
    }
    public EmpleadoResponseDTO crear(EmpleadoRequestDTO request){
        return mapper.toResponseDTO(empleadoRepository.save(mapper.toEntity(request)));
    }
    public List<EmpleadoResponseDTO> listarTodo(){
        return mapper.toListEmpleadoResponse(empleadoRepository.findAll());
    }
    public EmpleadoResponseDTO listarPorId(Long id){
        return mapper.toResponseDTO(localFindById(id));
    }
    public void eliminar(Long id){
        localFindById(id);
        empleadoRepository.deleteById(id);
    }
    public EmpleadoResponseDTO actualizar(Long id,EmpleadoRequestDTO request){
        Empleado empleado = localFindById(id);
        mapper.actualizarEmpleadoPorRequest(request,empleado);
        return mapper.toResponseDTO(empleadoRepository.save(empleado));
    }




}
