package Model.servicios;

import Model.entidades.Reclamo;
import Model.repositorios.IReclamoRepository;
import java.util.ArrayList;
import java.util.List;

public class ReclamoService {

    //Atributos
    private IReclamoRepository reclamoRepository;

    //Constructor
    public ReclamoService(IReclamoRepository reclamoRepository) {
        this.reclamoRepository = reclamoRepository;
    }

    //Métodos
    public void registrarReclamo(Reclamo reclamo) {
        reclamoRepository.agregar(reclamo);
    }

    public Reclamo buscarReclamo(String idReclamo) {
        Reclamo reclamo = reclamoRepository.buscarPorId(idReclamo);
        if (reclamo == null) {
            throw new RuntimeException("Reclamo no encontrado: " + idReclamo);
        }
        return reclamo;
    }

    public List<Reclamo> listarTodos() {
        return reclamoRepository.listarTodos();
    }

    public List<Reclamo> listarPendientes() {
        List<Reclamo> pendientes = new ArrayList<>();
        for (Reclamo r : reclamoRepository.listarTodos()) {
            if (r.getEstado().equals("PENDIENTE")) {
                pendientes.add(r);
            }
        }
        return pendientes;
    }

    public void resolverReclamo(String idReclamo) {
        Reclamo reclamo = buscarReclamo(idReclamo);
        reclamo.resolver();
        reclamoRepository.actualizar(reclamo);
    }

    public void cerrarReclamo(String idReclamo) {
        Reclamo reclamo = buscarReclamo(idReclamo);
        reclamo.cerrar();
        reclamoRepository.actualizar(reclamo);
    }
}