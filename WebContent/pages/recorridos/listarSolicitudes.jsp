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
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Desde</th>
							<th>Hasta</th>
							<th>Solicitante</th>
							<th>Estado</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="solicitudes" var="sActual">
						<tr>
							<th scope="row"><s:property value="id"/></th>
							<td><s:property value="recorrido.direccionDesde"/></td>
							<td><s:property value="recorrido.direccionHasta"/></td>
							<td><s:property value="solicitante.nombre"/></td>
							<td><s:property value="estado"/></td>
							<td>
								<button type="button" class="btn btn-default  btn-success"   onclick="window.document.location='../recorridos/aceptarSolicitud?&solicitud=<s:property value="#sActual.id"/>';" aria-label="Left Align">
											  <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
								</button>
								<button type="button" class="btn btn-default  btn-danger"   onclick="window.document.location='../recorridos/rechazarSolicitud?&solicitud=<s:property value="#sActual.id"/>';" aria-label="Left Align">
											  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</button>
							</td>
						</tr>
					</s:iterator>
					</tbody>
				</table>
			</div>

		</div>
	</div>
	<!-- end Home news -->
	<t:footer />
</t:base>