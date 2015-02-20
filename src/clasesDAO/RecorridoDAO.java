package clasesDAO;

import clases.Recorrido;

public interface RecorridoDAO extends GenericDAO<Recorrido>{

	public Recorrido findRecorridoById(int id);
}
