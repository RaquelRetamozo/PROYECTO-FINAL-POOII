package Model.repositorios;

import Model.entidades.Despacho;
import java.util.ArrayList;
import java.util.List;

public class DespachoRepositoryMemoria implements IDespachoRepository {

    //Atributos
    private List<Despacho> despachos;

    //Constructor
    public DespachoRepositoryMemoria() {
        this.despachos = new ArrayList<>();
    }

    //Métodos
    @Override
    public void agregar(Despacho despacho) {
        despachos.add(despacho);
    }

    @Override
    public Despacho buscarPorId(String idDespacho) {
        for (Despacho d : despachos) {
            if (d.getIdDespacho().equals(idDespacho)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Despacho> listarTodos() {
        return despachos;
    }

    @Override
    public void actualizar(Despacho despacho) {
        for (int i = 0; i < despachos.size(); i++) {
            if (despachos.get(i).getIdDespacho().equals(despacho.getIdDespacho())) {
                despachos.set(i, despacho);
                return;
            }
        }
    }

    @Override
    public void eliminar(String idDespacho) {
        despachos.removeIf(d -> d.getIdDespacho().equals(idDespacho));
    }
}