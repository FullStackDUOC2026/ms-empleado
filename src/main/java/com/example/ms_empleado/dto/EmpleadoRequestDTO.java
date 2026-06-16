package com.example.ms_empleado.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class EmpleadoRequestDTO {
    @NotBlank(message = "Debe completar el campo nombre")
    private String nombre;
    @NotBlank(message = "Debe completar el campo apellido")
    private String apellido;
    @NotBlank(message = "Debe completar el campo rut")
    private String dni;
    @NotBlank(message = "Debe completar el campo email")
    private String email;
    @NotBlank(message = "Debe completar el campo telefono")
    private String telefono;
    @NotBlank(message = "Debe completar el campo cargo")
    private String cargo;
    @NotBlank(message = "Debe completar el campo departamento")
    private String departamento;
    @NotNull(message = "Debe completar el campo salario")
    private Double salario;
    @NotNull(message = "Debe completar el campo fecha de contratacion")
    private LocalDate fechaContratacion;
}
