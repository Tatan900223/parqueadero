package com.example.parqueadero.servicio;

import com.example.parqueadero.modelo.Vehiculo;

import java.util.List;

public interface VehiculoServicio {
    List<Vehiculo> listarVehiculos();
    Vehiculo registrarEntrada(Vehiculo vehiculo);
    Vehiculo registrarSalida(Long id);
    void eliminarVehiculo(Long id);
}
