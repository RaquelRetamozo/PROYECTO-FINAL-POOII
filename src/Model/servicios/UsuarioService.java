package Model.servicios;

import Model.entidades.Usuario;
import Model.excepciones.UsuarioNoAutorizadoException;
import Model.repositorios.IUsuarioRepository;
import java.util.List;

public class UsuarioService {

    //Atributos
    private IUsuarioRepository usuarioRepository;

    //Constructor
    public UsuarioService(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Métodos
    public void registrarUsuario(Usuario usuario) {
        usuarioRepository.agregar(usuario);
    }

    public Usuario buscarUsuario(String idUsuario) {
        Usuario usuario = usuarioRepository.buscarPorId(idUsuario);
        if (usuario == null) {
            throw new UsuarioNoAutorizadoException(idUsuario);
        }
        return usuario;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarTodos();
    }

    public void actualizarUsuario(Usuario usuario) {
        buscarUsuario(usuario.getIdUsuario());
        usuarioRepository.actualizar(usuario);
    }

    public void eliminarUsuario(String idUsuario) {
        buscarUsuario(idUsuario);
        usuarioRepository.eliminar(idUsuario);
    }
}
