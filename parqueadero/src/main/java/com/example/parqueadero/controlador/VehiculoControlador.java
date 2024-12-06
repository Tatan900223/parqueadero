package com.example.parqueadero.controlador;

import com.example.parqueadero.modelo.Vehiculo;
import com.example.parqueadero.servicio.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehiculos")
public class VehiculoControlador {

    @Autowired
    private VehiculoServicio vehiculoServicio;

    @GetMapping
    public String listarVehiculos(Model model) {
        model.addAttribute("vehiculos", vehiculoServicio.listarVehiculos());
        return "vehiculos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        return "nuevoVehiculo";
    }

    @PostMapping
    public String registrarEntrada(@ModelAttribute Vehiculo vehiculo) {
        vehiculoServicio.registrarEntrada(vehiculo);
        return "redirect:/vehiculos";
    }

    @GetMapping("/salida/{id}")
    public String registrarSalida(@PathVariable Long id) {
        vehiculoServicio.registrarSalida(id);
        return "redirect:/vehiculos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarVehiculo(@PathVariable Long id) {
        vehiculoServicio.eliminarVehiculo(id);
        return "redirect:/vehiculos";
    }
}
