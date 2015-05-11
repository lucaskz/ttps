package clasesDAOimpJPA;

import clases.Voto;
import clasesDAO.VotoDAO;

public class VotoDAOHibernateJPA extends GenericDAOHibernateJPA<Voto> implements VotoDAO {

	
	public VotoDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super(Voto.class);
	}

	
	@Override
	public boolean puedeVotar(int id, Long valueOf) {
		boolean puede = false;
		
		return puede;
	}
}
