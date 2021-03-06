package clasesDAO;

import java.util.List;

import clases.Recorrido;
import clases.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public Usuario existeUsuario(String usuario);

	public Usuario autenticateUser(String email,String password);

	public int getNoLeidos(int id);

	public List<Recorrido> recorridosHabilitados(int id);
}
