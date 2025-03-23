package com.microservicio.backend_mascotas.service;

import com.microservicio.backend_mascotas.model.MascotaDto;

import java.util.List;
import java.util.Optional;

public interface MascotaService {
    List<MascotaDto> getAll();
    Optional<MascotaDto> getById(Long id);
    MascotaDto create(MascotaDto mascota);
    Optional<MascotaDto> update(Long id, MascotaDto mascota);
    boolean delete(Long id);
}