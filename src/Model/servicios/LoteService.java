package Model.servicios;

import Model.entidades.Lote;
import Model.excepciones.LoteVencidoException;
import Model.repositorios.ILoteRepository;
import java.util.ArrayList;
import java.util.List;

public class LoteService {

    //Atributos
    private ILoteRepository loteRepository;

    //Constructor
    public LoteService(ILoteRepository loteRepository) {
        this.loteRepository = loteRepository;
    }

    //Métodos
    public void registrarLote(Lote lote) {
        if (lote.estaVencido()) {
            throw new LoteVencidoException(lote.getIdLote());
        }
        loteRepository.agregar(lote);
    }

    public Lote buscarLote(String idLote) {
        Lote lote = loteRepository.buscarPorId(idLote);
        if (lote == null) {
            throw new RuntimeException("Lote no encontrado: " + idLote);
        }
        return lote;
    }

    public List<Lote> listarLotes() {
        return loteRepository.listarTodos();
    }

    public void actualizarLote(Lote lote) {
        buscarLote(lote.getIdLote());
        loteRepository.actualizar(lote);
    }

    public void eliminarLote(String idLote) {
        buscarLote(idLote);
        loteRepository.eliminar(idLote);
    }

    public List<Lote> listarLotesVencidos() {
        List<Lote> vencidos = new ArrayList<>();
        for (Lote l : loteRepository.listarTodos()) {
            if (l.estaVencido()) {
                vencidos.add(l);
            }
        }
        return vencidos;
    }

    public List<Lote> listarLotesActivos() {
        List<Lote> activos = new ArrayList<>();
        for (Lote l : loteRepository.listarTodos()) {
            if (!l.estaVencido()) {
                activos.add(l);
            }
        }
        return activos;
    }
}