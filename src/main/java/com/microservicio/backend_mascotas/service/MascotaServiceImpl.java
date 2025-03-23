package com.microservicio.backend_mascotas.service;

import com.microservicio.backend_mascotas.model.MascotaDto;
import com.microservicio.backend_mascotas.repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaServiceImpl implements MascotaService {

    @Autowired
    private MascotaRepository repository;

    @Override
    public List<MascotaDto> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<MascotaDto> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public MascotaDto create(MascotaDto mascota) {
        return repository.save(mascota);
    }

    @Override
    public Optional<MascotaDto> update(Long id, MascotaDto mascota) {
        boolean updated = repository.update(id, mascota);
        return updated ? Optional.of(mascota) : Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}
