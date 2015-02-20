package clases;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Recorrido {
	@Id @GeneratedValue
	@Column(name="REC_ID")
	private int id;
	private Time horaPartida;
	private Time horaRegreso;
	private String direccionDesde;
	private String direccionHasta;
	private int asientos;
	
	public Recorrido(){
		conductores= new ArrayList<Usuario>();
		pasajeros= new ArrayList<Usuario>();
		votos = new ArrayList<Voto>();
		denuncias = new ArrayList<Denuncia>();
		asientos = 0 ;
			
		
	}
	
	@OneToMany(mappedBy ="recorrido", cascade =
		{CascadeType.PERSIST, CascadeType.MERGE})
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Denuncia> denuncias;
	
	@OneToMany
	  @JoinTable(name = "REC_DRIVER", joinColumns = @JoinColumn(name = "REC_ID"), inverseJoinColumns = @JoinColumn(name = "DRIVER_ID"))
		private List<Usuario> conductores;
	
	@OneToMany
	  @JoinTable(name = "REC_PAS", joinColumns = @JoinColumn(name = "REC_ID"), inverseJoinColumns = @JoinColumn(name = "PAS_ID"))
		private List<Usuario> pasajeros;
	
	@OneToMany(mappedBy ="recorrido", cascade =
		{CascadeType.PERSIST, CascadeType.REMOVE})
	private Collection<Voto> votos;
	
	@ElementCollection(targetClass=DiasSemana.class)
	@Enumerated(EnumType.STRING)
	private List<DiasSemana> dias;
	
	@ManyToOne (cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="EVENT_ID")
	private Evento evento;
	
	
	@ManyToOne
	@JoinColumn(name="CREADOR_ID")
	private Usuario creador;
	
	private Date fecha;
	
	public void addConductor(Usuario pasajero) {

		if (!conductores.contains(pasajero)) {

			conductores.add(pasajero);

		}
		asientos--;

	}
	
	public boolean addDenuncia(Denuncia denuncia){
		if(!denuncias.contains(denuncia)){
			denuncias.add(denuncia);
			return true;
		}
		return false;
	}
	
	public void addPasajero(Usuario pasajero) {

		if (!pasajeros.contains(pasajero)) {

			pasajeros.add(pasajero);

		}
		asientos--;

	}
	
	public void addConductorPasajero(Usuario pasajero) {

		if (!conductores.contains(pasajero)&&!pasajeros.contains(pasajero)) {

			conductores.add(pasajero);
			pasajeros.add(pasajero);

		}
		asientos--;

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



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public List<DiasSemana> getDias() {
		return dias;
	}

	public void setDias(List<DiasSemana> dias) {
		this.dias = dias;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
	}

	public List<Usuario> getConductores() {
		return conductores;
	}

	public void setConductores(List<Usuario> conductores) {
		this.conductores = conductores;
	}

	public List<Usuario> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(List<Usuario> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public Time getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(Time horaPartida) {
		this.horaPartida = horaPartida;
	}

	public Time getHoraRegreso() {
		return horaRegreso;
	}

	public void setHoraRegreso(Time horaRegreso) {
		this.horaRegreso = horaRegreso;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Collection<Denuncia> getDenuncias() {
		return denuncias;
	}

	public void setDenuncias(Collection<Denuncia> denuncias) {
		this.denuncias = denuncias;
	}

}
