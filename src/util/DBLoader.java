//package util;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//
//import clases.Administrador;
//import clases.Foto;
//import clases.Pasajero;
//import clases.Telefono;
////import clasesDAOimpJPA.EventoDAOHibernateJPA;
//import clasesDAOimpJPA.FotoDAOHibernateJPA;
//import clasesDAOimpJPA.UsuarioDAOHibernateJPA;
//
//public class DBLoader {
//	public static void main(String[] args) {
//
//		// DECLARAR DAOS
//
//		UsuarioDAOHibernateJPA userDao = new UsuarioDAOHibernateJPA();
////		EventoDAOHibernateJPA eventDao = new EventoDAOHibernateJPA();
//		FotoDAOHibernateJPA fotoDAO = new FotoDAOHibernateJPA();
//
//		// Fotos DEFAULT
//
//		Foto avatarDefault = new Foto();
//		avatarDefault.setDescripcion("avatar_default");
//		File foto_arch1 = new File("avatar_default.png");
//		avatarDefault.setImagen(foto_arch1);
//		fotoDAO.alta(avatarDefault);
//
//		Foto eventoDefault = new Foto();
//		eventoDefault.setDescripcion("evento_default");
//		File foto_arch2 = new File("evento_default.png");
//		avatarDefault.setImagen(foto_arch2);
//		fotoDAO.alta(eventoDefault);
//
//		// AGREGAR USUARIOS
//		
//		Foto default_avatar = fotoDAO.getFotoByDes("avatar_default");
////		Foto default_event_avatar = fotoDAO.getFotoByDes("avatar_default");
//
//		Pasajero traveler1 = new Pasajero();
//		traveler1.setEmail("lkaseta@mail.com");
//		traveler1.setNombre("Mariano");
//		traveler1.setPassword("1234");
//		traveler1.setApellido("Sanchez");
//		Telefono tel1 = new Telefono();
//		tel1.setCodArea(221);
//		tel1.setNumero(4724548);
//		tel1.setMovil(true);
//		List<Telefono> telefonos = new ArrayList<Telefono>();
//		telefonos.add(tel1);
//		traveler1.setTelefonos(telefonos);
//		traveler1.setFoto(default_avatar);
//
//		Pasajero traveler2 = new Pasajero();
//		traveler2.setEmail("li.kaseta@gmail.com");
//		traveler2.setNombre("Lucas");
//		traveler2.setPassword("1234");
//		traveler2.setApellido("Kaseta");
//		Telefono tel2 = new Telefono();
//		tel2.setCodArea(221);
//		tel2.setNumero(4724548);
//		tel2.setMovil(true);
//		List<Telefono> telefonos2 = new ArrayList<Telefono>();
//		telefonos.add(tel2);
//		traveler1.setTelefonos(telefonos2);
//	
//		traveler2.setFoto(default_avatar);
//
//		Administrador ad = new Administrador();
//		ad.setEmail("admin");
//		ad.setPassword("admin");
//
//		userDao.alta(traveler1);
//		userDao.alta(traveler2);
//		userDao.alta(ad);
//
////		// Agregar evento
////		Evento event = new Evento();
////		event.setDate(new Date());
////		event.setDescription("Este es un event");
////		event.setLocation("La Plata");
////		event.setName("EVENTO");
////		event = eventDao.update(event);
////
////		ad.addEvent(event);
////
////		// Agregar un evento a un viaje
////		trav.addEvent(event);
////		travelDao.update(trav);
//	}
//}
