package actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import clases.Recorrido;
import clases.Usuario;
import clasesDAO.RecorridoDAO;
import clasesDAO.UsuarioDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdministradorRecorridoAction extends GenericAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	RecorridoDAO recorridoDAO;

	List<Recorrido> recorridos;

	private String rol;
	private String fecha;
	private String partida;
	private String regreso;
	private String desde;
	private String hasta;
	private String asientos;

	public String listar() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (isLogged()) {
			updateUserData();
		}

		recorridos = (List<Recorrido>) recorridoDAO.recuperarTodos();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "listar");

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

		recorridos = user.getRecorridos();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "recorridos");
		request.getSession().setAttribute("accion", "misRecorridos");

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

		Recorrido recorrido = new Recorrido();
		recorrido.setAsientos(Integer.parseInt(getAsientos()));
		switch (getRol()) {
		case "conductor":
			recorrido.addConductor(user);
			break;
		case "pasajero":
			recorrido.addPasajero(user);
			;
			break;
		case "ambos":
			recorrido.addConductorPasajero(user);
			break;
		default:
			addFieldError("rol", "El rol ingresado es incorrecto");
			return "input";
		}
		recorrido.setCreador(user);
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
		recorrido.setFecha(dateFormatter.parse(getFecha()));
		DateFormat timeFormatter = new SimpleDateFormat("HH:mm");
		recorrido.setDireccionDesde(getDesde());
		recorrido.setDireccionHasta(getHasta());
		java.sql.Time timePartida = new java.sql.Time(timeFormatter.parse(
				getPartida()).getTime());
		recorrido.setHoraPartida(timePartida);
		java.sql.Time timeRegreso = new java.sql.Time(timeFormatter.parse(
				getRegreso()).getTime());
		recorrido.setHoraRegreso(timeRegreso);
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

}
