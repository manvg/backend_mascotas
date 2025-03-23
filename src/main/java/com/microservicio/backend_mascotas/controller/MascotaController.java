package com.microservicio.backend_mascotas.controller;

import com.microservicio.backend_mascotas.model.MascotaDto;
import com.microservicio.backend_mascotas.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {

    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public List<MascotaDto> getAllMascotas() {
        return mascotaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMascotaById(@PathVariable Long id) {
        return mascotaService.getById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada"));
    }

    @PostMapping
    public ResponseEntity<?> createMascota(@RequestBody @Valid MascotaDto mascota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mascotaService.create(mascota));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMascota(@PathVariable Long id, @RequestBody @Valid MascotaDto mascota) {
        return mascotaService.update(id, mascota)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMascota(@PathVariable Long id) {
        boolean deleted = mascotaService.delete(id);
        if (deleted) {
            return ResponseEntity.ok("Mascota eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mascota no encontrada");
        }
    }
}
