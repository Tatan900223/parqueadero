package com.example.parqueadero.repositorio;

import com.example.parqueadero.modelo.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepositorio extends JpaRepository<Vehiculo, Long> {
}
