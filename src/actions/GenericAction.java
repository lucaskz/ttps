package actions;

import java.util.Map;

import clases.Usuario;
import clasesDAO.UsuarioDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GenericAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5830932188412047422L;
	
	protected Usuario user;
	
	UsuarioDAO usuarioDAO;
	
		
	protected boolean isLogged(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		user = (Usuario) session.get("usrLogin");
		if (user == null) {
			return false;
		}
		return true;
	}
	
	/*
	 * Actualiza la información de sesión,mensajes no leidos,etc.
	 */
	protected void updateUserData(){		
		if(isLogged()){
			Map<String, Object> session = ActionContext.getContext().getSession();
			// Obtiene los mensajes no leidos
			session.put("noLeidos", usuarioDAO.getNoLeidos(user.getId()));
		}
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
