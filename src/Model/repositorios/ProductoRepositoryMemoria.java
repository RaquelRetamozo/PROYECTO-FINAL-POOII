package Model.repositorios;
import Model.entidades.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryMemoria implements IProductoRepository {

    //Atributos
    private List<Producto> productos;

    //Constructor
    public ProductoRepositoryMemoria() {
        this.productos = new ArrayList<>();
    }

    //Métodos
    @Override
    public void agregar(Producto producto) {
        productos.add(producto);
    }

    @Override
    public Producto buscarPorId(String idProducto) {
        for (Producto p : productos) {
            if (p.getIdProducto().equals(idProducto)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Producto> listarTodos() {
        return productos;
    }

    @Override
    public void actualizar(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getIdProducto().equals(producto.getIdProducto())) {
                productos.set(i, producto);
                return;
            }
        }
    }

    @Override
    public void eliminar(String idProducto) {
        productos.removeIf(p -> p.getIdProducto().equals(idProducto));
    }
}
