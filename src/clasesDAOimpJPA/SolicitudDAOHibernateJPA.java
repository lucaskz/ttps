package clasesDAOimpJPA;

import java.util.Collection;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import clases.Estado;
import clases.Evento;
import clases.Recorrido;
import clases.Solicitud;
import clases.Usuario;
import clasesDAO.RecorridoDAO;
import clasesDAO.SolicitudDAO;


public class SolicitudDAOHibernateJPA extends GenericDAOHibernateJPA<Solicitud> implements SolicitudDAO {
	@Autowired
	private RecorridoDAO recorridoDAO;

	public SolicitudDAOHibernateJPA(){
		super(Solicitud.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Solicitud> recuperarSolicitudes(int id) {
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select s from Recorrido r join r.solicitudes s where r.creador.id = :id and r.estado=true" );
			consulta.setParameter("id", id);
			return  consulta.getResultList();
		}

		catch (NoResultException e) {


			return null;
		}
	}

	/**
	 * recibe como parametro un id de Recorrido y un ID de usuario , da de alta una solicitud en caso de ser valida( que no exista previmente)
	 */
	@Override
	public Usuario solicitar(Usuario u, Long recId) {
		// TODO Auto-generated method stub
		Recorrido r = recorridoDAO.buscar((long)recId);
		if(r!=null && puedeSolicitar(u.getId(),r.getId())){
			Solicitud s = new Solicitud();
			s.setEstado(Estado.PENDIENTE);			
			s.setRecorrido(r);
			s.setSolicitante(u);
			this.alta(s);
			return r.getCreador();
		}else{
			return null;
		}
	}

	private boolean puedeSolicitar(int userId, int recorridoId) {
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select s from Solicitud s where s.recorrido.id = :recorridoId and s.solicitante.id = :userId");
			consulta.setParameter("userId", userId);
			consulta.setParameter("recorridoId", recorridoId);
			@SuppressWarnings("unchecked")
			Collection<Solicitud> s = consulta.getResultList();
			return  (s.isEmpty()?true:false);
		}
		catch (NoResultException e) {


			return true;
		}
	}

	public RecorridoDAO getRecorridoDAO() {
		return recorridoDAO;
	}

	public void setRecorridoDAO(RecorridoDAO recorridoDAO) {
		this.recorridoDAO = recorridoDAO;
	}

	@Override
	public Solicitud buscarSolicitud(long id) {
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select s from Solicitud s where s.id = :id and s.estado = 'PENDIENTE' " );
			consulta.setParameter("id", id);
			return  (Solicitud) consulta.getSingleResult();
		}

		catch (NoResultException e) {


			return null;
		}
	}

}
