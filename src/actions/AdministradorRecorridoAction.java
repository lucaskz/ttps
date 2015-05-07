package actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import aspects.MailSendAspect;
import clases.Denuncia;
import clases.Evento;
import clases.Mail;
import clases.Positivo;
import clases.Recorrido;
import clases.Usuario;
import clases.Voto;
import clasesDAO.DenunciaDAO;
import clasesDAO.EventoDAO;
import clasesDAO.RecorridoDAO;
import clasesDAO.UsuarioDAO;
import clasesDAO.VotoDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdministradorRecorridoAction extends GenericAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	RecorridoDAO recorridoDAO;

	Collection<HashMap<String,String>> recorridos;

	List<Recorrido> misRecorridos;

	List<Evento> eventos;

	EventoDAO eventoDAO;

	Recorrido recorrido;

	DenunciaDAO denunciaDAO;
	
	VotoDAO votoDAO;

	MailSendAspect mailSendAspect;

	private String rol;
	private String fecha;
	private String partida;
	private String regreso;
	private String desde;
	private String hasta;
	private String asientos;
	private String idRecorrido;

	private List<HashMap<String, String>> opcionEventos;

	public String denunciar() throws Throwable {
		isLogged();
		HttpServletRequest request = ServletActionContext.getRequest();;
		recorrido = recorridoDAO.findRecorridoById(Integer
				.parseInt(request.getParameter("idRecorrido")));
		if (recorrido != null) {
			Denuncia denuncia = new Denuncia();

			denuncia.setCreador(user);
			denuncia.setDenunciado(recorrido.getCreador());
			denuncia.setTexto("Test de denuncia");
			denuncia.setRecorrido(recorrido);
			mailSendAspect.enviarMailDenuncia(denuncia);
			recorrido.addDenuncia(denuncia);
			recorridoDAO.modificacion(recorrido);

		}

		return "success";

	}

	public String listar() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		recorridos =  recorridoDAO.recuperarRecorridos();
		// Muestra solo los recorridos q no son parte del usuario
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "listar");

		return "success";
	}

	public String recorrido() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "recorrido");
		if (getIdRecorrido() == null || getIdRecorrido().isEmpty()) {
			addFieldError("recorrido", "Falta el parámetro del recorrido");
			return "success";
		}
		recorrido = recorridoDAO.findRecorridoById(Integer
				.parseInt(getIdRecorrido()));
		if (user.getRecorridos().contains(recorrido)) {
			request.getSession().setAttribute("editarRecorrido", "true");
		}
		return "success";
	}

	public String misRecorridos() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}

		misRecorridos = user.getRecorridos();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "misRecorridos");

		return "success";
	}
	
	public String upVote(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}		
		HttpServletRequest request = ServletActionContext.getRequest();
		Positivo v = new Positivo();
		v.setVotante(user);
		recorrido = recorridoDAO.buscar(Long.valueOf(request.getParameter("recorrido")));
		if(recorrido!=null)
			v.setRecorrido(recorrido);
		else
			return "input";		
		votoDAO.alta(v);		
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "registrar");
		return "success";
	}
	
	public String downVote(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}		
		HttpServletRequest request = ServletActionContext.getRequest();
		if(!votoDAO.puedeVotar(user.getId(),Long.valueOf(request.getParameter("recorrido"))))
			return "input";		
		Negativo v = new Negativo();
		v.setVotante(user);
		recorrido = recorridoDAO.buscar(Long.valueOf(request.getParameter("recorrido")));
		if(recorrido!=null)
			v.setRecorrido(recorrido);
		else
			return "input";		
		votoDAO.alta(v);		
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "registrar");
		return "success";
	}


	public String registrar() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}

		opcionEventos = (List<HashMap<String,String>>) eventoDAO.recuperarEventos();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "registrar");

		return "success";
	}

	public String alta() throws ParseException {
		// validaciones
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		Recorrido recorrido = new Recorrido();
		recorrido.setAsientos(Integer.parseInt(request.getParameter("asientos")));
		switch (request.getParameter("rol")) {
		case "conductor":
			recorrido.addConductor(user);
			break;
		case "pasajero":
			recorrido.addPasajero(user);
			break;
		case "ambos":
			recorrido.addConductorPasajero(user);
			break;
		default:
			addFieldError("rol", "El rol ingresado es incorrecto");
			return "input";
		}
		recorrido.setCreador(user);
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		if(request.getParameter("fecha")!=null)
			recorrido.setFecha(dateFormatter.parse(request.getParameter("fecha")));
		DateFormat timeFormatter = new SimpleDateFormat("HH:mm");
		recorrido.setDireccionDesde(request.getParameter("desde"));
		recorrido.setDireccionHasta(request.getParameter("hasta"));
		java.sql.Time timePartida = new java.sql.Time(timeFormatter.parse(
				request.getParameter("partida")).getTime());
		recorrido.setHoraPartida(timePartida);
		java.sql.Time timeRegreso = new java.sql.Time(timeFormatter.parse(
				request.getParameter("regreso")).getTime());
		recorrido.setHoraRegreso(timeRegreso);
		// Evento evento =
		// eventoDAO.buscar(Integer.parseInt(getEventoRecorrido()));
		
		if(Integer.parseInt(request.getParameter("eventoSeleccionado"))!= 0 ){
			Evento evento = eventoDAO.findEventoById(Integer.parseInt(request.getParameter("eventoSeleccionado")));
			if (evento == null) {
				addFieldError("eventos", "El evento seleccionado no existe");
				return "input";
			}
			recorrido.setEvento(evento);
		}
		
		user.addRecorrido(recorrido);

		// recorridoDAO.modificacion(recorrido);
		usuarioDAO.modificacion(user);

		return "success";
	}

	public void validate() {
		if (getRol() == null || getRol().isEmpty())
			addFieldError("rol", "Ingresa tu ubicacíon en el recorrido");
		if (getFecha() == null || getFecha().isEmpty())
			addFieldError("fecha", "Ingresa una fecha para el recorrido");
		if (getPartida() == null || getPartida().isEmpty())
			addFieldError("partida", "Ingresa una hora de partida");
		if (getRegreso() == null || getRegreso().isEmpty())
			addFieldError("regreso", "Ingresa una hora de regreso");
		if (getDesde() == null || getDesde().isEmpty())
			addFieldError("partida",
					"Ingresa una dirección de partida del recorrido");
		if (getHasta() == null || getHasta().isEmpty())
			addFieldError("hasta",
					"Ingresa una dirección destino del recorrido");
		if (getAsientos() == null || getAsientos().isEmpty())
			addFieldError("asientos",
					"Ingresa un número de asientos disponibles para el recorrido");


	}

	public RecorridoDAO getRecorridoDAO() {
		return recorridoDAO;
	}

	public void setRecorridoDAO(RecorridoDAO recorridoDAO) {
		this.recorridoDAO = recorridoDAO;
	}

	public List<Recorrido> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(List<Recorrido> recorridos) {
		this.recorridos = recorridos;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public String getRegreso() {
		return regreso;
	}

	public void setRegreso(String regreso) {
		this.regreso = regreso;
	}

	public MailSendAspect getMailSendAspect() {
		return mailSendAspect;
	}

	public void setMailSendAspect(MailSendAspect mailSendAspect) {
		this.mailSendAspect = mailSendAspect;
	}

	public String getDesde() {
		return desde;
	}

	public void setDesde(String desde) {
		this.desde = desde;
	}

	public String getHasta() {
		return hasta;
	}

	public void setHasta(String hasta) {
		this.hasta = hasta;
	}

	public String getAsientos() {
		return asientos;
	}

	public void setAsientos(String asientos) {
		this.asientos = asientos;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public EventoDAO getEventoDAO() {
		return eventoDAO;
	}

	public void setEventoDAO(EventoDAO eventoDAO) {
		this.eventoDAO = eventoDAO;
	}

	public List<Recorrido> getMisRecorridos() {
		return misRecorridos;
	}

	public void setMisRecorridos(List<Recorrido> misRecorridos) {
		this.misRecorridos = misRecorridos;
	}

	public Recorrido getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}

	public String getIdRecorrido() {
		return idRecorrido;
	}

	public void setIdRecorrido(String idRecorrido) {
		this.idRecorrido = idRecorrido;
	}

	public DenunciaDAO getDenunciaDAO() {
		return denunciaDAO;
	}

	public void setDenunciaDAO(DenunciaDAO denunciaDAO) {
		this.denunciaDAO = denunciaDAO;
	}

	public List<HashMap<String, String>> getOpcionEventos() {
		return opcionEventos;
	}

	public void setOpcionEventos(List<HashMap<String, String>> opcionEventos) {
		this.opcionEventos = opcionEventos;
	}


}
