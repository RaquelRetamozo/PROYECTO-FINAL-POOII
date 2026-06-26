package controller;

import Model.entidades.Usuario;
import Model.servicios.AutenticacionService;

public class AutenticacionController {

    //Atributos
    private AutenticacionService autenticacionService;

    //Constructor
    public AutenticacionController(AutenticacionService autenticacionService) {
        this.autenticacionService = autenticacionService;
    }

    //Métodos
    public Usuario iniciarSesion(String email, String password) {
        Usuario usuario = autenticacionService.iniciarSesion(email, password);
        System.out.println("Bienvenido: " + usuario.getNombreCompleto());
        return usuario;
    }

    public void cerrarSesion() {
        autenticacionService.cerrarSesion();
        System.out.println("Sesión cerrada correctamente.");
    }

    public boolean haySesionActiva() {
        return autenticacionService.haySesionActiva();
    }

    public Usuario getUsuarioActivo() {
        return autenticacionService.getUsuarioActivo();
    }

    public boolean tieneRol(String rol) {
        return autenticacionService.tieneRol(rol);
    }
}