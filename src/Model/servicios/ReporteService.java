package Model.servicios;

import Model.entidades.*;
import Model.excepciones.ReporteVacioException;
import Model.repositorios.*;
import java.util.List;

public class ReporteService {

    //Atributos
    private IStockRepository stockRepository;
    private IDespachoRepository despachoRepository;
    private INoConformidadRepository noConformidadRepository;
    private IReclamoRepository reclamoRepository;
    private IMovimientoRepository movimientoRepository;

    //Constructor
    public ReporteService(IStockRepository stockRepository,
                          IDespachoRepository despachoRepository,
                          INoConformidadRepository noConformidadRepository,
                          IReclamoRepository reclamoRepository,
                          IMovimientoRepository movimientoRepository) {
        this.stockRepository = stockRepository;
        this.despachoRepository = despachoRepository;
        this.noConformidadRepository = noConformidadRepository;
        this.reclamoRepository = reclamoRepository;
        this.movimientoRepository = movimientoRepository;
    }

    //Métodos
    public ReporteInventario generarReporteInventario(String generadoPor) {
        List<Stock> stocks = stockRepository.listarTodos();
        if (stocks.isEmpty()) {
            throw new ReporteVacioException("INVENTARIO");
        }
        ReporteInventario reporte = new ReporteInventario("RI-001",
                "Reporte de Inventario", "", generadoPor);
        for (Stock s : stocks) {
            reporte.agregarStock(s);
        }
        return reporte;
    }

    public ReporteDespachos generarReporteDespachos(String generadoPor) {
        List<Despacho> despachos = despachoRepository.listarTodos();
        if (despachos.isEmpty()) {
            throw new ReporteVacioException("DESPACHOS");
        }
        ReporteDespachos reporte = new ReporteDespachos("RD-001",
                "Reporte de Despachos", "", generadoPor);
        for (Despacho d : despachos) {
            reporte.agregarDespacho(d);
        }
        return reporte;
    }

    public ReporteCalidad generarReporteCalidad(String generadoPor) {
        ReporteCalidad reporte = new ReporteCalidad("RC-001",
                "Reporte de Calidad", "", generadoPor);
        for (NoConformidad nc : noConformidadRepository.listarTodos()) {
            reporte.agregarNoConformidad(nc);
        }
        for (Reclamo r : reclamoRepository.listarTodos()) {
            reporte.agregarReclamo(r);
        }
        return reporte;
    }
}