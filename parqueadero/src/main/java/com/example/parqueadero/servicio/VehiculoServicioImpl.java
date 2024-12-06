package com.example.parqueadero.servicio;

import com.example.parqueadero.modelo.Vehiculo;
import com.example.parqueadero.repositorio.VehiculoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class VehiculoServicioImpl implements VehiculoServicio {

    @Autowired
    private VehiculoRepositorio vehiculoRepositorio;

    @Override
    public List<Vehiculo> listarVehiculos() {
        return vehiculoRepositorio.findAll();
    }

    @Override
    public Vehiculo registrarEntrada(Vehiculo vehiculo) {
        vehiculo.setHoraEntrada(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return vehiculoRepositorio.save(vehiculo);
    }

    @Override
    public Vehiculo registrarSalida(Long id) {
        Vehiculo vehiculo = vehiculoRepositorio.findById(id).orElseThrow();
        vehiculo.setHoraSalida(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        // Calcular costo basado en el tiempo
        vehiculo.setCostoTotal(calcularCosto(vehiculo.getHoraEntrada(), vehiculo.getHoraSalida()));
        return vehiculoRepositorio.save(vehiculo);
    }

    @Override
    public void eliminarVehiculo(Long id) {
        vehiculoRepositorio.deleteById(id);
    }

    private Double calcularCosto(String entrada, String salida) {
        // Implementación para cálculo de tiempo y tarifa
        return 20.0; // Ejemplo
    }
}
