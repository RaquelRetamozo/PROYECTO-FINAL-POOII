package Model.excepciones;

public class UsuarioNoAutorizadoException extends CramerException {
    public UsuarioNoAutorizadoException(String idUsuario) {
        super("El usuario " + idUsuario + " no tiene permisos para esta acción.");
    }
}