package clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Denuncia {
	
	@Id @GeneratedValue
	private int id;
	private String texto;
	
	@OneToOne
	private Pasajero creador;
	
	@OneToOne
	private Pasajero denunciado;
	
	public Denuncia(){
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Pasajero getCreador() {
		return creador;
	}
	public void setCreador(Pasajero creador) {
		this.creador = creador;
	}
	public Pasajero getDenunciado() {
		return denunciado;
	}
	public void setDenunciado(Pasajero denunciado) {
		this.denunciado = denunciado;
	}
}
