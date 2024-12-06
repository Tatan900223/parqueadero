package com.example.parqueadero.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Table_CELDA")
public class Celda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo; // Ejemplo: A1, B2
    private boolean disponible;

    @OneToOne(mappedBy = "celda")
    private Vehiculo vehiculo;
}
