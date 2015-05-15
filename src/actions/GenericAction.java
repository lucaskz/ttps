package actions;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import self.comun.Constantes;
import self.comun.manager.PolizaManager;
import self.cotiza.CertificadoFlota;
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
	
	/**
	 * Recupera los input (radio) de la paginación
	 * 
	 * @param certificadoId
	 */
	protected String getInputPaginador(int items,int selected){
		String input = "" ;
		for (int i = 1; i <= 5; i++) {
			//Evalua si muestro o no muestro los botones de paginacion
			//Si la cantidad de items es menor a la primer pagina,no muestro ningun boton
			//Si la cantidad de elementos de la siguiente pagina a la primera no es suficiente directamente no muestro ningun botón
			if(items >= (i*5)&& (i>1 || (i+1)*5 <= items  )){
				input += "<input type=\"radio\" name=\"cantPaginas\" ";
				if( (i*5) == selected)
					input += "checked=\"checked\"";
			    input += "onclick=\"javascript: cambiar_cant_pagina();\" value="+(i*5)+">"+i*5;
			}
		}
		
		return input;
		
	}
	
	protected HashMap<String,Object> paginar(CollectionPaginator<T> paginador,int elementos, int cantPaginas){
		HashMap<String,Object> dataPaginada = new HashMap<String,Object>();
		dataPaginada.put("siguiente",paginador.getNextPage());
		dataPaginada.put("anterior", paginador.getPreviousPage());
		dataPaginada.put("primeraVentana", paginador.getMinPageRange());
		//Ultima pagina	
		dataPaginada.put("ultimaVentana", paginador.getMaxPageRange());			
		//Paginas disponibles		
		dataPaginada.put("ultima", (paginador.getMaxPages()<1) ? 1 : paginador.getMaxPages() );
		//En que pagina estoy actualmente
		dataPaginada.put("paginaActual", paginador.getPage());
		dataPaginada.put("elementos", elementos);
		//Devuelve los inputs que determinan la cantidad de elementos por pagina
		dataPaginada.put("input",getInputPaginador(elementos,cantPaginas));
		dataPaginada.put("data",paginador.getListForPage());
		return dataPaginada;
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
