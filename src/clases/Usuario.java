package clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String email;

	private String password;

	private String nombre;

	private String apellido;
	
	private boolean estado;
	
	//one to one uniderectional, para recuperar las denuncias acumuladas del usuario.
	@OneToMany(cascade={CascadeType.MERGE})
	  @JoinTable(name = "USR_DEN", joinColumns = @JoinColumn(name = "USR_ID"), inverseJoinColumns = @JoinColumn(name = "DEN_ID"))
	private List<Denuncia> denuncias;
	
	
	@OneToMany(mappedBy = "creador",  cascade = {
			CascadeType.ALL })
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Recorrido> recorridos;
	
	public void addRecorrido(Recorrido recorrido){

		if (!recorridos.contains(recorrido)) {

			recorridos.add(recorrido);

		}
	}
	
	
	
	
	public int getNoLeidos(){
		int i = 0 ;
		
		for (Iterator<Mensaje> iterator = recibidos.iterator(); iterator.hasNext();) {
			Mensaje mensaje = (Mensaje) iterator.next();
			if(!mensaje.getLeido()){
				i++;
			}
		}
		return i;
	}


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "foto_fk")
	private Foto foto;
	
	public Usuario() {
		enviados = new ArrayList<Mensaje>();
		recibidos = new ArrayList<Mensaje>();
		recorridos = new ArrayList<Recorrido>();
		denuncias = new ArrayList<Denuncia>();
		estado = true;
		}


	// @ElementCollection
	// @CollectionTable(name = "EMAILS", joinColumns = @JoinColumn(name =
	// "PASAJERO"))
	// private List<String> emails = new LinkedList<String>();
	
	
	

	@ElementCollection
	private List<Telefono> telefonos = new LinkedList<Telefono>();

	@OneToMany(mappedBy = "creador",  cascade = {
			CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE })
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Mensaje> enviados;

	@OneToMany(mappedBy = "receptor",  cascade = {
			CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE })
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Mensaje> recibidos;

	public abstract boolean isPasajero();

	public abstract boolean isAdministrador();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public void addEnviado(Mensaje mensaje) {

		if (!enviados.contains(mensaje)) {

			enviados.add(mensaje);

		}

	}
	
	public void addRecibidos(Mensaje mensaje) {

		if (!recibidos.contains(mensaje)) {

			recibidos.add(mensaje);

		}

	}
	
	public void addDenuncia(Denuncia denuncia){
		if (!denuncias.contains(denuncia)){
			denuncias.add(denuncia);
		}
	}

	// public List<String> getEmails() {
	// return emails;
	// }
	//
	// public void setEmails(List<String> emails) {
	// this.emails = emails;
	// }

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public List<Mensaje> getEnviados() {
		return enviados;
	}

	public void setEnviados(List<Mensaje> enviados) {
		this.enviados = enviados;
	}

	public List<Mensaje> getRecibidos() {
		return recibidos;
	}

	public void setRecibidos(List<Mensaje> recibidos) {
		this.recibidos = recibidos;
	}

	public String getEmail() {
		return email;
	}

	public List<Denuncia> getDenuncias() {
		return denuncias;
	}


	public void setDenuncias(List<Denuncia> denuncias) {
		this.denuncias = denuncias;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public List<Recorrido> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(List<Recorrido> recorridos) {
		this.recorridos = recorridos;
	}




	public boolean isEstado() {
		return estado;
	}




	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
