package clases;

import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario{



	@Override
	public boolean isAdministrador() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isPasajero() {
		// TODO Auto-generated method stub
		return false;
	}

}
