package controller;

import Model.entidades.Lote;
import Model.servicios.LoteService;
import java.util.List;

public class LoteController {

    //Atributos
    private LoteService loteService;

    //Constructor
    public LoteController(LoteService loteService) {
        this.loteService = loteService;
    }

    //Métodos
    public void registrarLote(Lote lote) {
        loteService.registrarLote(lote);
        System.out.println("Lote registrado correctamente.");
    }

    public Lote buscarLote(String idLote) {
        return loteService.buscarLote(idLote);
    }

    public List<Lote> listarLotes() {
        return loteService.listarLotes();
    }

    public void actualizarLote(Lote lote) {
        loteService.actualizarLote(lote);
        System.out.println("Lote actualizado correctamente.");
    }

    public void eliminarLote(String idLote) {
        loteService.eliminarLote(idLote);
        System.out.println("Lote eliminado correctamente.");
    }

    public List<Lote> listarLotesVencidos() {
        return loteService.listarLotesVencidos();
    }

    public List<Lote> listarLotesActivos() {
        return loteService.listarLotesActivos();
    }
}