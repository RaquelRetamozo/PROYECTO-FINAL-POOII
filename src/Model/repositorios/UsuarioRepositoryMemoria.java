package Model.repositorios;

import Model.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryMemoria implements IUsuarioRepository {

    //Atributos
    private List<Usuario> usuarios;

    //Constructor
    public UsuarioRepositoryMemoria() {
        this.usuarios = new ArrayList<>();
    }

    //Métodos
    @Override
    public void agregar(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public Usuario buscarPorId(String idUsuario) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario().equals(idUsuario)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Usuario buscarPorEmail(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarios;
    }

    @Override
    public void actualizar(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario().equals(usuario.getIdUsuario())) {
                usuarios.set(i, usuario);
                return;
            }
        }
    }

    @Override
    public void eliminar(String idUsuario) {
        usuarios.removeIf(u -> u.getIdUsuario().equals(idUsuario));
    }
}