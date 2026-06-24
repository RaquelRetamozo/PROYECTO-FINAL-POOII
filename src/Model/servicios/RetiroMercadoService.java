package Model.servicios;

import Model.entidades.Despacho;
import Model.repositorios.IDespachoRepository;
import java.util.ArrayList;
import java.util.List;

public class RetiroMercadoService {

    //Atributos
    private IDespachoRepository despachoRepository;

    //Constructor
    public RetiroMercadoService(IDespachoRepository despachoRepository) {
        this.despachoRepository = despachoRepository;
    }

    //Métodos
    public List<Despacho> buscarDespachosPorLote(String numeroLote) {
        List<Despacho> afectados = new ArrayList<>();
        for (Despacho d : despachoRepository.listarTodos()) {
            for (var detalle : d.getDetalles()) {
                if (detalle.getLote().getNumeroLote().equals(numeroLote)) {
                    afectados.add(d);
                    break;
                }
            }
        }
        return afectados;
    }

    public void ejecutarRetiro(String numeroLote) {
        List<Despacho> afectados = buscarDespachosPorLote(numeroLote);
        for (Despacho d : afectados) {
            d.setEstado("CANCELADO");
            d.setObservacion("Retiro de mercado - Lote: " + numeroLote);
            despachoRepository.actualizar(d);
        }
    }
}