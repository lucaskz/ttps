package clasesDAOimpJPA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import clases.Evento;
import clases.Recorrido;
import clases.Usuario;
import clasesDAO.RecorridoDAO;

public class RecorridoDAOHibernateJPA extends GenericDAOHibernateJPA<Recorrido> implements RecorridoDAO{
	
	public RecorridoDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super(Recorrido.class);
	}
	
	public Recorrido findRecorridoById(int id){

		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select e from Recorrido as e  where e.id=?");
			consulta.setParameter(1, id);
			return (Recorrido) consulta.getSingleResult();
		}

		catch (NoResultException e) {


			return null;
		}
		
	}

	/**
	 * Recibe la id del usuario como parametro. Retorna una lista de recorridos indicando en cada uno si puede calificarlo junto con la informacion del recorrido
	 */
	public Collection<HashMap<String,String>> recuperarRecorridos(int id) {
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select r.direccionDesde , r.direccionHasta ,r.horaPartida ,r.horaRegreso ,r.asientos, r.evento.fecha, case when ( :id in (select pa.id from Recorrido reco join reco.pasajeros pa were r.id==reco.id ) or :id in (select pa.id from Recorrido reco join reco.conductores pa were reco.id== r.id ) )  then true else false end ,r.id   "
							+ "from Recorrido r where r.creador.id <> :id");
			
			consulta.setParameter("id", id);
			Collection<Object[]> resultados = consulta.getResultList();
			ArrayList<HashMap<String,String>> recorridos = new ArrayList<HashMap<String,String>>();
			for (Object[] objects : resultados) {
				HashMap<String,String> reco = new HashMap<String,String>();
				reco.put("id",String.valueOf(objects[7]));
				reco.put("direccionDesde",String.valueOf(objects[0]));
				reco.put("direccionHasta", String.valueOf(objects[1]));
				reco.put("horaPartida", String.valueOf(objects[2]));
				reco.put("horaRegreso",String.valueOf(objects[3]));
				reco.put("asientos",String.valueOf(objects[4]));
				reco.put("fecha",String.valueOf(objects[5]));
				// revisar si es String true o boolean true...
				if( (new Date()).after((Date) objects[5]) && String.valueOf(objects[6]).equals("true")  ){
					// Significa que el recorrido ya paso y ademas participé del mismo, es decir,puedo calificarlo..
					reco.put("calificar", "true");
				}else{
					reco.put("calificar", "false");
				}
				recorridos.add(reco);
			}
			return recorridos;
		}catch (NoResultException e) {


			return null;
		}
		
	}
	
	public boolean votar(int id,int recId){
		return false;
		
	}
	

}
