package actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import clases.Evento;
import clasesDAO.EventoDAO;

import com.opensymphony.xwork2.ActionContext;

public class AdministradorAction extends GenericAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -523568368195481222L;
	
	private Collection<Evento> eventos ;
	private Evento evento;
	private EventoDAO eventoDAO;
	
	public String usuarios(){
		if (ActionContext.getContext().getSession().get("perfil")!="administrador"){
			return "restricted";
		}
		if (isLogged()) {
			updateUserData();
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "administracion");
		request.getSession().setAttribute("accion", "usuarios");
		
		return "success";
	}
	
	public String denuncias(){
	
		if (ActionContext.getContext().getSession().get("perfil")!="administrador"){
			return "restricted";
		}
		if (isLogged()) {
			updateUserData();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "administracion");
		request.getSession().setAttribute("accion", "denuncias");
		
		return "success";
	}
	
	public String eventos(){		
		if (ActionContext.getContext().getSession().get("perfil")!="administrador"){
			return "restricted";
		}
		if (isLogged()) {
			updateUserData();
		}
		eventos = eventoDAO.recuperarTodos();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "administracion");
		request.getSession().setAttribute("accion", "eventos");
		
		return "success";
	}
	
	public String evento() throws ParseException{
		if (ActionContext.getContext().getSession().get("perfil")!="administrador"){
			return "restricted";
		}
		if (isLogged()) {
			updateUserData();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getParameter("id")!=null){
			evento = eventoDAO.buscar(Long.valueOf(request.getParameter("id")));			
		}		
		if(evento == null)
			return "input";		
		if(evento.getFecha()!=null){
			//normalizar la fecha
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			evento.setFecha(dateFormatter.parse(dateFormatter.format(evento.getFecha()))); 
		}
		request.getSession().setAttribute("seccion", "administracion");
		request.getSession().setAttribute("accion", "eventos");
		
		return "success";
	}
	
	public String modificarEvento() throws ParseException{
		if (ActionContext.getContext().getSession().get("perfil")!="administrador"){
			return "restricted";
		}
		if (isLogged()) {
			updateUserData();
		}		
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getParameter("eventoId")== null )
			return "input";
		evento = eventoDAO.buscar(Long.valueOf(request.getParameter("eventoId")));
		if(evento==null)
			return "input";
		evento.setNombre(request.getParameter("nombre"));
		evento.setDireccion(request.getParameter("ciudad"));
		evento.setDireccion(request.getParameter("direccion"));
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		java.sql.Time timeValue = new java.sql.Time(formatter.parse((request.getParameter("hora"))).getTime());
		evento.setHora(timeValue);
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		if(request.getParameter("fecha")!=null)
			evento.setFecha(dateFormatter.parse(request.getParameter("fecha")));
		eventoDAO.modificacion(evento);		
		
		request.getSession().setAttribute("seccion", "administracion");
		request.getSession().setAttribute("accion", "eventos");
		
		return "success";
	}

	public Collection<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(Collection<Evento> eventos) {
		this.eventos = eventos;
	}

	public EventoDAO getEventoDAO() {
		return eventoDAO;
	}

	public void setEventoDAO(EventoDAO eventoDAO) {
		this.eventoDAO = eventoDAO;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	


}
