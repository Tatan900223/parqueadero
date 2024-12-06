package com.example.parqueadero.modelo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Table_VEHICULO")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String tipo; // Carro, moto, etc.
    private String horaEntrada;
    private String horaSalida;
    private Double costoTotal;

    @ManyToOne
    @JoinColumn(name = "celda_id")
    private Celda celda;
}
