package com.microservicio.backend_mascotas.repository;

import com.microservicio.backend_mascotas.model.MascotaDto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MascotaRepository {

    private final List<MascotaDto> mascotas = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<MascotaDto> findAll() {
        return mascotas;
    }

    public Optional<MascotaDto> findById(Long id) {
        return mascotas.stream().filter(m -> m.getIdMascota().equals(id)).findFirst();
    }

    public Optional<MascotaDto> findByNombreAndRutCliente(String nombre, String rutCliente) {
        return mascotas.stream().filter(m -> m.getNombre().equalsIgnoreCase(nombre)
                && m.getRutCliente().equalsIgnoreCase(rutCliente)).findFirst();
    }

    public MascotaDto save(MascotaDto mascota) {
        mascota.setIdMascota(idGenerator.incrementAndGet());
        mascotas.add(mascota);
        return mascota;
    }

    public boolean update(Long id, MascotaDto mascota) {
        for (int i = 0; i < mascotas.size(); i++) {
            if (mascotas.get(i).getIdMascota().equals(id)) {
                mascota.setIdMascota(id);
                mascotas.set(i, mascota);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Long id) {
        return mascotas.removeIf(m -> m.getIdMascota().equals(id));
    }
}
