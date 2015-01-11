package clases;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Pasajero extends Usuario {

	@ElementCollection
	@CollectionTable(name = "EMAILS", joinColumns = @JoinColumn(name = "PASAJERO"))
	private List<String> emails = new LinkedList<String>();

	@ElementCollection
	private List<Telefono> telefonos = new LinkedList<Telefono>();

	@ManyToOne
	@JoinColumn(name = "reco_id")
	private Recorrido recorrido;

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
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
