package clases;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Mensaje {
	
	@Id @GeneratedValue
	private int id;
	
	private String texto;
	
	private Date fecha;

	private Boolean leido;
	
	private String asunto;
	
	
	@ManyToOne
	@JoinColumn(name="CREADOR_ID")
	private Usuario creador;
	
	@ManyToOne
	@JoinColumn(name="RECEPTOR_ID")
	private Usuario receptor;
	
	
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	public Usuario getReceptor() {
		return receptor;
	}
	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}
	public Boolean getLeido() {
		return leido;
	}
	public void setLeido(Boolean leido) {
		this.leido = leido;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}


}
