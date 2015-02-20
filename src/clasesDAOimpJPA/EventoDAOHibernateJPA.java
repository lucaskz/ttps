package clasesDAOimpJPA;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import clases.Evento;
import clasesDAO.EventoDAO;

public class EventoDAOHibernateJPA extends GenericDAOHibernateJPA<Evento> implements EventoDAO {
	
	public EventoDAOHibernateJPA(){
		super(Evento.class);
	}
	
	public Evento findEventoById(int id){

		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select e from Evento as e  where e.id=?");
			consulta.setParameter(1, id);
			return (Evento) consulta.getSingleResult();
		}

		catch (NoResultException e) {


			return null;
		}
		
	}

}
