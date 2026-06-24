package Model.servicios;

import Model.entidades.Despacho;
import Model.entidades.Lote;
import Model.entidades.MovimientoInventario;
import Model.repositorios.IDespachoRepository;
import Model.repositorios.IMovimientoRepository;
import java.util.ArrayList;
import java.util.List;

public class TrazabilidadService {

    //Atributos
    private IDespachoRepository despachoRepository;
    private IMovimientoRepository movimientoRepository;

    //Constructor
    public TrazabilidadService(IDespachoRepository despachoRepository,
                               IMovimientoRepository movimientoRepository) {
        this.despachoRepository = despachoRepository;
        this.movimientoRepository = movimientoRepository;
    }

    //Métodos
    public List<Despacho> buscarDespachosPorLote(String numeroLote) {
        List<Despacho> resultado = new ArrayList<>();
        for (Despacho d : despachoRepository.listarTodos()) {
            for (var detalle : d.getDetalles()) {
                if (detalle.getLote().getNumeroLote().equals(numeroLote)) {
                    resultado.add(d);
                    break;
                }
            }
        }
        return resultado;
    }

    public List<Despacho> buscarDespachosPorCliente(String idCliente) {
        List<Despacho> resultado = new ArrayList<>();
        for (Despacho d : despachoRepository.listarTodos()) {
            if (d.getCliente().getIdCliente().equals(idCliente)) {
                resultado.add(d);
            }
        }
        return resultado;
    }

    public List<MovimientoInventario> buscarMovimientosPorLote(String idLote) {
        List<MovimientoInventario> resultado = new ArrayList<>();
        for (MovimientoInventario m : movimientoRepository.listarTodos()) {
            if (m.getLote().getIdLote().equals(idLote)) {
                resultado.add(m);
            }
        }
        return resultado;
    }

    public void registrarMovimiento(MovimientoInventario movimiento) {
        movimientoRepository.agregar(movimiento);
    }

    public List<MovimientoInventario> listarMovimientos() {
        return movimientoRepository.listarTodos();
    }
}
