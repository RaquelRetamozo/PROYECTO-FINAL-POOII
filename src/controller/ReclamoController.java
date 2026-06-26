package controller;

import Model.entidades.Reclamo;
import Model.servicios.ReclamoService;
import java.util.List;

public class ReclamoController {

    //Atributos
    private ReclamoService reclamoService;

    //Constructor
    public ReclamoController(ReclamoService reclamoService) {
        this.reclamoService = reclamoService;
    }

    //Métodos
    public void registrarReclamo(Reclamo reclamo) {
        reclamoService.registrarReclamo(reclamo);
        System.out.println("Reclamo registrado correctamente.");
    }

    public Reclamo buscarReclamo(String idReclamo) {
        return reclamoService.buscarReclamo(idReclamo);
    }

    public List<Reclamo> listarTodos() {
        return reclamoService.listarTodos();
    }

    public List<Reclamo> listarPendientes() {
        return reclamoService.listarPendientes();
    }

    public void resolverReclamo(String idReclamo) {
        reclamoService.resolverReclamo(idReclamo);
        System.out.println("Reclamo resuelto correctamente.");
    }

    public void cerrarReclamo(String idReclamo) {
        reclamoService.cerrarReclamo(idReclamo);
        System.out.println("Reclamo cerrado correctamente.");
    }
}