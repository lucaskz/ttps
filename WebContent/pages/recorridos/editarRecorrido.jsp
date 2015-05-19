<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
	<t:header user="${usrLogin}" />
	<!-- Home news -->
	<div class="container " style="display: table;">
		<div class="row" style="display: table-row;">
			<t:recorridosSidebar></t:recorridosSidebar>
			<div class="col-sm-9 col-md-11 no-float ">
				<s:form name="modificar" action="modificar" method="post" role="form">
					<input type="hidden" name="recorrido" value="<s:property value="recorrido.id"/>">
				<div class="row">					
						<h2 style="padding-top:1em;text-align: center"class="list-group-item-heading">Recorrido #<s:property value="recorrido.id"/> </h2>
				</div>
				<div class="row" style="padding-top:3em">
					<div class="col-xs-5 col-sm-5 col-md-offset-1">
						<img src="${pageContext.request.contextPath}/img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"								style="max-height: 140px;">
					</div>
					<div class="row">
						<div class="form-group col-xs-5 col-sm-5">
							<label for="inputDireccionDesde"><s:text name="recorrido.form.direccionDesde" /></label> <input
								type="text" class="form-control" id="inputDireccionDesde"
								name="desde" value="<s:property value="recorrido.direccionDesde"/>" placeholder="Ingresa la dirección de partida">
						</div>
						<div class="form-group col-xs-5 col-sm-5 ">
							<label for="inputDireccionHasta"><s:text name="recorrido.form.direccionHasta" /></label> <input
								type="text" class="form-control" id="inputDireccionHasta"
								name="hasta" value="<s:property value="recorrido.direccionHasta"/>" placeholder="Ingresa la dirección del destino ">
						</div>
					</div>	
				</div>
				<div class="row" style="padding-top:3em">
					<div class="form-group col-md-5 col-md-offset-1">
						<label for="inputHoraPartida"><s:text name="recorrido.form.horaPartida" /></label> <input
							name="partida" type="time" class="form-control"
							id="inputHoraPartida" value="<s:property value="recorrido.horaPartida"/>" placeholder="Hora de Partida">
					</div>

					<div class="form-group col-md-5">
						<label for="inputHoraRegreso"><s:text name="recorrido.form.horaRegreso" /></label> <input
							name="regreso" type="time" class="form-control"
							id="inputHoraRegreso" value="<s:property value="recorrido.horaRegreso"/>" placeholder="Hora de Regreso">
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-5 col-md-offset-1">
						<div class="row">
							<h3><s:text name="recorrido.lista.conductores" /></h3>
						</div>	
						<div class="row">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th><s:text name="usuario.form.nombre" /></th>
									<th><s:text name="usuario.form.apellido" /></th>
									<th><s:text name="usuario.form.mail" /></th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="recorrido.conductores" var="rActual">
									<tr>
										<th scope="row"><s:property value="id" /></th>
										<td><s:property value="nombre" /></td>
										<td><s:property value="apellido" /></td>
										<td><s:property value="email" /></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						</div>
					</div>
					<div class="col-md-5">
						<div class="row">
							<h3><s:text name="recorrido.lista.pasajeros" /></h3>
						</div>
						<div class="row">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th><s:text name="usuario.form.nombre" /></th>
									<th><s:text name="usuario.form.apellido" /></th>
									<th><s:text name="usuario.form.mail" /></th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="recorrido.pasajeros" var="rActual">
									<tr>
										<th scope="row"><s:property value="id" /></th>
										<td><s:property value="nombre" /></td>
										<td><s:property value="apellido" /></td>
										<td><s:property value="email" /></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5  col-md-offset-4">
					<button type="submit"	class=" btn btn-primary btn-lg btn btn-success"><s:text name="boton.guardar" /></button>
					
					<button type="button" id="cancelar-recorrido"	class=" btn btn-primary btn-lg btn btn-danger"><s:text name="boton.cancelar" /></button>
					</div>
				</div>
				</s:form>
				<form action="bajaRecorrido" id="cancelar-recorrido-form">
					<input type="hidden" name="recorrido" value="<s:property value="recorrido.id"/>">
				</form>
			</div>
		</div>
	</div>
	<!-- end Home news -->
	<t:footer />
</t:base>