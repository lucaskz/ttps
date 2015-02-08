package clases;

import java.sql.Time;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Mensaje {
	
	@Id @GeneratedValue
	private int id;
	
	private String texto;
	
	private Date fecha;
	
	private Time hora;
	
	
	@ManyToOne
	@JoinColumn(name="u_creador_id")
	private Usuario creador;
	
	@ManyToOne
	@JoinColumn(name="u_receptor_id")
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
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
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


}
