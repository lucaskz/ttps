package clases;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
public class Recorrido {
	@Id @GeneratedValue
	private int id;
	private String horaPartida;
	private String horaRegreso;
	private String direccionDesde;
	private String direccionHasta;
	private int asientos;
	
	@OneToOne
	private Pasajero conductor;
	
	@OneToMany(mappedBy = "recorrido") // Ver si es remove
	private List<Pasajero> pasajeros; 
	
	@OneToMany(mappedBy ="recorrido", cascade =
		{CascadeType.PERSIST, CascadeType.REMOVE})
	private Collection<Voto> votos;
	
	@ElementCollection(targetClass=DiasSemana.class)
	@Enumerated(EnumType.STRING)
	private List<DiasSemana> dias;
	
	@ManyToOne
	@JoinColumn(name="reco_id")
	private Evento evento;

	public String getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(String horaPartida) {
		this.horaPartida = horaPartida;
	}

	public String getHoraRegreso() {
		return horaRegreso;
	}

	public void setHoraRegreso(String horaRegreso) {
		this.horaRegreso = horaRegreso;
	}

	public String getDireccionDesde() {
		return direccionDesde;
	}

	public void setDireccionDesde(String direccionDesde) {
		this.direccionDesde = direccionDesde;
	}

	public String getDireccionHasta() {
		return direccionHasta;
	}

	public void setDireccionHasta(String direccionHasta) {
		this.direccionHasta = direccionHasta;
	}

	public Collection<Voto> getVotos() {
		return votos;
	}

	public void setVotos(Collection<Voto> votos) {
		this.votos = votos;
	}

	public int getAsientos() {
		return asientos;
	}

	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}

	public Pasajero getConductor() {
		return conductor;
	}

	public void setConductor(Pasajero conductor) {
		this.conductor = conductor;
	}

	public List<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(List<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

}
