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
				<div class="row">					
						<h2 style="padding-top:1em;text-align: center"class="list-group-item-heading">Recorrido #<s:property value="recorrido.id"/> </h2>
				</div>
				<div class="row" style="padding-top:3em">
					<div class="col-xs-5 col-sm-5 col-md-offset-1">
						<img src="${pageContext.request.contextPath}/img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"								style="max-height: 140px;">
					</div>
					<div class="row">
						<div class="form-group col-xs-5 col-sm-5">
							<label for="inputDireccionDesde">Dirección Desde</label> <input
								type="text" class="form-control" id="inputDireccionDesde"
								name="desde" value="<s:property value="recorrido.direccionDesde"/>" placeholder="Ingresa la dirección de partida">
						</div>
						<div class="form-group col-xs-5 col-sm-5 ">
							<label for="inputDireccionHasta">Dirección Hasta</label> <input
								type="text" class="form-control" id="inputDireccionHasta"
								name="hasta" value="<s:property value="recorrido.direccionHasta"/>" placeholder="Ingresa la dirección del destino ">
						</div>
					</div>	
				</div>
				<div class="row" style="padding-top:3em">
					<div class="form-group col-md-5 col-md-offset-1">
						<label for="inputHoraPartida">Hora Partida</label> <input
							name="partida" type="time" class="form-control"
							id="inputHoraPartida" value="<s:property value="recorrido.horaPartida"/>" placeholder="Hora de Partida">
					</div>

					<div class="form-group col-md-5">
						<label for="inputHoraRegreso">Hora Regreso</label> <input
							name="regreso" type="time" class="form-control"
							id="inputHoraRegreso" value="<s:property value="recorrido.horaRegreso"/>" placeholder="Hora de Regreso">
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-5 col-md-offset-1">	
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Nombre</th>
									<th>Apellido</th>
									<th>Mail</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="conductores" var="rActual">
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
					<div class="col-md-5">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Nombre</th>
									<th>Apellido</th>
									<th>Mail</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="pasajeros" var="rActual">
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
				<div class="row">
					<div class="col-md-5  col-md-offset-4">
					<button type="submit"	class=" btn btn-primary btn-lg btn btn-success">Guardar</button>
					
					<button type="submit" id="cancelar-recorrido"	class=" btn btn-primary btn-lg btn btn-danger">Cancelar</button>
					</div>
				</div>
				</s:form>
			</div>
		</div>
	</div>
	<!-- end Home news -->
	<t:footer />
</t:base>