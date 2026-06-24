package Model.patrones.factory;

import Model.entidades.Producto;
import Model.entidades.ProductoLiquido;
import Model.entidades.ProductoPolvo;
import java.time.LocalDate;

public class ProductoFactory {

    //Métodos
    public static Producto crear(String tipo, String idProducto, String nombre,
                                 LocalDate fechaFabricacion, LocalDate fechaVencimiento,
                                 double cantidad, String dosis, double param) {
        switch (tipo.toUpperCase()) {
            case "LIQUIDO":
                return new ProductoLiquido(idProducto, nombre, fechaFabricacion,
                        fechaVencimiento, cantidad, dosis, param, 0);
            case "POLVO":
                return new ProductoPolvo(idProducto, nombre, fechaFabricacion,
                        fechaVencimiento, cantidad, dosis, param, 0);
            default:
                throw new IllegalArgumentException("Tipo de producto no válido: " + tipo);
        }
    }
}