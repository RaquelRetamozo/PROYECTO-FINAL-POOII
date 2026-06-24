package Model.servicios;

import Model.entidades.Usuario;
import Model.excepciones.UsuarioNoAutorizadoException;
import Model.repositorios.IUsuarioRepository;

public class AutenticacionService {

    //Atributos
    private IUsuarioRepository usuarioRepository;
    private Usuario usuarioActivo;

    //Constructor
    public AutenticacionService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioActivo = null;
    }

    //Métodos
    public Usuario iniciarSesion(String email, String password) {
        Usuario usuario = usuarioRepository.buscarPorEmail(email);
        if (usuario == null || !usuario.getPassword().equals(password)) {
            throw new UsuarioNoAutorizadoException(email);
        }
        this.usuarioActivo = usuario;
        return usuario;
    }

    public void cerrarSesion() {
        this.usuarioActivo = null;
    }

    public boolean haySesionActiva() {
        return usuarioActivo != null;
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }

    public boolean tieneRol(String rol) {
        if (usuarioActivo == null) return false;
        return usuarioActivo.getRol().equals(rol);
    }
}
