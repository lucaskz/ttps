package clases;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Solicitud {
	
	@Id @GeneratedValue
	private long id;
	
	@ManyToOne (cascade =
		{CascadeType.PERSIST, CascadeType.REMOVE})
	private Recorrido recorrido;
	
	@OneToOne
	private Usuario solicitante;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;
	/**
	 * 0 = pendiente
	 * 1 = aceptado
	 * 2 = denegado
	 * 
	 * @return
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Recorrido getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}

	public Usuario getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Usuario solicitante) {
		this.solicitante = solicitante;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}


}
