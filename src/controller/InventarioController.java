package controller;

import Model.entidades.Producto;
import Model.servicios.InventarioService;
import java.util.List;

public class InventarioController {

    //Atributos
    private InventarioService inventarioService;

    //Constructor
    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    //Métodos
    public void registrarProducto(Producto producto) {
        inventarioService.registrarProducto(producto);
        System.out.println("Producto registrado correctamente.");
    }

    public Producto buscarProducto(String idProducto) {
        return inventarioService.buscarProducto(idProducto);
    }

    public List<Producto> listarProductos() {
        return inventarioService.listarProductos();
    }

    public void actualizarProducto(Producto producto) {
        inventarioService.actualizarProducto(producto);
        System.out.println("Producto actualizado correctamente.");
    }

    public void eliminarProducto(String idProducto) {
        inventarioService.eliminarProducto(idProducto);
        System.out.println("Producto eliminado correctamente.");
    }
}