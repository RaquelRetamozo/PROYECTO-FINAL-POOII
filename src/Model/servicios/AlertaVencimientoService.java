package Model.servicios;

import Model.entidades.Lote;
import Model.repositorios.ILoteRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlertaVencimientoService {

    //Atributos
    private ILoteRepository loteRepository;
    private int diasAnticipacion;

    //Constructor
    public AlertaVencimientoService(ILoteRepository loteRepository, int diasAnticipacion) {
        this.loteRepository = loteRepository;
        this.diasAnticipacion = diasAnticipacion;
    }

    //Métodos
    public List<Lote> listarLotesProximosAVencer() {
        List<Lote> proximos = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(diasAnticipacion);
        for (Lote l : loteRepository.listarTodos()) {
            LocalDate vencimiento = l.getProducto().getFechaVencimiento();
            if (!vencimiento.isBefore(hoy) && !vencimiento.isAfter(limite)) {
                proximos.add(l);
            }
        }
        return proximos;
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

    public void verificarYAlertarVencimientos() {
        List<Lote> proximos = listarLotesProximosAVencer();
        for (Lote l : proximos) {
            System.out.println("⚠ ALERTA VENCIMIENTO - Lote: " + l.getNumeroLote() +
                    " | Producto: " + l.getProducto().getNombre() +
                    " | Vence: " + l.getProducto().getFechaVencimiento());
        }
    }
}