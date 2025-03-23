package com.microservicio.backend_mascotas.repository;

import com.microservicio.backend_mascotas.model.MascotaDto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MascotaRepository {

    private final List<MascotaDto> mascotas = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public MascotaRepository() {
        MascotaDto m1 = new MascotaDto();
    m1.setIdMascota(idGenerator.incrementAndGet());
    m1.setNombre("Luna");
    m1.setEspecie("Perro");
    m1.setRaza("Labrador Retriever");
    m1.setSexo("F");
    m1.setPesoKg(23.5);
    m1.setObservaciones("Muy activa, necesita espacio");
    m1.setRutCliente("12345678-9");
    mascotas.add(m1);

    MascotaDto m2 = new MascotaDto();
    m2.setIdMascota(idGenerator.incrementAndGet());
    m2.setNombre("Max");
    m2.setEspecie("Gato");
    m2.setRaza("Siames");
    m2.setSexo("M");
    m2.setPesoKg(4.2);
    m2.setObservaciones("Tranquilo y dormilón");
    m2.setRutCliente("98765432-1");
    mascotas.add(m2);

    MascotaDto m3 = new MascotaDto();
    m3.setIdMascota(idGenerator.incrementAndGet());
    m3.setNombre("Coco");
    m3.setEspecie("Perro");
    m3.setRaza("Poodle");
    m3.setSexo("M");
    m3.setPesoKg(8.0);
    m3.setObservaciones("Alergias estacionales");
    m3.setRutCliente("24681357-0");
    mascotas.add(m3);

    MascotaDto m4 = new MascotaDto();
    m4.setIdMascota(idGenerator.incrementAndGet());
    m4.setNombre("Maya");
    m4.setEspecie("Conejo");
    m4.setRaza("Enano holandés");
    m4.setSexo("F");
    m4.setPesoKg(1.3);
    m4.setObservaciones("Dieta estricta");
    m4.setRutCliente("13579246-8");
    mascotas.add(m4);

    MascotaDto m5 = new MascotaDto();
    m5.setIdMascota(idGenerator.incrementAndGet());
    m5.setNombre("Rocky");
    m5.setEspecie("Perro");
    m5.setRaza("Bulldog Francés");
    m5.setSexo("M");
    m5.setPesoKg(12.4);
    m5.setObservaciones("Le teme a los truenos");
    m5.setRutCliente("10293847-6");
    mascotas.add(m5);
    }

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
