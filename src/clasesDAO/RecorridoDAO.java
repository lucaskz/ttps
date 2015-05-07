package clasesDAO;

import java.util.Collection;
import java.util.HashMap;

import clases.Recorrido;

public interface RecorridoDAO extends GenericDAO<Recorrido>{

	public Recorrido findRecorridoById(int id);
	
	public Collection<HashMap<String,String>> recuperarRecorridos(int id);
	
	public boolean votar(int id,int recId);
}
