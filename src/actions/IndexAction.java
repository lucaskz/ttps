package actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends GenericAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2473355837502640607L;

	public String execute() {
		if (isLogged()) {
			updateUserData();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "index");
		request.getSession().setAttribute("accion", "index");
		return "success";
	}

}
