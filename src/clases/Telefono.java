package clases;

import javax.persistence.Embeddable;

@Embeddable
public class Telefono {

	private int codArea;
	
	private int numero;
	
	private boolean movil;

	public int getCodArea() {
		return codArea;
	}

	public void setCodArea(int codArea) {
		this.codArea = codArea;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public boolean isMovil() {
		return movil;
	}

	public void setMovil(boolean movil) {
		this.movil = movil;
	}
	


}
