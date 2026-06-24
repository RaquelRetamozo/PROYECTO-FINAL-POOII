package Model.servicios;

import Model.entidades.Producto;
import Model.excepciones.ProductoNoEncontradoException;
import Model.repositorios.IProductoRepository;
import java.util.List;

public class InventarioService {

    //Atributos
    private IProductoRepository productoRepository;

    //Constructor
    public InventarioService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //Métodos
    public void registrarProducto(Producto producto) {
        productoRepository.agregar(producto);
    }

    public Producto buscarProducto(String idProducto) {
        Producto producto = productoRepository.buscarPorId(idProducto);
        if (producto == null) {
            throw new ProductoNoEncontradoException(idProducto);
        }
        return producto;
    }

    public List<Producto> listarProductos() {
        return productoRepository.listarTodos();
    }

    public void actualizarProducto(Producto producto) {
        buscarProducto(producto.getIdProducto());
        productoRepository.actualizar(producto);
    }

    public void eliminarProducto(String idProducto) {
        buscarProducto(idProducto);
        productoRepository.eliminar(idProducto);
    }
}