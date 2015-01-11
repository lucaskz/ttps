package clases;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Evento {
	
	@Id @GeneratedValue
	private int id;
	private String nombre;
	
	@OneToMany(mappedBy ="evento", cascade =
		{CascadeType.PERSIST, CascadeType.REMOVE})
	private Collection<Recorrido> recorridos;
	
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
}
