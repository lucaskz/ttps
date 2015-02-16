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
						<label for="inputName">Nombre del evento</label> <input type="text"
							class="form-control" id="inputName" name="nombre"
							placeholder="Ingresa tu nombre">
					</div>
					<div class="form-group">
						<label for="inputFecha">Fecha</label> <input type="datetime"
							class="form-control" id="inputFecha" name="fecha"
							placeholder="Selcciona una fecha">
					</div>
					<div class="form-group">
						<label for="inputDireccion">Direccion</label> <input type="text"
							class="form-control" id="inputDireccion" name="direccion"
							placeholder="Ingresa la dirección">
					</div>
					<div class="form-group">
						<label for="inputHora">Hora</label> <input
							name="hora" type="time" class="form-control" id="inputHora"
							placeholder="Hora del evento">
					</div>
					<div class="form-group">
						<label for="inputCiudad">Ciudad</label> <input
							name="ciudad" type="text" class="form-control" id="inputCiudad"
							placeholder="Ciudad del evento">
					</div>



					<button type="submit"
						class=" btn btn-primary btn-lg btn btn-success">Submit</button>

				</div>
				
				<div class="col-md-4 ">
					<div class="form-group">
						<label for="inputFile">Foto Evento</label>
						<s:file onchange="PreviewImage();" id="inputFile" name="foto"
							label="Select a File to upload" size="40" />
						<p class="help-block">Suba una foto del evento.</p>
					</div>
				</div>
				<div class="col-md-4 ">
					<img src="" alt="Preview" class="img-thumbnail"
						style="max-height: 290px;" id="uploadPreview">
				</div>
			</s:form>
			<s:fielderror />
	
		</div>

	</div>
	<t:footer></t:footer>

</t:base>