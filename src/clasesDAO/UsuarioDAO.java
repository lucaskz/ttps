package clasesDAO;

import clases.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public Usuario existeUsuario(String usuario, String password);
}
