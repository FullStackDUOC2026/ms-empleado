package com.example.ms_empleado.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name="Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String apellido;
    @Column(nullable = false, length = 30)
    private String dni;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 20)
    private String telefono;
    @Column(nullable = false, length = 50)
    private String cargo;
    @Column(nullable = false, length = 50)
    private String departamento;
    @Column(nullable = false)
    private Double salario;
    @Column(nullable = false)
    private LocalDate fechaContratacion;



}
