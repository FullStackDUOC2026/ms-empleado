package com.example.ms_empleado.controller;

import com.example.ms_empleado.dto.EmpleadoRequestDTO;
import com.example.ms_empleado.dto.EmpleadoResponseDTO;
import com.example.ms_empleado.model.Empleado;
import com.example.ms_empleado.service.EmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/empleado")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> crear(@Valid @RequestBody EmpleadoRequestDTO request){
        return ResponseEntity.status(CREATED).body(empleadoService.crear(request));
    }
    @GetMapping
    public ResponseEntity<List<EmpleadoResponseDTO>> listarTodo(){
        return ResponseEntity.ok(empleadoService.listarTodo());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok(empleadoService.listarPorId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoResponseDTO> actualizarPorId(@PathVariable Long id, @Valid @RequestBody EmpleadoRequestDTO request){
        return ResponseEntity.ok(empleadoService.actualizar(id,request));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }



}
