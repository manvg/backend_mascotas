package com.microservicio.backend_mascotas.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class MascotaDto {

    private Long idMascota;

    @NotBlank(message = "El nombre de la mascota es obligatorio")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombre;

    @NotBlank(message = "La especie es obligatoria")
    @Size(max = 50, message = "La especie no puede tener más de 50 caracteres")
    private String especie;

    @Size(max = 100, message = "La raza no puede tener más de 100 caracteres")
    private String raza;

    @Pattern(regexp = "[MF]", message = "El sexo debe ser 'M' o 'F'")
    private String sexo;

    @DecimalMin(value = "0.0", inclusive = false, message = "El peso debe ser mayor a 0")
    @Digits(integer = 3, fraction = 2, message = "El peso debe tener hasta 3 dígitos enteros y 2 decimales")
    private Double pesoKg;

    @Size(max = 255, message = "Las observaciones no pueden tener más de 255 caracteres")
    private String observaciones;

    @NotBlank(message = "El RUT del cliente es obligatorio")
    @Size(max = 20, message = "El RUT no puede tener más de 20 caracteres")
    private String rutCliente;
}