package Model.servicios;

import Model.entidades.Despacho;
import Model.entidades.DetalleDespacho;
import Model.excepciones.DespachoInvalidoException;
import Model.repositorios.IDespachoRepository;
import java.util.List;

public class DespachoService {

    //Atributos
    private IDespachoRepository despachoRepository;

    //Constructor
    public DespachoService(IDespachoRepository despachoRepository) {
        this.despachoRepository = despachoRepository;
    }

    //Métodos
    public void registrarDespacho(Despacho despacho) {
        if (despacho.getDetalles().isEmpty()) {
            throw new DespachoInvalidoException(despacho.getIdDespacho());
        }
        despachoRepository.agregar(despacho);
    }

    public Despacho buscarDespacho(String idDespacho) {
        Despacho despacho = despachoRepository.buscarPorId(idDespacho);
        if (despacho == null) {
            throw new DespachoInvalidoException(idDespacho);
        }
        return despacho;
    }

    public List<Despacho> listarDespachos() {
        return despachoRepository.listarTodos();
    }

    public void actualizarEstado(String idDespacho, String nuevoEstado) {
        Despacho despacho = buscarDespacho(idDespacho);
        despacho.setEstado(nuevoEstado);
        despachoRepository.actualizar(despacho);
    }

    public void agregarDetalle(String idDespacho, DetalleDespacho detalle) {
        Despacho despacho = buscarDespacho(idDespacho);
        despacho.agregarDetalle(detalle);
        despachoRepository.actualizar(despacho);
    }

    public List<Despacho> listarPendientes() {
        List<Despacho> pendientes = new java.util.ArrayList<>();
        for (Despacho d : despachoRepository.listarTodos()) {
            if (d.getEstado().equals("PENDIENTE")) {
                pendientes.add(d);
            }
        }
        return pendientes;
    }
}