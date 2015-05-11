package clases;

import java.sql.Time;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Evento {
	
	@Id @GeneratedValue
	private int id;
	
	private String nombre;
	
	@OneToMany(mappedBy ="evento", cascade =
		{CascadeType.PERSIST, CascadeType.REMOVE})
	private Collection<Recorrido> recorridos;
	
	@OneToOne(optional=true,cascade = CascadeType.ALL)
	private Foto foto;
	
	private String direccion;
	
	private Date fecha;
	
	private Time hora;
	
	private String ciudad;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Collection<Recorrido> getRecorridos() {
		return recorridos;
	}
	public void setRecorridos(Collection<Recorrido> recorridos) {
		this.recorridos = recorridos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Foto getFoto() {
		return foto;
	}
	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
}
