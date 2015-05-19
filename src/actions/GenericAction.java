package actions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import util.CollectionPaginator;
import clases.Usuario;
import clasesDAO.UsuarioDAO;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.I18nInterceptor;

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
	
	public String idioma(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String language = request.getParameter("locale").substring(0, 2);
		String country = request.getParameter("locale").substring(3, 5);
		Locale locale = new Locale(language, country);
		ActionContext.getContext().setLocale(locale) ;
		session.put(I18nInterceptor.DEFAULT_SESSION_ATTRIBUTE, locale);
		return "success";
		
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
	
	/**
	 * Recupera los input (radio) de la paginación
	 * 
	 * @param certificadoId
	 */
	protected <T> HashMap<String,Object> getInputPaginador(CollectionPaginator<T> paginador){
		HashMap<String,Object> input = new HashMap<String,Object>();
		input.put("siguiente",paginador.getNextPage());
		input.put("anterior", paginador.getPreviousPage());
		if( paginador.getPage() == 1)
			input.put("primera",  true);			
		//Paginas disponibles		
		if(paginador.getMaxPages() == paginador.getPage() )
			input.put("ultima", true );
		input.put("paginas", paginador.getMaxPages());
		return input;
		
	}
	
	protected <T> HashMap<String,Object> paginar(CollectionPaginator<T> paginador,int elementos,int pagina){
		paginador.setPage(pagina);
		HashMap<String,Object> dataPaginada = new HashMap<String,Object>();
		//En que pagina estoy actualmente
		dataPaginada.put("paginaActual", paginador.getPage());
		dataPaginada.put("elementos", elementos);
		//Devuelve los inputs que determinan la cantidad de elementos por pagina
		dataPaginada.put("input",getInputPaginador(paginador));
		dataPaginada.put("data",paginador.getListForPage());
		return dataPaginada;
	}
//	
//	protected <T> HashMap<String,Object> paginar(CollectionPaginator<T> paginador,int elementos, int cantPaginas){
//		HashMap<String,Object> dataPaginada = new HashMap<String,Object>();
//		dataPaginada.put("siguiente",paginador.getNextPage());
//		dataPaginada.put("anterior", paginador.getPreviousPage());
//		dataPaginada.put("primeraVentana", paginador.getMinPageRange());
//		//Ultima pagina	
//		dataPaginada.put("ultimaVentana", paginador.getMaxPageRange());			
//		//Paginas disponibles		
//		dataPaginada.put("ultima", (paginador.getMaxPages()<1) ? 1 : paginador.getMaxPages() );
//		//En que pagina estoy actualmente
//		dataPaginada.put("paginaActual", paginador.getPage());
//		dataPaginada.put("elementos", elementos);
//		//Devuelve los inputs que determinan la cantidad de elementos por pagina
//		dataPaginada.put("input",getInputPaginador(elementos,cantPaginas));
//		dataPaginada.put("data",paginador.getListForPage());
//		return dataPaginada;
//	}

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
