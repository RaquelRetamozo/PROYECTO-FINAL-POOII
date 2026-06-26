package controller;

import Model.entidades.Stock;
import Model.servicios.StockService;
import java.util.List;

public class StockController {

    //Atributos
    private StockService stockService;

    //Constructor
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    //Métodos
    public void registrarStock(Stock stock) {
        stockService.registrarStock(stock);
        System.out.println("Stock registrado correctamente.");
    }

    public Stock buscarStock(String idStock) {
        return stockService.buscarStock(idStock);
    }

    public List<Stock> listarStocks() {
        return stockService.listarStocks();
    }

    public void reducirStock(String idStock, int cantidad) {
        stockService.reducirStock(idStock, cantidad);
        System.out.println("Stock reducido correctamente.");
    }

    public void aumentarStock(String idStock, int cantidad) {
        stockService.aumentarStock(idStock, cantidad);
        System.out.println("Stock aumentado correctamente.");
    }

    public List<Stock> listarBajoStock() {
        return stockService.listarBajoStock();
    }
}