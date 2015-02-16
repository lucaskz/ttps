package actions;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.tomcat.util.codec.binary.Base64;

import clases.Foto;
import clasesDAO.FotoDAO;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5053542784133028453L;

	/**
	 * 
	 */

	private FotoDAO fotoDAO;

	public byte[] imageInByte = null;
	String imageId;

	private HttpServletRequest servletRequest;

	public void execute(ActionInvocation invocation) throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType("image/jpeg");
		response.getOutputStream().write(
				fotoDAO.getFotoById(Integer.parseInt(imageId)).getImagen());
		response.getOutputStream().flush();

	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void retrieveImage() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();

		/*
		 * ImageAction action = (ImageAction) invocation.getAction();
		 * HttpServletResponse response = ServletActionContext.getResponse();
		 * 
		 * response.setContentType(action.getCustomContentType());
		 * response.getOutputStream().write(action.getCustomImageInBytes());
		 * response.getOutputStream().flush();
		 * 
		 * 
		 * String filePath =
		 * servletRequest.getSession().getServletContext().getRealPath("/");
		 * File file = new File(filePath + "/Image/", imageId);
		 * System.out.println(file.toString()); return file;
		 */

		// String imageDataString =
		// Base64.encodeBase64String(fotoDAO.getFotoById(Integer.parseInt(imageId)).getImagen());
		// response.setContentType("image/jpeg");

		if (!(getImageId() == null) && !getImageId().isEmpty()) {
			Foto foto = fotoDAO.getFotoById(Integer.parseInt(getImageId()));
			if (foto != null) {
				response.getOutputStream().write(foto.getImagen());
			}

			response.getOutputStream().flush();
		}

	}

	public String getCustomContentType() {
		return "image/jpeg";
	}

	public String getCustomContentDisposition() {
		return "anyname.jpg";
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;

	}

	public FotoDAO getFotoDAO() {
		return fotoDAO;
	}

	public void setFotoDAO(FotoDAO fotoDAO) {
		this.fotoDAO = fotoDAO;
	}

	public byte[] getImageInByte() {
		return imageInByte;
	}

	public void setImageInByte(byte[] imageInByte) {
		this.imageInByte = imageInByte;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

}
