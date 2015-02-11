package clasesDAO;

import java.io.File;

import clases.Foto;

public interface FotoDAO extends GenericDAO<Foto>{
	
	public Foto getFotoById(int id);
	
	public Foto getFotoByDes(String descripcion);



}
