package controller;

import Model.servicios.EstadisticaService;

public class EstadisticaController {

    //Atributos
    private EstadisticaService estadisticaService;

    //Constructor
    public EstadisticaController(EstadisticaService estadisticaService) {
        this.estadisticaService = estadisticaService;
    }

    //Métodos
    public int getTotalProductosEnStock() {
        return estadisticaService.getTotalProductosEnStock();
    }

    public double getMontoTotalDespachos() {
        return estadisticaService.getMontoTotalDespachos();
    }

    public int getTotalDespachosEntregados() {
        return estadisticaService.getTotalDespachosEntregados();
    }

    public int getTotalStockCritico() {
        return estadisticaService.getTotalStockCritico();
    }
}
