package actions;

import java.util.Collection;

import clases.Evento;
import clasesDAO.EventoDAO;

import com.opensymphony.xwork2.ActionSupport;

	

public class AdministradorEventoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static String KEY_RECORRIDO = "recorrido";
	private final static String KEY_SUCCESS = "success";
	
	private EventoDAO eventoDAO;
	
	public String listarEventos(){
		String forward = KEY_SUCCESS;
		Collection<Evento> eventos = eventoDAO.recuperarTodos();
		return forward;
	}
	
	public String crearEvento(){
		String forward = KEY_SUCCESS;
		
		
		return forward;
	}
	
	
}
