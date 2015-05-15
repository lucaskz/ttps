package clasesDAOimpJPA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

	@Override
	public List<HashMap<String, String>> recuperarEventos() {
		// TODO Auto-generated method stub
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select e.id,e.nombre from Evento e where e.estado = true");
			@SuppressWarnings("unchecked")
			List<Object[]> resultado =  consulta.getResultList();
			List<HashMap<String,String>> eventos = new ArrayList<HashMap<String,String>>();
			HashMap<String,String> byDefault = new HashMap<String,String>();
			//Corrección para entrega 8, sin eventos asociados.
			byDefault.put("id","0");
			byDefault.put("nombre","Sin Evento Asociado" );
			eventos.add(byDefault);
			for (Object[] objects : resultado) {
				HashMap<String,String> e = new HashMap<String,String>();
				e.put("id", String.valueOf(objects[0]));
				e.put("nombre", String.valueOf(objects[1]));
				eventos.add(e);
			}			
			return eventos;
		}
		catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> recuperarEventosHabilitados() {
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select e from Evento as e  where e.estado=true");
			return (List<Evento>) consulta.getResultList();
		}

		catch (NoResultException e) {


			return null;
		}
	}

}
