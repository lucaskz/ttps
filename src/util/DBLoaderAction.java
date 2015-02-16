package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.hibernate.Hibernate;













import org.hibernate.Hibernate;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import clases.Administrador;
import clases.Evento;
import clases.Foto;
import clases.Mensaje;
import clases.Pasajero;
import clases.Telefono;
import clases.Usuario;
import clasesDAO.EventoDAO;
import clasesDAO.FotoDAO;
import clasesDAO.MensajeDAO;
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
	private MensajeDAO mensajeDAO;

	public String loadDB() throws ParseException {


		// Fotos DEFAULT

		Foto avatarDefault = new Foto();
		avatarDefault.setDescripcion("avatar_default");
		File foto_arch1 = new File("C:\\avatar_default.png");

		byte[] imageData = new byte[(int) foto_arch1.length()];
		try {
		     FileInputStream fileInputStream = new FileInputStream(foto_arch1);
		     //convert file into array of bytes
		     fileInputStream.read(imageData);
		     fileInputStream.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		avatarDefault.setImagen(imageData);

		Foto eventoDefault = new Foto();
		eventoDefault.setDescripcion("evento_default");
		File foto_arch2 = new File("C:\\evento_default.png");
		byte[] imageData2 = new byte[(int) foto_arch2.length()];
		try {
		     FileInputStream fileInputStream = new FileInputStream(foto_arch2);
		     //convert file into array of bytes
		     fileInputStream.read(imageData2);
		     fileInputStream.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		eventoDefault.setImagen(imageData2);
		
		fotoDAO.alta(eventoDefault);
		fotoDAO.alta(avatarDefault);

		// AGREGAR USUARIOS
		
//		Foto avatar_default = fotoDAO.getFotoByDes("avatar_default");

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
		ad.setNombre("Administrador");
		ad.setFoto(fotoDAO.getFotoByDes("avatar_default"));

		usuarioDAO.modificacion(traveler1);
		usuarioDAO.modificacion(traveler2);
		usuarioDAO.modificacion(ad);
		
		
		// Creacion de eventos test
		
		SimpleDateFormat formatter_date = new SimpleDateFormat("dd/MM/yyyy");

		
		Evento evento = new Evento();
		evento.setDireccion("15 esq 41");
		evento.setFecha( formatter_date.parse("07/06/2015"));
		evento.setNombre("Evento 1 !");
		evento.setCiudad("La Plata");

		DateFormat formatter = new SimpleDateFormat("HH:mm");
		java.sql.Time timeValue = new java.sql.Time(formatter.parse("12:30").getTime());
		evento.setHora(timeValue);
		evento.setFoto(fotoDAO.getFotoByDes("evento_default"));
		
		eventoDAO.modificacion(evento);
		
		Evento evento2 = new Evento();
		evento2.setDireccion("7 y 50");
		evento2.setFecha( formatter_date.parse("05/01/2016"));
		evento2.setNombre("Evento 2 !");
		evento2.setCiudad("City Bell");
		timeValue= new java.sql.Time(formatter.parse("15:30").getTime());
		evento2.setHora(timeValue);


		java.sql.Time timeValue2 = new java.sql.Time(formatter.parse("15:30").getTime());
		evento.setHora(timeValue2);
		evento.setFoto(fotoDAO.getFotoByDes("evento_default"));
		
		eventoDAO.modificacion(evento2);
		
		
		//Mensajes

		Mensaje mensaje = new Mensaje();
		   //get current date time with Date()
		Date date = new Date();
		mensaje.setFecha(date);
		mensaje.setLeido(false);
		mensaje.setTexto("MEnsaje de prueba!");
		Usuario usuarioDestino = usuarioDAO.existeUsuario("li.kaseta@gmail.com");
		Usuario usuarioEnvio = usuarioDAO.existeUsuario("lkaseta@mail.com");
		mensaje.setCreador(usuarioEnvio);
		mensaje.setReceptor(usuarioDestino);
		usuarioDestino.addRecibidos(mensaje);
		usuarioEnvio.addEnviado(mensaje);
		mensajeDAO.alta(mensaje);
		usuarioDAO.modificacion(usuarioEnvio);
		usuarioDAO.modificacion(usuarioDestino);
		
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

	public MensajeDAO getMensajeDAO() {
		return mensajeDAO;
	}

	public void setMensajeDAO(MensajeDAO mensajeDAO) {
		this.mensajeDAO = mensajeDAO;
	}

}
