package clasesDAO;

import javax.persistence.*;
public class EMF {
	
	private static final EntityManagerFactory emfInstance = Persistence.createEntityManagerFactory("unidadPersistente");
	
	public static EntityManagerFactory getEMF(){
		return emfInstance ;
	}

}