package controller;

import Model.entidades.NoConformidad;
import Model.servicios.NoConformidadService;
import java.util.List;

public class NoConformidadController {

    //Atributos
    private NoConformidadService noConformidadService;

    //Constructor
    public NoConformidadController(NoConformidadService noConformidadService) {
        this.noConformidadService = noConformidadService;
    }

    //Métodos
    public void registrarNoConformidad(NoConformidad noConformidad) {
        noConformidadService.registrarNoConformidad(noConformidad);
        System.out.println("No conformidad registrada correctamente.");
    }

    public NoConformidad buscarNoConformidad(String idNoConformidad) {
        return noConformidadService.buscarNoConformidad(idNoConformidad);
    }

    public List<NoConformidad> listarTodas() {
        return noConformidadService.listarTodas();
    }

    public List<NoConformidad> listarCriticas() {
        return noConformidadService.listarCriticas();
    }

    public void cerrarNoConformidad(String idNoConformidad) {
        noConformidadService.cerrarNoConformidad(idNoConformidad);
        System.out.println("No conformidad cerrada correctamente.");
    }
}