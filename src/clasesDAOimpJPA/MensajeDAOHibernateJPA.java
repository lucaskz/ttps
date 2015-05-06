package clasesDAOimpJPA;

import clases.Mensaje;
import clases.Recorrido;
import clasesDAO.MensajeDAO;

public class MensajeDAOHibernateJPA extends GenericDAOHibernateJPA<Mensaje> implements MensajeDAO {
	public MensajeDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super(Mensaje.class);
	}
}
