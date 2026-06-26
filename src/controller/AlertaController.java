package controller;

import Model.entidades.Lote;
import Model.entidades.Stock;
import Model.servicios.AlertaAmbientalService;
import Model.servicios.AlertaDesabastecimientoService;
import Model.servicios.AlertaVencimientoService;
import java.util.List;

public class AlertaController {

    //Atributos
    private AlertaVencimientoService alertaVencimientoService;
    private AlertaDesabastecimientoService alertaDesabastecimientoService;
    private AlertaAmbientalService alertaAmbientalService;

    //Constructor
    public AlertaController(AlertaVencimientoService alertaVencimientoService,
                            AlertaDesabastecimientoService alertaDesabastecimientoService,
                            AlertaAmbientalService alertaAmbientalService) {
        this.alertaVencimientoService = alertaVencimientoService;
        this.alertaDesabastecimientoService = alertaDesabastecimientoService;
        this.alertaAmbientalService = alertaAmbientalService;
    }

    //Métodos
    public List<Lote> listarLotesProximosAVencer() {
        return alertaVencimientoService.listarLotesProximosAVencer();
    }

    public List<Lote> listarLotesVencidos() {
        return alertaVencimientoService.listarLotesVencidos();
    }

    public void verificarVencimientos() {
        alertaVencimientoService.verificarYAlertarVencimientos();
    }

    public List<Stock> listarStockCritico() {
        return alertaDesabastecimientoService.listarStockCritico();
    }

    public void verificarDesabastecimiento() {
        alertaDesabastecimientoService.verificarYAlertarDesabastecimiento();
    }

    public List<String> listarAlertasAmbientales() {
        return alertaAmbientalService.listarAlertas();
    }
}