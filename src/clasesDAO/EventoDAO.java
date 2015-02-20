package clasesDAO;

import clases.Evento;

public interface EventoDAO extends GenericDAO<Evento> {
	
	public Evento findEventoById(int id);

}
