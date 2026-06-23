package Model.repositorios;

import Model.entidades.Lote;

import java.util.ArrayList;
import java.util.List;
import Model.entidades.Lote;

public class LoteRepositoryMemoria implements ILoteRepository {

    //Atributos
    private List<Lote> lotes;

    //Constructor
    public LoteRepositoryMemoria() {
        this.lotes = new ArrayList<>();
    }

    //Métodos
    @Override
    public void agregar(Lote lote) {
        lotes.add(lote);
    }

    @Override
    public Lote buscarPorId(String idLote) {
        for (Lote l : lotes) {
            if (l.getIdLote().equals(idLote)) {
                return l;
            }
        }
        return null;
    }

    @Override
    public List<Lote> listarTodos() {
        return lotes;
    }

    @Override
    public void actualizar(Lote lote) {
        for (int i = 0; i < lotes.size(); i++) {
            if (lotes.get(i).getIdLote().equals(lote.getIdLote())) {
                lotes.set(i, lote);
                return;
            }
        }
    }

    @Override
    public void eliminar(String idLote) {
        lotes.removeIf(l -> l.getIdLote().equals(idLote));
    }
}