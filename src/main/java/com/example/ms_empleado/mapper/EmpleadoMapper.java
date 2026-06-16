package com.example.ms_empleado.mapper;

import com.example.ms_empleado.dto.EmpleadoRequestDTO;
import com.example.ms_empleado.dto.EmpleadoResponseDTO;
import com.example.ms_empleado.model.Empleado;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmpleadoMapper {

    EmpleadoResponseDTO toResponseDTO(Empleado empleado);

    Empleado toEntity(EmpleadoRequestDTO request);

    List<EmpleadoResponseDTO> toListEmpleadoResponse(List<Empleado> listEmpleado);

    void  actualizarEmpleadoPorRequest(EmpleadoRequestDTO request, @MappingTarget Empleado emp);
}
