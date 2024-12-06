package com.example.parqueadero.repositorio;

import com.example.parqueadero.modelo.Celda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CeldaRepositorio extends JpaRepository<Celda, Long> {
}
