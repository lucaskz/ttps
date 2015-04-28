package clasesDAO;

import java.util.HashMap;
import java.util.List;

import clases.Evento;

public interface EventoDAO extends GenericDAO<Evento> {
	
	public Evento findEventoById(int id);

	public List<HashMap<String, String>> recuperarEventos();

}
