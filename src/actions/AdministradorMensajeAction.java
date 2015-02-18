package actions;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import clases.Mensaje;
import clases.Usuario;
import clasesDAO.MensajeDAO;

import com.opensymphony.xwork2.ActionContext;

public class AdministradorMensajeAction extends GenericAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4508481492140634096L;
	
	MensajeDAO mensajeDAO;
	
	
	private String email;
	private String mailText;
	
	private String inputStream;	
	
	private List<Mensaje> recibidos;
	
	public String redactar(){
		if (isLogged()) {
			updateUserData();
		}
		if(!isLogged()){
			return "not_logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "mensajes");
		request.getSession().setAttribute("accion", "redactar");
		return "success";
	}
	
	public String enviar(){
		
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

	
	public String recibidos(){
		
		
		if (isLogged()) {
			updateUserData();
		}
		if(!isLogged()){
			return "not_logged";
		}
		
		recibidos = user.getRecibidos();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "mensajes");
		request.getSession().setAttribute("accion", "recibidos");
		
		return "success";
		
	}
	
	public String enviados(){
		if (isLogged()) {
			updateUserData();
		}
		if(!isLogged()){
			return "not_logged";
		}
		
		recibidos = user.getEnviados();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "mensajes");
		request.getSession().setAttribute("accion", "enviados");
		
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


	public List<Mensaje> getRecibidos() {
		return recibidos;
	}

	public void setRecibidos(List<Mensaje> recibidos) {
		this.recibidos = recibidos;
	}
	
	  public String getInputStream() {
		    return inputStream;
		   }

	public void setInputStream(String inputStream) {
		this.inputStream = inputStream;
	}



}
