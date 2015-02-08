package actions;

import java.io.File;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import clases.Evento;
import clases.Foto;
import clasesDAO.EventoDAO;
import clasesDAO.FotoDAO;

import com.opensymphony.xwork2.ActionSupport;

	

public class AdministradorEventoAction extends ActionSupport{

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
    private Time hora;
    private List<Evento> eventos;
	
	
	


	private EventoDAO eventoDAO;
	
	private FotoDAO fotoDAO;
	
	public String listarEventos(){
		
		String forward = KEY_SUCCESS;
		
		eventos =  (List<Evento>)eventoDAO.recuperarTodos();

		return forward;
	}
	
	public String registrarEvento(){
		String forward = KEY_SUCCESS;
		
		Evento evento = new Evento();
		evento.setDireccion(getDireccion());
		evento.setFecha(getFecha());
		evento.setNombre(getNombre());
		evento.setCiudad(getCiudad());
		evento.setHora(getHora());
		Foto foto = new Foto();
		foto.setImagen(getFoto());
		foto.setDescripcion(getFotoFileName());

       
		evento.setFoto(foto);
		eventoDAO.alta(evento);
		return forward;
	}
	
	public String crearEvento(){
		String forward = KEY_SUCCESS;
		
		
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

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}





	
	
}
