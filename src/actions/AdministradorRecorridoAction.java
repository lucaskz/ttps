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

import util.CollectionPaginator;
import aspects.MailSendAspect;
import clases.Denuncia;
import clases.Estado;
import clases.Evento;
import clases.Mail;
import clases.Negativo;
import clases.Positivo;
import clases.Recorrido;
import clases.Solicitud;
import clases.Usuario;
import clases.Voto;
import clasesDAO.DenunciaDAO;
import clasesDAO.EventoDAO;
import clasesDAO.RecorridoDAO;
import clasesDAO.SolicitudDAO;
import clasesDAO.UsuarioDAO;
import clasesDAO.VotoDAO;

import com.google.gson.Gson;
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
	
	Collection<Solicitud> solicitudes;
	
	SolicitudDAO solicitudDAO;
	
	private String jsonString;

	private String rol;
	private String fecha;
	private String partida;
	private String regreso;
	private String desde;
	private String hasta;
	private String asientos;
	private String idRecorrido;
	
	private String[] js = {"recorrido"};

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
//			mailSendAspect.enviarMailDenuncia(denuncia);
			
			recorridoDAO.denunciar(recorrido,denuncia);

		}

		return "success";

	}

	public String listar() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}		
		if (!isLogged()) {
			return "not_logged";
		}
		// Muestra solo los recorridos q no son parte del usuario
		HttpServletRequest request = ServletActionContext.getRequest();


		return "success";
	}
	
	public String getRecorridosPaginados(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}		
		// Muestra solo los recorridos q no son parte del usuario
		HttpServletRequest request = ServletActionContext.getRequest();
		int paginas = 5;
		if(request.getParameter("paginas")!=null){
			paginas = Integer.parseInt(request.getParameter("paginas"));
		}
		int pagina = 1;
		if(request.getParameter("pagina")!=null){
			pagina = Integer.parseInt(request.getParameter("pagina"));
		}
		recorridos = recorridoDAO.recuperarRecorridos(user.getId());
		Gson gson = new Gson();
		CollectionPaginator<Collection<HashMap<String,String>>> paginador = new CollectionPaginator((List) recorridos);
		jsonString = gson.toJson(paginar(paginador, paginas ,pagina));
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
		request.getSession().setAttribute("accion", "listar");
		if (request.getParameter("recorrido") == null || request.getParameter("recorrido").isEmpty()) {
			addFieldError("recorrido", getText("mensaje.recorrido.parametroRecorrido"));
			return "success";
		}
		recorrido = recorridoDAO.findRecorridoCreadorParticipanteById(Integer.parseInt(request.getParameter("recorrido")),user.getId());
		if(recorrido==null){
			addFieldError("recorrido", getText("mensaje.recorrido.noEncontradoInvalido"));
			return "not_found";
		}
			
		if (recorrido.getCreador().getId() == user.getId()) {
			// Soy creador muestro el editor
			request.getSession().setAttribute("editarRecorrido", "true");
			return "edit_recorrido";
		}		
		return "success";
	}
	
	public String bajaRecorrido(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		if (request.getParameter("recorrido") == null || request.getParameter("recorrido").isEmpty()) {
			addFieldError("recorrido", getText("mensaje.recorrido.parametroRecorrido"));
			return "success";
		}
		
		recorrido = recorridoDAO.findRecorridoCreadorParticipanteById(Integer.parseInt(request.getParameter("recorrido")),user.getId());
		if(recorrido==null){
			addFieldError("recorrido", getText("mensaje.recorrido.noEncontradoInvalido"));
			return "not_found";
		}
		if (recorrido.getCreador().getId() == user.getId()) {
			// Soy creador muestro el editor
			recorrido.setEstado(false);
			recorridoDAO.modificacion(recorrido);
			return "success";
		}
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "misRecorridos");

		return "success";
	}
	
	public String modificar() throws ParseException{
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		if (request.getParameter("recorrido") == null || request.getParameter("recorrido").isEmpty()) {
			addFieldError("recorrido", getText("mensaje.recorrido.parametroRecorrido"));
			return "success";
		}
		
		recorrido = recorridoDAO.findRecorridoCreadorParticipanteById(Integer.parseInt(request.getParameter("recorrido")),user.getId());
		if(recorrido==null){
			addFieldError("recorrido", getText("mensaje.recorrido.noEncontradoInvalido"));
			return "not_found";
		}
		if (recorrido.getCreador().getId() == user.getId()) {
			// Soy creador muestro el editor
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
			if(request.getParameter("fecha")!=null)
				recorrido.setFecha(dateFormatter.parse(request.getParameter("fecha")));
			DateFormat timeFormatter = new SimpleDateFormat("HH:mm");
			recorrido.setDireccionDesde(request.getParameter("desde"));
			recorrido.setDireccionHasta(request.getParameter("hasta"));
			if(request.getParameter("partida")!=null && !request.getParameter("partida").equals("")){
				java.sql.Time timePartida = new java.sql.Time(timeFormatter.parse(request.getParameter("partida")).getTime());
				recorrido.setHoraPartida(timePartida);
			}
			if(request.getParameter("regreso")!=null && !request.getParameter("regreso").equals("")){
				java.sql.Time timeRegreso = new java.sql.Time(timeFormatter.parse(	request.getParameter("regreso")).getTime());
				recorrido.setHoraRegreso(timeRegreso);
			}
			request.getSession().setAttribute("editarRecorrido", "true");
			recorridoDAO.modificacion(recorrido);
			return "success";
		}
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "misRecorridos");

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

		misRecorridos = usuarioDAO.recorridosHabilitados(user.getId());
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
//		if(!votoDAO.puedeVotar(user.getId(),Long.valueOf(request.getParameter("recorrido"))))
//			return "input";		
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
	
	public String solicitudes(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		solicitudes = solicitudDAO.recuperarSolicitudes(user.getId());		
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "solicitudes");
		return "success";
	}
	
	public String solicitar(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getParameter("recorrido")!=null){
			solicitudDAO.solicitar(user,Long.valueOf(request.getParameter("recorrido")));
		}			
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "solicitudes");
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
	
	public String aceptarSolicitud(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getParameter("solicitud")!=null){
			Solicitud s = solicitudDAO.buscarSolicitud((long)Long.valueOf(request.getParameter("solicitud")));
			if(s!=null){
				s.setEstado(Estado.ACEPTADO);
				Recorrido r = s.getRecorrido();
				Usuario p = usuarioDAO.buscar(s.getSolicitante().getId());
				r.addPasajero(p);
				recorridoDAO.modificacion(r);
				solicitudDAO.modificacion(s);
			}
		}
		
		
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "solicitudes");

		return "success";
	}
	
	public String rechazarSolicitud(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getParameter("solicitud")!=null){
			Solicitud s = solicitudDAO.buscar((long)Long.parseLong(request.getParameter("solicitud")));
			if(s!=null){
				s.setEstado(Estado.RECHAZADO);
				solicitudDAO.modificacion(s);
			}
		}
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "solicitudes");

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
			addFieldError("rol", getText("mensaje.recorrido.parametroRol"));
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
				addFieldError("eventos", getText("mensaje.recorrido.evento"));
				return "input";
			}
			recorrido.setEvento(evento);
		}
		
		if(request.getParameter("polygon")!=null & !request.getParameter("polygon").equals("")){
			//LLegaron cordenadas seleccionadas del mapa , lo guardo para despues generar la imagen static!
			recorrido.setPolygon(request.getParameter("polygon"));
			recorrido.setStartA(request.getParameter("startA"));
			recorrido.setStartF(request.getParameter("startF"));
			recorrido.setEndA(request.getParameter("endA"));
			recorrido.setEndF(request.getParameter("endF"));
		}
		
		user.addRecorrido(recorrido);

		// recorridoDAO.modificacion(recorrido);
		usuarioDAO.modificacion(user);

		return "success";
	}
	
	public String filtradoVoto(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}
		if (!isLogged()) {
			return "not_logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		int paginas = 5;
		if(request.getParameter("paginas")!=null){
			paginas = Integer.parseInt(request.getParameter("paginas"));
		}
		
		recorridos = recorridoDAO.getRecorridoByVoto(user.getId(),paginas);
		Gson gson = new Gson();
		CollectionPaginator<Collection<HashMap<String,String>>> paginador = new CollectionPaginator((List) recorridos);
		jsonString = gson.toJson(paginar(paginador, paginas ,1));
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "listar");
		return "success";
	}

	public void validate() {
		if (getRol() == null || getRol().isEmpty())
			addFieldError("rol", getText("mensaje.recorrido.rol"));
		if (getFecha() == null || getFecha().isEmpty())
			addFieldError("fecha", getText("mensaje.recorrido.fecha"));
		if (getPartida() == null || getPartida().isEmpty())
			addFieldError("partida", getText("mensaje.recorrido.partida"));
		if (getRegreso() == null || getRegreso().isEmpty())
			addFieldError("regreso", getText("mensaje.recorrido.regreso"));
		if (getDesde() == null || getDesde().isEmpty())
			addFieldError("partida", getText("mensaje.recorrido.desde"));
		if (getHasta() == null || getHasta().isEmpty())
			addFieldError("hasta", getText("mensaje.recorrido.hasta"));
		if (getAsientos() == null || getAsientos().isEmpty())
			addFieldError("asientos", getText("mensaje.recorrido.asientos"));


	}

	public RecorridoDAO getRecorridoDAO() {
		return recorridoDAO;
	}

	public void setRecorridoDAO(RecorridoDAO recorridoDAO) {
		this.recorridoDAO = recorridoDAO;
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

	public Collection<HashMap<String, String>> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(Collection<HashMap<String, String>> recorridos) {
		this.recorridos = recorridos;
	}

	public VotoDAO getVotoDAO() {
		return votoDAO;
	}

	public void setVotoDAO(VotoDAO votoDAO) {
		this.votoDAO = votoDAO;
	}

	public void setOpcionEventos(List<HashMap<String, String>> opcionEventos) {
		this.opcionEventos = opcionEventos;
	}

	public Collection<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(Collection<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	public SolicitudDAO getSolicitudDAO() {
		return solicitudDAO;
	}

	public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public String[] getJs() {
		return js;
	}

	public void setJs(String[] js) {
		this.js = js;
	}


}
