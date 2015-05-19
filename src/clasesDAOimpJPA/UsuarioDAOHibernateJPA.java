package clasesDAOimpJPA;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import clases.Recorrido;
import clases.Usuario;
import clasesDAO.UsuarioDAO;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO{

	public UsuarioDAOHibernateJPA(){
		super(Usuario.class);
	}
	
	
	@Deprecated
	public Usuario existeUsuario(String mail) {

		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select u from Usuario as u  where u.email=? and u.estado<> false");
			consulta.setParameter(1, mail);
			return (Usuario) consulta.getSingleResult();
		}

		catch (NoResultException e) {


			return null;
		}

	}

	@Override
	public Usuario autenticateUser(String email,String password) {
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select u from Usuario as u  where u.email=? and u.password=? and u.estado != false");
			consulta.setParameter(1, email);
			consulta.setParameter(2,password);
			return (Usuario) consulta.getSingleResult();
		}

		catch (NoResultException e) {


			return null;
		}
	}



	@Override
	public int getNoLeidos(int id) {
		int i = 0;
		try{
			Query consulta = this.getEm().createQuery("SELECT COUNT(m.leido) FROM Mensaje m where m.leido=0 AND m.receptor.id=?");
			consulta.setParameter(1,id);
			i = ((Long) consulta.getSingleResult()).intValue();
			return i;
		}
		catch (NoResultException e) {


			return 0;
		}
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Recorrido> recorridosHabilitados(int id) {
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select distinct r from Recorrido r where r.creador.id= :id and r.estado = true");
			consulta.setParameter("id", id);
			return  (List<Recorrido>) consulta.getResultList();
		}

		catch (NoResultException e) {


			return null;
		}
	}

}
