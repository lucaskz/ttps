package clasesDAO;

import clases.Voto;

public interface VotoDAO extends GenericDAO<Voto> {

	boolean puedeVotar(int id, Long valueOf);

}
