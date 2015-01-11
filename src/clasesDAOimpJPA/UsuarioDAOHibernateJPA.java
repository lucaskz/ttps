package clasesDAOimpJPA;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import clases.Usuario;
import clasesDAO.UsuarioDAO;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO{

	public UsuarioDAOHibernateJPA(){
		super(Usuario.class);
	}
	
	public Usuario existeUsuario(String mail, String password) {

		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select u from Usuario as u  where u.mail=? and u.clave=?");
			consulta.setParameter(1, mail);
			consulta.setParameter(2, password);
			return (Usuario) consulta.getSingleResult();
		}

		catch (NoResultException e) {


			return null;
		}

	}

}
