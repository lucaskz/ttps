package actions;

import java.util.Date;
import java.util.List;
import java.util.Map;

import clases.Evento;
import clases.Mensaje;
import clases.Usuario;
import clasesDAO.MensajeDAO;
import clasesDAO.UsuarioDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdministradorMensajeAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4508481492140634096L;
	
	MensajeDAO mensajeDAO;
	
	UsuarioDAO usuarioDAO;
	
	private String email;
	private String mailText;
	
	private List<Mensaje> recibidos;
	
	public String redactarMensaje(){
		return "success";
	}
	
	public String enviarMensaje(){
		
		Usuario usuarioDestino =usuarioDAO.existeUsuario(getEmail());
		if (usuarioDestino != null){
			Map<String, Object> session = ActionContext.getContext().getSession();
			Usuario usuarioEnvio = (Usuario) session.get("usrLogin");
			Mensaje mensaje = new Mensaje();
			   //get current date time with Date()
			Date date = new Date();
			mensaje.setFecha(date);
			mensaje.setLeido(false);
			mensaje.setTexto(getMailText());
			usuarioDestino.getRecibidos().add(mensaje);
			usuarioEnvio.getEnviados().add(mensaje);			
		}
		else{
			addFieldError("usuario",
					"No existe el usuario destino para este mensaje");
			
		}
		
		return "success";
	}
	
	public String listarMensajes(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Usuario user = (Usuario) session.get("usrLogin");
		if(user==null){
			return "not_logged";
		}
		
		recibidos = user.getRecibidos();
		
		return "success";
		
	}
	
	public void validate() {

		if (getEmail() == null || getEmail().isEmpty())
			addFieldError("email",
					"Se requiere una dirección de correo destino");
		if (getMailText() == null || getMailText().isEmpty())
			addFieldError("texto", "Ingrese el texto del mensaje");
	}

	public MensajeDAO getMensajeDAO() {
		return mensajeDAO;
	}

	public void setMensajeDAO(MensajeDAO mensajeDAO) {
		this.mensajeDAO = mensajeDAO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMailText() {
		return mailText;
	}

	public void setMailText(String mailText) {
		this.mailText = mailText;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public List<Mensaje> getRecibidos() {
		return recibidos;
	}

	public void setRecibidos(List<Mensaje> recibidos) {
		this.recibidos = recibidos;
	}

}
