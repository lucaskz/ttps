package clasesDAOimpJPA;


import javax.persistence.NoResultException;
import javax.persistence.Query;




import clases.Foto;
import clasesDAO.FotoDAO;

public class FotoDAOHibernateJPA  extends GenericDAOHibernateJPA<Foto> implements FotoDAO{
	
	public FotoDAOHibernateJPA(){
		super(Foto.class);
	}

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
	public Foto getFotoById(int id) {
		try {
			Query consulta = this.getEm().createQuery(
					"select f from Foto as f  where f.id=?");
			consulta.setParameter(1, id);
			return (Foto) consulta.getSingleResult();
		}

		catch (NoResultException e) {

			return null;
		}

	}

	
	
	
}
