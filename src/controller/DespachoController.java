package controller;

import Model.entidades.Despacho;
import Model.entidades.DetalleDespacho;
import Model.servicios.DespachoService;
import java.util.List;

public class DespachoController {

    //Atributos
    private DespachoService despachoService;

    //Constructor
    public DespachoController(DespachoService despachoService) {
        this.despachoService = despachoService;
    }

    //Métodos
    public void registrarDespacho(Despacho despacho) {
        despachoService.registrarDespacho(despacho);
        System.out.println("Despacho registrado correctamente.");
    }

    public Despacho buscarDespacho(String idDespacho) {
        return despachoService.buscarDespacho(idDespacho);
    }

    public List<Despacho> listarDespachos() {
        return despachoService.listarDespachos();
    }

    public void actualizarEstado(String idDespacho, String nuevoEstado) {
        despachoService.actualizarEstado(idDespacho, nuevoEstado);
        System.out.println("Estado actualizado correctamente.");
    }

    public void agregarDetalle(String idDespacho, DetalleDespacho detalle) {
        despachoService.agregarDetalle(idDespacho, detalle);
        System.out.println("Detalle agregado correctamente.");
    }

    public List<Despacho> listarPendientes() {
        return despachoService.listarPendientes();
    }
}
