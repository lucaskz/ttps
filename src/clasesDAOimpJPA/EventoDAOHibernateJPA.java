package clasesDAOimpJPA;

import clases.Evento;
import clases.Usuario;
import clasesDAO.EventoDAO;

public class EventoDAOHibernateJPA extends GenericDAOHibernateJPA<Evento> implements EventoDAO {
	
	public EventoDAOHibernateJPA(){
		super(Evento.class);
	}

}
