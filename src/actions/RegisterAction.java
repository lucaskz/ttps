package actions;

import clases.Pasajero;
import clases.Usuario;
import clasesDAO.UsuarioDAO;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */

	private UsuarioDAO usuarioDAO;

	private String email;
	private String password;

	private static final long serialVersionUID = -9153853278848404937L;
	
	

	public String execute() {
		Usuario u = usuarioDAO.existeUsuario(getEmail(), getPassword());
		if (u == null) {
			u = new Pasajero();
			u.setEmail(getEmail());
			u.setPassword(getPassword());
			usuarioDAO.alta(u);
			return SUCCESS;
		} else {
			addFieldError("email", "Dirección de correo en uso");
			return INPUT;
		}
	}

	public void validate(){
		if (getEmail() == null || getEmail().isEmpty())
			addFieldError("mail",
					"datos incorrectos");
		if (getPassword() == null || getPassword().isEmpty())
			addFieldError("mail", "datos incorrectos");
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
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
