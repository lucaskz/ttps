package actions;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import clases.Recorrido;
import clasesDAO.RecorridoDAO;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends GenericAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2473355837502640607L;
	
	private RecorridoDAO recorridoDAO;
	
	private Collection<Recorrido> recorridos;

	public String execute() {
		if (isLogged()) {
			updateUserData();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		recorridos  = recorridoDAO.recuperarRecorridosActivos();
		request.getSession().setAttribute("seccion", "index");
		request.getSession().setAttribute("accion", "index");
		return "success";
	}

	public RecorridoDAO getRecorridoDAO() {
		return recorridoDAO;
	}

	public void setRecorridoDAO(RecorridoDAO recorridoDAO) {
		this.recorridoDAO = recorridoDAO;
	}

	public Collection<Recorrido> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(Collection<Recorrido> recorridos) {
		this.recorridos = recorridos;
	}

}
