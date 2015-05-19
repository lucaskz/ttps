<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:base>
	<t:header></t:header>
	<!-- Home news -->
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<s:form name="register" action="register" method="post" role="form"  enctype="multipart/form-data">
				<div class="col-md-6 col-md-offset-1">

					<div class="form-group row">
						<label for="inputName"><s:text name="usuario.form.nombre" /></label> <input type="text"
							class="form-control" id="inputName" name="nombre"
							placeholder="Ingresa tu nombre">
					</div>
					<div class="form-group row">
						<label for="inputApellido"><s:text name="usuario.form.apellido" /></label> <input type="text"
							class="form-control" id="inputApellido" name="apellido"
							placeholder="Ingresa tu apellido">
					</div>
					<div class="form-group row">
						<div class="col-md-2">
							<label for="inputArea"><s:text name="usuario.form.area" /></label> <input type="text"
								class="form-control" id="inputArea" name="area"
								placeholder="Ej:011">

						</div>
						<div class="col-md-4">
							<label for="inputTelefono"><s:text name="usuario.form.telefono" /></label> <input type="text"
								class="form-control" id="inputTelefono" name="telefono"
								placeholder="Ingresa tu teléfono">
						</div>

						<div class="checkbox  ">
							<label> <input name="celular" type="checkbox">
								<s:text name="usuario.form.celular" />
							</label>
						</div>

					</div>
					<div class="form-group row">
						<label for="inputEmail"><s:text name="usuario.form.mail" /></label> <input
							name="email" type="email" class="form-control" id="inputEmail"
							placeholder="Ingresa tu e-mail">

					</div>
					<div class="form-group row">
						<label for="inputPassword"><s:text name="usuario.form.clave" /></label> <input name="password"
							type="password" class="form-control" id="inputPassword"
							placeholder="Password">
					</div>
					<button type="submit"
						class=" btn btn-primary btn-lg btn btn-success"><s:text name="boton.enviar" /></button>
				</div>
				<div class="col-md-4 ">
					<div class="form-group">
						<label for="inputFile"><s:text name="usuario.form.fotoPersonal" /></label>
						<s:file onchange="PreviewImage();" id="inputFile" name="foto"
							label="Select a File to upload" size="40" />
						<p class="help-block"><s:text name="usuario.form.fotoDescripcion" /></p>
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