package actions;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import clases.Evento;
import clases.Foto;
import clasesDAO.EventoDAO;
import clasesDAO.FotoDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

	

public class AdministradorEventoAction extends GenericAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private final static String KEY_RECORRIDO = "recorrido";
	private final static String KEY_SUCCESS = "success";
	
	private String nombre;
	private Date fecha;
	private String direccion;
	private String ciudad;
	private File foto;
	private String fotoContentType;
    private String fotoFileName;
    private String hora;
    private List<Evento> eventos;
    private Evento evento;
	
	
	


	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	private EventoDAO eventoDAO;
	
	private FotoDAO fotoDAO;
	
	public String listarEventos(){
		
		String forward = KEY_SUCCESS;
		if (isLogged()) {
			updateUserData();
		}
		eventos =  (List<Evento>)eventoDAO.recuperarEventosHabilitados();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "eventos");
		request.getSession().setAttribute("accion", "listar");

		return forward;
	}
	
	public String verEvento() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "eventos");
		request.getSession().setAttribute("accion", "verEvento");
		if (request.getParameter("idEvento") == null || request.getParameter("idEvento").isEmpty()) {
			addFieldError("evento", "Falta el parámetro del evento");
			return "success";
		}
		evento = eventoDAO.findEventoById(Integer
				.parseInt(request.getParameter("idEvento")));
		
		return "success";
	}
	
	public String registrarEvento() throws ParseException{
		String forward = KEY_SUCCESS;
		
		if (ActionContext.getContext().getSession().get("perfil")!="administrador"){
			return "restricted";
		}
		if (isLogged()) {
			updateUserData();
		}
		
		Evento evento = new Evento();
		evento.setDireccion(getDireccion());
		evento.setFecha(getFecha());
		evento.setNombre(getNombre());
		evento.setCiudad(getCiudad());

		DateFormat formatter = new SimpleDateFormat("HH:mm");
		java.sql.Time timeValue = new java.sql.Time(formatter.parse(getHora()).getTime());
		evento.setHora(timeValue);
		Foto foto = new Foto();
		foto.setDescripcion(getFotoFileName());
		byte[] imageData = new byte[(int) getFoto().length()];
		try {
		     FileInputStream fileInputStream = new FileInputStream(getFoto());
		     //convert file into array of bytes
		     fileInputStream.read(imageData);
		     fileInputStream.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		foto.setImagen(imageData);
		

       
		evento.setFoto(foto);
		eventoDAO.alta(evento);
		return forward;
	}
	
	public String crearEvento(){
		String forward = KEY_SUCCESS;
		if (ActionContext.getContext().getSession().get("perfil")!="administrador"){
			return "restricted";
		}
		if (isLogged()) {
			updateUserData();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "eventos");
		request.getSession().setAttribute("accion", "crear");
		
		return forward;
	}

	public EventoDAO getEventoDAO() {
		return eventoDAO;
	}

	public void setEventoDAO(EventoDAO eventoDAO) {
		this.eventoDAO = eventoDAO;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public String getFotoContentType() {
		return fotoContentType;
	}

	public void setFotoContentType(String fotoContentType) {
		this.fotoContentType = fotoContentType;
	}

	public String getFotoFileName() {
		return fotoFileName;
	}

	public void setFotoFileName(String fotoFileName) {
		this.fotoFileName = fotoFileName;
	}

	public FotoDAO getFotoDAO() {
		return fotoDAO;
	}

	public void setFotoDAO(FotoDAO fotoDAO) {
		this.fotoDAO = fotoDAO;
	}


	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}









	
	
}
