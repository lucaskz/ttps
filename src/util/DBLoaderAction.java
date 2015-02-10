package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import clases.Administrador;
import clases.Foto;
import clases.Pasajero;
import clases.Telefono;
import clasesDAO.EventoDAO;
import clasesDAO.FotoDAO;
import clasesDAO.UsuarioDAO;
import clasesDAOimpJPA.FotoDAOHibernateJPA;
import clasesDAOimpJPA.UsuarioDAOHibernateJPA;

public class DBLoaderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 493989382615950942L;
	
	private UsuarioDAO usuarioDAO;
	private EventoDAO eventoDAO;
	private FotoDAO fotoDAO;

	public String loadDB() {


		// Fotos DEFAULT

		Foto avatarDefault = new Foto();
		avatarDefault.setDescripcion("avatar_default");
		File foto_arch1 = new File("avatar_default.png");
		avatarDefault.setImagen(foto_arch1);
		fotoDAO.alta(avatarDefault);

		Foto eventoDefault = new Foto();
		eventoDefault.setDescripcion("evento_default");
		File foto_arch2 = new File("evento_default.png");
		avatarDefault.setImagen(foto_arch2);
		fotoDAO.alta(eventoDefault);

		// AGREGAR USUARIOS

		Pasajero traveler1 = new Pasajero();
		traveler1.setEmail("lkaseta@mail.com");
		traveler1.setNombre("Mariano");
		traveler1.setPassword("1234");
		traveler1.setApellido("Sanchez");
		Telefono tel1 = new Telefono();
		tel1.setCodArea(221);
		tel1.setNumero(4724548);
		tel1.setMovil(true);
		List<Telefono> telefonos = new ArrayList<Telefono>();
		telefonos.add(tel1);
		traveler1.setTelefonos(telefonos);
		traveler1.setFoto(fotoDAO.getFotoByDes("avatar_default"));

		Pasajero traveler2 = new Pasajero();
		traveler2.setEmail("li.kaseta@gmail.com");
		traveler2.setNombre("Lucas");
		traveler2.setPassword("1234");
		traveler2.setApellido("Kaseta");
		Telefono tel2 = new Telefono();
		tel2.setCodArea(221);
		tel2.setNumero(4724548);
		tel2.setMovil(true);
		List<Telefono> telefonos2 = new ArrayList<Telefono>();
		telefonos.add(tel2);
		traveler1.setTelefonos(telefonos2);
		traveler2.setFoto(fotoDAO.getFotoByDes("avatar_default"));

		Administrador ad = new Administrador();
		ad.setEmail("admin");
		ad.setPassword("admin");

		usuarioDAO.alta(traveler1);
		usuarioDAO.alta(traveler2);
		usuarioDAO.alta(ad);
		
		return "success";
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public EventoDAO getEventoDAO() {
		return eventoDAO;
	}

	public void setEventoDAO(EventoDAO eventoDAO) {
		this.eventoDAO = eventoDAO;
	}

	public FotoDAO getFotoDAO() {
		return fotoDAO;
	}

	public void setFotoDAO(FotoDAO fotoDAO) {
		this.fotoDAO = fotoDAO;
	}

}
