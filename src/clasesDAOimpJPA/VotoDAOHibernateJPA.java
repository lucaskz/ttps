package clasesDAOimpJPA;

import clases.Recorrido;
import clases.Voto;
import clasesDAO.VotoDAO;

public class VotoDAOHibernateJPA extends GenericDAOHibernateJPA<Voto> implements VotoDAO {

	
	public RecorridoDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super(Recorrido.class);
	}
}
