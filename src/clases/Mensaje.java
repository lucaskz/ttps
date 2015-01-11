package clases;

import javax.persistence.*;

@Entity
public class Mensaje {
	
	@Id @GeneratedValue
	private int id;
	
	private String texto;
	
	@OneToOne(optional=false)
	private Pasajero creador;
	
	@OneToOne(optional=false)
	private Pasajero destinatario;
	
	
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
	public Pasajero getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Pasajero destinatario) {
		this.destinatario = destinatario;
	}

}
