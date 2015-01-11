package actions;

import java.util.Map;

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

	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String user = (String) session.get("user");
		if (user == null) {
			Usuario u = usuarioDAO.existeUsuario(getEmail(), getPassword());
			if (u != null) {
				if(u.isAdministrador())
					session.put("perfil", "adminisrador");
				else
					session.put("perfil","viajero");
				session.put("usuario", u.getNombre());
				session.put("usrLogin", u);
				return SUCCESS;
			} else {
				addFieldError("usuario", "Datos Incorrectos");
				return INPUT;
			}
		} else {
			return "conectado";
		}
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
}
