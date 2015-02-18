package actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class AdministradorAction extends GenericAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -523568368195481222L;
	
	
	
	
	public String usuarios(){
		if (ActionContext.getContext().getSession().get("perfil")!="administrador"){
			return "restricted";
		}
		if (isLogged()) {
			updateUserData();
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "administracion");
		request.getSession().setAttribute("accion", "usuarios");
		
		return "success";
	}
	
	public String denuncias(){
	
		if (ActionContext.getContext().getSession().get("perfil")!="administrador"){
			return "restricted";
		}
		if (isLogged()) {
			updateUserData();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "administracion");
		request.getSession().setAttribute("accion", "denuncias");
		
		return "success";
	}
	


}
