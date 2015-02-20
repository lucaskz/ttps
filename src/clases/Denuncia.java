package clases;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Denuncia {
	
	@Id @GeneratedValue
	private int id;
	private String texto;
	
	@OneToOne
	private Usuario creador;
	
	@OneToOne
	private Usuario denunciado;
	
	private boolean apobada;
	
	@ManyToOne
	@JoinColumn(name = "reco_id")
	private Recorrido recorrido;
	
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
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario user) {
		this.creador = user;
	}
	public Usuario getDenunciado() {
		return denunciado;
	}
	public void setDenunciado(Usuario denunciado) {
		this.denunciado = denunciado;
	}

	public boolean isApobada() {
		return apobada;
	}

	public void setApobada(boolean apobada) {
		this.apobada = apobada;
	}

	public Recorrido getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
}
