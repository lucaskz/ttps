package clases;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Voto {

	@Id @GeneratedValue
	protected int id;
	
	@OneToOne(optional=false)
	private Usuario votante;
	
	@ManyToOne
	@JoinColumn(name="reco_id")
	private Recorrido recorrido;
	

	public Recorrido getRecorrido() {
		return recorrido;
	}
	public void setRecorrido(Recorrido recorrido) {
		this.recorrido = recorrido;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getVotante() {
		return votante;
	}
	public void setVotante(Usuario user) {
		this.votante = user;
	}
}
