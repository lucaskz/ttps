package clasesDAOimpJPA;

import clases.Recorrido;
import clases.Usuario;
import clasesDAO.RecorridoDAO;

public class RecorridoDAOHibernateJPA extends GenericDAOHibernateJPA<Recorrido> implements RecorridoDAO{
	
	public RecorridoDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super(Recorrido.class);
	}
	
	

}
