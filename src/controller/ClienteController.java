package controller;

import Model.entidades.Cliente;
import Model.servicios.InventarioService;
import Model.repositorios.IClienteRepository;
import java.util.List;

public class ClienteController {

    //Atributos
    private IClienteRepository clienteRepository;

    //Constructor
    public ClienteController(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //Métodos
    public void registrarCliente(Cliente cliente) {
        clienteRepository.agregar(cliente);
        System.out.println("Cliente registrado correctamente.");
    }

    public Cliente buscarCliente(String idCliente) {
        Cliente cliente = clienteRepository.buscarPorId(idCliente);
        if (cliente == null) {
            throw new RuntimeException("Cliente no encontrado: " + idCliente);
        }
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.listarTodos();
    }

    public void actualizarCliente(Cliente cliente) {
        clienteRepository.actualizar(cliente);
        System.out.println("Cliente actualizado correctamente.");
    }

    public void eliminarCliente(String idCliente) {
        clienteRepository.eliminar(idCliente);
        System.out.println("Cliente eliminado correctamente.");
    }
}