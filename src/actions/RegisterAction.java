package actions;

import java.io.File;

import clases.Foto;
import clases.Pasajero;
import clases.Usuario;
import clasesDAO.UsuarioDAO;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */

	private UsuarioDAO usuarioDAO;

	private String email;
	private String password;
	private String telefono;
	private String nombre;
	private String apellido;
	private File foto;
	private String fotoContentType;
    private String fotoFileName;

	private static final long serialVersionUID = -9153853278848404937L;
	
	

	public String execute() {
		Usuario u = usuarioDAO.existeUsuario(getEmail(), getPassword());
		if (u == null) {
			u = new Pasajero();
			u.setEmail(getEmail());
			u.setPassword(getPassword());
			u.setNombre(getNombre());
			u.setApellido(getApellido());
			Foto foto = new Foto();
			foto.setDescripcion(getFotoFileName());
			foto.setImagen(getFoto());
			u.setFoto(foto);
			usuarioDAO.alta(u);
			return SUCCESS;
		} else {
			addFieldError("email", "Dirección de correo en uso");
			return INPUT;
		}
	}

	public void validate(){
		if (getEmail() == null || getEmail().isEmpty())
			addFieldError("mail",
					"datos incorrectos");
		if (getPassword() == null || getPassword().isEmpty())
			addFieldError("mail", "datos incorrectos");
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getFotoContentType() {
		return fotoContentType;
	}

	public void setFotoContentType(String fotoContentType) {
		this.fotoContentType = fotoContentType;
	}

	public String getFotoFileName() {
		return fotoFileName;
	}

	public void setFotoFileName(String fotoFileName) {
		this.fotoFileName = fotoFileName;
	}

	public File getFoto() {
		return foto;
	}

	public void setFoto(File foto) {
		this.foto = foto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

}
