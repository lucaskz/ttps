package clases;

import javax.persistence.*;

@Entity
public class Pasajero extends Usuario {


	@ManyToOne
	@JoinColumn(name = "reco_id")
	private Recorrido recorrido;


	@Override
	public boolean isPasajero() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAdministrador() {
		// TODO Auto-generated method stub
		return false;
	}

}
