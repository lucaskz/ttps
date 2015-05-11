<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<sx:head />

<t:base>
	<t:header user="${usrLogin}" />
	<!-- Home news -->



	<div class="container " style="display: table;">
		<div class="row" style="display: table-row;">

			<t:administracionSidebar></t:administracionSidebar>
			<div class="col-sm-9 col-md-11 no-float ">
				<s:form name="modificarEvento" action="modificarEvento" method="post" role="form" enctype="multipart/form-data">
				<div class="col-md-6 col-md-offset-1">
				<input type="hidden" name="eventoId" value="<s:property value="evento.id" />"/>

					<div class="form-group">
						<label for="inputName">Nombre del evento</label> <input type="text"
							class="form-control" id="inputName" name="nombre" value="<s:property value="evento.nombre" />"
							placeholder="Ingresa nombre del evento">
					</div>
					<div class="form-group">
						<label for="inputFecha">Fecha</label> 
						
							<sx:datetimepicker name="fecha"  cssClass="form-control"  displayFormat="dd-MMM-yyyy" value="%{evento.fecha}"/>
						
						
					</div>
					<div class="form-group">
						<label for="inputDireccion">Direccion</label> <input type="text"
							class="form-control" id="inputDireccion" name="direccion" value="<s:property value="evento.direccion" />"
							placeholder="Ingresa la dirección">
					</div>
					<div class="form-group">
						<label for="inputHora">Hora</label> <input
							name="hora" type="time" class="form-control" id="inputHora" value="<s:property value="evento.hora" />"
							placeholder="Hora del evento">
					</div>
					<div class="form-group">
						<label for="inputCiudad">Ciudad</label> <input
							name="ciudad" type="text" class="form-control" id="inputCiudad" value="<s:property value="evento.ciudad" />"
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
			</div>

		</div>
	</div>
	<!-- end Home news -->
	<t:footer />
</t:base>