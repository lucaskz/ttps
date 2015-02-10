package clasesDAOimpJPA;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import clases.Foto;
import clasesDAO.FotoDAO;

public class FotoDAOHibernateJPA  extends GenericDAOHibernateJPA<Foto> implements FotoDAO{

	public Foto getFotoByDes(String descripcion){
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select f from Foto as f  where f.descripcion=?");
			consulta.setParameter(1, descripcion);
			return (Foto) consulta.getSingleResult();
		}

		catch (NoResultException e) {


			return null;
		}

	}
	
}
