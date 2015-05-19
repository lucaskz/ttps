package clasesDAOimpJPA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import clases.Denuncia;
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
							"select e from Recorrido as e  where e.id=? and e.estado=true");
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
	public List<HashMap<String,String>> recuperarRecorridos(int id) {
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select r.direccionDesde , r.direccionHasta ,r.horaPartida ,r.horaRegreso ,r.asientos, eve.fecha, r.id,"
							+ " CASE WHEN (  :id in (select pa.id from Recorrido reco left join reco.pasajeros pa where r.id=reco.id)   OR  :id in (select pa.id from Recorrido reco left join reco.conductores pa where reco.id = r.id )   )  THEN true ELSE false END, "
							+ " CASE WHEN ( :id  in (select v.votante.id from Voto v where v.recorrido.id = r.id)  ) THEN true ELSE false END, "
							+ " CASE WHEN ( :id in (select d.creador.id from Denuncia d where d.recorrido.id = r.id ) ) THEN true ELSE false END,"
							+ " CASE WHEN (:id in (select s.solicitante.id from Solicitud s where s.recorrido.id = r.id ) ) THEN true ELSE false END,r.polygon,r.startA,r.startF,r.endA,r.endF from Recorrido r left OUTER  join r.evento eve where r.creador.id != :id and r.estado = true    ");
			/**
			 * Notas para saber que viene de este query
			 * 0 - direccion DESDE
			 * 1 - direccion HAstA
			 * 2 - hora PARTIDA
			 * 3 - hora REGRESO
			 * 4 - asientos disponibles
			 * 5 - fecha del evento ( si existe ) 
			 * 6 - id del recorrido en cuestion
			 * 7 - Pertenezco al recorrido // Junto con la fecha de hoy y la del recorrido -> puedo calificar el recorrido
			 * 8 - Si ya califique este recorrido anteriormente
			 * 9 - Saber si ya denuncie este recorrido anteriormente
			 * 10 - Saber si existe solicitud pendiente para este recorrido
			 * 11 - polygon
			 * 12 - startA
			 * 13 - startF
			 * 14 - endA
			 * 15 - endF
			 */
							
			consulta.setParameter("id", id);
			Collection<Object[]> resultados = consulta.getResultList();
			ArrayList<HashMap<String, String>> recorridos = generarRecorridos(resultados);
			return recorridos;
		}catch (NoResultException e) {


			return null;
		}
		
	}

	/**
	 * @param resultados
	 * @return
	 */
	private ArrayList<HashMap<String, String>> generarRecorridos(
			Collection<Object[]> resultados) {
		ArrayList<HashMap<String,String>> recorridos = new ArrayList<HashMap<String,String>>();
		for (Object[] objects : resultados) {
			HashMap<String,String> reco = new HashMap<String,String>();
			reco.put("id",String.valueOf(objects[6]));
			reco.put("direccionDesde",String.valueOf(objects[0]));
			reco.put("direccionHasta", String.valueOf(objects[1]));
			reco.put("horaPartida", String.valueOf(objects[2]));
			reco.put("horaRegreso",String.valueOf(objects[3]));
			reco.put("asientos",String.valueOf(objects[4]));
			reco.put("fecha",String.valueOf(objects[5]));
			// revisar si es String true o boolean true...
			// Significa que el recorrido ya paso y ademas participé del mismo, es decir,puedo calificarlo..
			if( objects[5]!=null  && (new Date()).after((Date) objects[5]) && String.valueOf(objects[7]).equals("true")  )				
				reco.put("puedeCalificar", "true");	
			if((boolean)objects[7] == true )
				reco.put("participando", "true");
			if((boolean)objects[8] == true )
				reco.put("calificado", "true");
			if((boolean)objects[9] == true )
				reco.put("denunciado", "true");
			if((boolean)objects[10] == true )
				reco.put("pendiente", "true");
			if(objects.length >= 10+1)
				reco.put("votos", String.valueOf(objects[9]));
			if(objects[11]!=null){
				reco.put("map", "true");
				reco.put("polygon",String.valueOf(objects[11]));
				reco.put("startA",String.valueOf(objects[12]));
				reco.put("startF",String.valueOf(objects[13]));
				reco.put("endA",String.valueOf(objects[14]));
				reco.put("endF",String.valueOf(objects[15]));
			}
			recorridos.add(reco);
		}
		return recorridos;
	}
	
	public boolean votar(int id,int recId){
		return false;
		
	}

	@Override
	public boolean denunciar(Recorrido recorrido, Denuncia denuncia) {
		// TODO Auto-generated method stub
		if(recorrido.addDenuncia(denuncia)){
			this.modificacion(recorrido);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Collection<HashMap<String, String>> getRecorridoByVoto(int userId,int paginas) {
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							// Informacion basica---
							"select r.direccionDesde , r.direccionHasta ,r.horaPartida ,r.horaRegreso ,r.asientos, r.evento.fecha, r.id,"
							//El case es para saber si yo participe de este recorrido y saber si puedo calificarlo o si ya lo califique
							+ " CASE WHEN (  :id in (select pa.id from Recorrido reco join reco.pasajeros pa where r.id=reco.id)   OR  :id in (select pa.id from Recorrido reco join reco.conductores pa where reco.id = r.id )   )  THEN true ELSE false END,   "
							//Este case es para decirme si ya califique a este recorrido
							+ " CASE WHEN ( :id  in (select v.votante.id from Voto v where v.recorrido.id = r.id)  ) THEN true ELSE false END, "
							//Este case es para ver si ya lo denuncie
							+ "CASE WHEN ( :id in (select d.creador.id from Denuncia d where d.recorrido.id = r.id ) ) THEN true ELSE false END,"
							// Este case me permite saber si existe solicitud pendiente mia para este recorrido
							+ "CASE WHEN (:id in (select s.solicitante.id from Solicitud s where s.recorrido.id = r.id ) ) THEN true ELSE false END, from Recorrido r where r.creador.id != :id and r.estado = 'true'  group by r.id ORDER BY COUNT(v.id) DESC ");

			
			consulta.setParameter("id", userId);
			Collection<Object[]> resultados = consulta.getResultList();
			ArrayList<HashMap<String, String>> recorridos = generarRecorridos(resultados);
			return recorridos;
		}catch (NoResultException e) {


			return null;
		}
	}

	@Override
	public Recorrido findRecorridoCreadorParticipanteById(int id,int idUser) {
		try {
			Query consulta = this
					.getEm()
					.createQuery(
							"select distinct e from Recorrido as e  where e.id= :id and e.estado=true and (:user in (select c.id from Recorrido r join r.conductores  c where e.id=r.id) or :user in (select p.id from Recorrido re join re.pasajeros p where re.id=e.id) )");
			consulta.setParameter("id", id);
			consulta.setParameter("user", idUser);
			return (Recorrido) consulta.getSingleResult();
		}

		catch (NoResultException e) {


			return null;
		}
	}

	@Override
	public Collection<Recorrido> recuperarRecorridosActivos() {
		try {
			Query consulta = this
					.getEm()
					.createQuery("Select r from Recorrido r where r.estado = true order by size(r.pasajeros) ").setMaxResults(6);
			return  consulta.getResultList();
		}

		catch (NoResultException e) {


			return null;
		}
	}
	

}
