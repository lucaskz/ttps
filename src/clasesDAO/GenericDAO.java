package clasesDAO;

import java.util.Collection;

public interface GenericDAO<T> {
	
	public Class<T> getPersistentClass();
	
	public void setPersistentClass(Class<T> persistentClass);
	
	public T alta (T entity);
	
	public T modificacion (T entity);
	
	public void eliminar(long idEntity);
	
	public T buscar(long idEntity);
	
	public Collection<T> recuperarTodos(); 
	
	
}
