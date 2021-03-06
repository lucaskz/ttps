package actions;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import clases.Foto;
import clases.Pasajero;
import clases.Usuario;
import clasesDAO.FotoDAO;

public class RegisterAction extends GenericAction {

	/**
	 * 
	 */

	private FotoDAO fotoDAO;
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
		if (isLogged()) {
			return "logged";
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("seccion", "registro");
		request.getSession().setAttribute("accion", "registro");
		Usuario u = usuarioDAO.existeUsuario(getEmail());
		if (u == null) {
			u = new Pasajero();
			u.setEmail(getEmail());
			u.setPassword(getPassword());
			u.setNombre(getNombre());
			u.setApellido(getApellido());
			if (getFoto() == null) {// Foto por defecto,no se ingreso ninguna.
				Foto f = new Foto();
				Foto avatarDefault =   fotoDAO.getFotoByDes("avatar_default");
				f.setImagen( avatarDefault.getImagen());
				u.setFoto(f);
			} else {
				Foto foto = new Foto();
				foto.setDescripcion(getFotoFileName());
				byte[] imageData = new byte[(int) getFoto().length()];
				try {
					FileInputStream fileInputStream = new FileInputStream(
							getFoto());
					// convert file into array of bytes
					fileInputStream.read(imageData);
					fileInputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				foto.setImagen(imageData);
				u.setFoto(foto);
			}
			usuarioDAO.alta(u);
			return "success";
		} else {
			addFieldError("email", getText("mensaje.usuario.mailUsed"));
			return "input";
		}
	}
	
	public String showRegistro(){
		if (!isLogged()) {			
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("seccion", "registro");
			request.getSession().setAttribute("accion", "registro");
			return "success";
		}
		return "logged";
	}

	public void validate() {
		if (getEmail() == null || getEmail().isEmpty())
			addFieldError("mail", getText("mensaje.usuario.mail"));
		if (getPassword() == null || getPassword().isEmpty())
			addFieldError("mail", getText("mensaje.usuario.clave"));
		if (getApellido() == null || getApellido().isEmpty())
			addFieldError("apellido", getText("mensaje.usuario.apellido"));
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

	public FotoDAO getFotoDAO() {
		return fotoDAO;
	}

	public void setFotoDAO(FotoDAO fotoDAO) {
		this.fotoDAO = fotoDAO;
	}

}
