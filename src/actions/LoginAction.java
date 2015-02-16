package actions;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.codec.binary.Base64;

import clases.Usuario;
import clasesDAO.UsuarioDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690552787172887231L;
	private String email;
	private String password;
	private String perfil;

	private UsuarioDAO usuarioDAO;

	// public String execute() {
	// Map<String, Object> session = ActionContext.getContext().getSession();
	// String user = (String) session.get("user");
	// if (user == null) {
	// Usuario u = usuarioDAO.existeUsuario(getEmail(), getPassword());
	// if (u != null) {
	// if(u.isAdministrador())
	// session.put("perfil", "adminisrador");
	// else
	// session.put("perfil","viajero");
	// session.put("usuario", u.getNombre());
	// session.put("usrLogin", u);
	// return SUCCESS;
	// } else {
	// addFieldError("usuario", "Datos Incorrectos");
	// return INPUT;
	// }
	// } else {
	// return "conectado";
	// }
	// }

	public String autenticarUsuario() throws IOException {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Usuario user = (Usuario) session.get("usrLogin");
		if (user == null) {
			Usuario u = usuarioDAO.autenticateUser(getEmail(),getPassword());
			if (u != null) {
				if (u.isAdministrador())
					session.put("perfil", "administrador");
				else
					session.put("perfil", "pasajero");
				session.put("usrLogin", u);
				session.put("status", "autenticado");
//				byte[] imageData =  u.getFoto().getImagen();
//				String imageDataString = Base64.encodeBase64String(imageData);
				// convert file into array of bytes
				
				
				session.put("avatar", u.getFoto().getId());
				return "success";
			} else {
				addFieldError("usuario", "Datos Incorrectos");
				return "input";
			}
		} else {
			return "success";
		}
	}

	public String logout() throws Exception {
		// HttpSession session = ServletActionContext.getRequest().getSession();
		// session.removeAttribute("logined");
		// session.removeAttribute("context");
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove("status");
		session.remove("usrLogin");
		session.remove("perfil");
		session.remove("context");
		return "success";
	}
	
	public String showLogin(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Usuario user = (Usuario) session.get("usrLogin");
		if(user==null){
			return "success";
		}
		return "logged";
	}


	public void validate() {

		if (getEmail() == null || getEmail().isEmpty())
			addFieldError("identificacion",
					"Se requiere una identificación de usuario");
		if (getPassword() == null || getPassword().isEmpty())
			addFieldError("clave", "Se requiere una contraseña");
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
}
