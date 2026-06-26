package controller;

import Model.entidades.Despacho;
import Model.entidades.MovimientoInventario;
import Model.servicios.TrazabilidadService;
import java.util.List;

public class TrazabilidadController {

    //Atributos
    private TrazabilidadService trazabilidadService;

    //Constructor
    public TrazabilidadController(TrazabilidadService trazabilidadService) {
        this.trazabilidadService = trazabilidadService;
    }

    //Métodos
    public List<Despacho> buscarPorLote(String numeroLote) {
        return trazabilidadService.buscarDespachosPorLote(numeroLote);
    }

    public List<Despacho> buscarPorCliente(String idCliente) {
        return trazabilidadService.buscarDespachosPorCliente(idCliente);
    }

    public List<MovimientoInventario> buscarMovimientosPorLote(String idLote) {
        return trazabilidadService.buscarMovimientosPorLote(idLote);
    }

    public void registrarMovimiento(MovimientoInventario movimiento) {
        trazabilidadService.registrarMovimiento(movimiento);
        System.out.println("Movimiento registrado correctamente.");
    }

    public List<MovimientoInventario> listarMovimientos() {
        return trazabilidadService.listarMovimientos();
    }
}
