package clasesDAOimpJPA;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import clases.Evento;
import clases.Recorrido;
import clases.Usuario;
import clasesDAO.RecorridoDAO;

public class RecorridoDAOHibernateJPA extends GenericDAOHibernateJPA<Recorrido> implements RecorridoDAO{
	
	public RecorridoDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super(Recorrido.class);
	}
	
	public Recorrido findRecorridoById(int id){

		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select e from Recorrido as e  where e.id=?");
			consulta.setParameter(1, id);
			return (Recorrido) consulta.getSingleResult();
		}

		catch (NoResultException e) {


			return null;
		}
		
	}
	

}
