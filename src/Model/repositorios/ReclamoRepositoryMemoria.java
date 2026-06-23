package Model.repositorios;

import Model.entidades.Reclamo;
import java.util.ArrayList;
import java.util.List;

public class ReclamoRepositoryMemoria implements IReclamoRepository {

    //Atributos
    private List<Reclamo> reclamos;

    //Constructor
    public ReclamoRepositoryMemoria() {
        this.reclamos = new ArrayList<>();
    }

    //Métodos
    @Override
    public void agregar(Reclamo reclamo) {
        reclamos.add(reclamo);
    }

    @Override
    public Reclamo buscarPorId(String idReclamo) {
        for (Reclamo r : reclamos) {
            if (r.getIdReclamo().equals(idReclamo)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Reclamo> listarTodos() {
        return reclamos;
    }

    @Override
    public void actualizar(Reclamo reclamo) {
        for (int i = 0; i < reclamos.size(); i++) {
            if (reclamos.get(i).getIdReclamo().equals(reclamo.getIdReclamo())) {
                reclamos.set(i, reclamo);
                return;
            }
        }
    }

    @Override
    public void eliminar(String idReclamo) {
        reclamos.removeIf(r -> r.getIdReclamo().equals(idReclamo));
    }
}
