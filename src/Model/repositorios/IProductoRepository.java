package Model.repositorios;

import Model.entidades.Producto;

import java.util.List;

public interface IProductoRepository {
    void agregar(Producto producto);
    Producto buscarPorId(String idProducto);
    List<Producto> listarTodos();
    void actualizar(Producto producto);
    void eliminar(String idProducto);
}