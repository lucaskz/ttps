package clasesDAO;


import java.util.Collection;

import clases.Solicitud;
import clases.Usuario;

public interface SolicitudDAO extends GenericDAO<Solicitud>{

	Collection<Solicitud> recuperarSolicitudes(int id);

	Usuario solicitar(Usuario u, Long recId);
}
