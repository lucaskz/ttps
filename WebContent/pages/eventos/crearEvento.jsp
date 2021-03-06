<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:base>
	<t:header user="${usrLogin}"  />
	<!-- Home news -->
	<div class="container">
		<div class="row">
			<s:form name="register" action="register" method="post" role="form" enctype="multipart/form-data">
				<div class="col-md-6 col-md-offset-1">

					<div class="form-group">
						<label for="inputName"><s:text name="evento.form.nomrbe" /></label> <input type="text"
							class="form-control" id="inputName" name="nombre"
							placeholder="Ingresa tu nombre">
					</div>
					<div class="form-group">
						<label for="inputFecha"><s:text name="evento.form.fecha" /></label> <input type="datetime"
							class="form-control" id="inputFecha" name="fecha"
							placeholder="Selcciona una fecha">
					</div>
					<div class="form-group">
						<label for="inputDireccion"><s:text name="evento.form.direccion" /></label> <input type="text"
							class="form-control" id="inputDireccion" name="direccion"
							placeholder="Ingresa la direcci�n">
					</div>
					<div class="form-group">
						<label for="inputHora"><s:text name="evento.form.hora" /></label> <input
							name="hora" type="time" class="form-control" id="inputHora"
							placeholder="Hora del evento">
					</div>
					<div class="form-group">
						<label for="inputCiudad"><s:text name="evento.form.ciudad" /></label> <input
							name="ciudad" type="text" class="form-control" id="inputCiudad"
							placeholder="Ciudad del evento">
					</div>
					<button type="submit"
						class=" btn btn-primary btn-lg btn btn-success"><s:text name="boton.enviar" /></button>

				</div>
				
				<div class="col-md-4 ">
					<div class="form-group">
						<label for="inputFile"><s:text name="evento.form.fotoEvento" /></label>
						<s:file onchange="PreviewImage();" id="inputFile" name="foto"
							label="Select a File to upload" size="40" />
						<p class="help-block"><s:text name="evento.form.fotoDescripcion" /></p>
					</div>
				</div>
				<div class="col-md-4 ">
					<img src="" alt="Preview" class="img-thumbnail"
						style="max-height: 290px;" id="uploadPreview">
				</div>
			</s:form>
	
		</div>

	</div>
	<t:footer></t:footer>

</t:base>