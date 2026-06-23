package Model.repositorios;

import Model.entidades.Cliente;
import java.util.List;

public interface IClienteRepository {
    void agregar(Cliente cliente);
    Cliente buscarPorId(String idCliente);
    List<Cliente> listarTodos();
    void actualizar(Cliente cliente);
    void eliminar(String idCliente);
}