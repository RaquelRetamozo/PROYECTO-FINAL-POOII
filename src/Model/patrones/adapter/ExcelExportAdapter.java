package Model.patrones.adapter;

import Model.entidades.Reporte;
import Model.patrones.strategy.ExportacionExcel;
import Model.patrones.strategy.IEstrategiaExportacion;

public class ExcelExportAdapter {

    //Atributos
    private IEstrategiaExportacion estrategia;

    //Constructor
    public ExcelExportAdapter() {
        this.estrategia = new ExportacionExcel();
    }

    //Métodos
    public void exportar(Reporte reporte) {
        estrategia.exportar(reporte);
    }

    //Getters
    public IEstrategiaExportacion getEstrategia() { return estrategia; }

    //Setters
    public void setEstrategia(IEstrategiaExportacion estrategia) { this.estrategia = estrategia; }
}