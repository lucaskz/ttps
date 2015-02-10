package clasesDAO;

import clases.Foto;

public interface FotoDAO extends GenericDAO<Foto>{
	
	public Foto getFotoByDes(String descripcion);

}
