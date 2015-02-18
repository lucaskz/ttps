package actions;

import java.io.IOException;
import java.util.Map;

import clases.Usuario;
import clasesDAO.UsuarioDAO;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends GenericAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690552787172887231L;
	private String email;
	private String password;
	private String perfil;

	public String autenticarUsuario() throws IOException {
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (!isLogged()) {
			Usuario u = usuarioDAO.autenticateUser(getEmail(), getPassword());
			if (u != null) {
				if (u.isAdministrador())
					session.put("perfil", "administrador");
				else
					session.put("perfil", "pasajero");
				user = u;
				session.put("usrLogin", u);
				session.put("status", "autenticado");
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
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = null;
		session.remove("status");
		session.remove("usrLogin");
		session.remove("perfil");
		session.remove("context");
		session.remove("noLeidos");
		return "success";
	}

	public String showLogin() {
		if (!isLogged()) {
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

}
