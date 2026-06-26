package controller;

import Model.entidades.Usuario;
import Model.servicios.UsuarioService;
import java.util.List;

public class UsuarioController {

    //Atributos
    private UsuarioService usuarioService;

    //Constructor
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Métodos
    public void registrarUsuario(Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        System.out.println("Usuario registrado correctamente.");
    }

    public Usuario buscarUsuario(String idUsuario) {
        return usuarioService.buscarUsuario(idUsuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioService.actualizarUsuario(usuario);
        System.out.println("Usuario actualizado correctamente.");
    }

    public void eliminarUsuario(String idUsuario) {
        usuarioService.eliminarUsuario(idUsuario);
        System.out.println("Usuario eliminado correctamente.");
    }
}