package Model.repositorios;

import Model.entidades.Usuario;
import java.util.List;

public interface IUsuarioRepository {
    void agregar(Usuario usuario);
    Usuario buscarPorId(String idUsuario);
    Usuario buscarPorEmail(String email);
    List<Usuario> listarTodos();
    void actualizar(Usuario usuario);
    void eliminar(String idUsuario);
}