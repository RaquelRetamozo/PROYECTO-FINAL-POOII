package Model.repositorios;

import Model.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryMemoria implements IClienteRepository {

    //Atributos
    private List<Cliente> clientes;

    //Constructor
    public ClienteRepositoryMemoria() {
        this.clientes = new ArrayList<>();
    }

    //Métodos
    @Override
    public void agregar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarPorId(String idCliente) {
        for (Cliente c : clientes) {
            if (c.getIdCliente().equals(idCliente)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> listarTodos() {
        return clientes;
    }

    @Override
    public void actualizar(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getIdCliente().equals(cliente.getIdCliente())) {
                clientes.set(i, cliente);
                return;
            }
        }
    }

    @Override
    public void eliminar(String idCliente) {
        clientes.removeIf(c -> c.getIdCliente().equals(idCliente));
    }
}