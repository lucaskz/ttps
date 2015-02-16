package clases;

import javax.persistence.*;

@Entity
public class Pasajero extends Usuario {


	

	public Pasajero () {
		super();
	}

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
