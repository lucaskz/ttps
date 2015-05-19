package clasesDAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import clases.Denuncia;
import clases.Recorrido;

public interface RecorridoDAO extends GenericDAO<Recorrido>{

	public Recorrido findRecorridoById(int id);
	
	public List<HashMap<String,String>> recuperarRecorridos(int id);
	
	public boolean votar(int id,int recId);

	public boolean denunciar(Recorrido recorrido, Denuncia denuncia);

	public Collection<HashMap<String, String>> getRecorridoByVoto(int userId, int paginas);

	public Recorrido findRecorridoCreadorParticipanteById(int parseInt, int i);

	public Collection<Recorrido> recuperarRecorridosActivos();
}
