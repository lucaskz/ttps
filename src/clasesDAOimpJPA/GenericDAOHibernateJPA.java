package clasesDAOimpJPA;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import clasesDAO.GenericDAO;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	
	protected Class <T> persistentClass;

	@PersistenceContext
	private EntityManager em;
	

	
	public  GenericDAOHibernateJPA(){
		super();
	}
	
	public  GenericDAOHibernateJPA(Class <T> persistentClass){
		this.persistentClass = persistentClass;
	}
	


	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public T alta(T entity) {
		this.getEm().persist(entity);
		return entity;
	}

	public T modificacion(T entity) {
		this.getEm().merge(entity);
		return entity;

	}

	public void eliminar(long idEntity) {
		
		this.getEm().remove(this.buscar(idEntity));
	}
	

	public T buscar (long idEntity) {

		return this.getEm().find(this.getPersistentClass(), (int) idEntity);
	}

	@Override
	public List<T> recuperarTodos() {
    Query consulta=this.getEm().createQuery(" from "+ getPersistentClass().getSimpleName());
	List<T>resultado=consulta.getResultList();
	return resultado;
		
		
	}

	

}