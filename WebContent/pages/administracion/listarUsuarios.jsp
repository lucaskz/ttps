<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
	<t:header user="${usrLogin}" />
	<!-- Home news -->



	<div class="container " style="display: table;">
		<div class="row" style="display: table-row;">

			<t:administracionSidebar></t:administracionSidebar>
			<div class="col-sm-9 col-md-11 no-float ">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Mail</th>
							<th>Denuncias</th>
							<th>Estado</th>
							<th>Deshabilitar</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="usuarios" var="uactual">
							<tr>
								<th scope="row"><s:property value="id"/></th>
								<td><s:property value="nombre" /></td>
								<td><s:property value="apellido" /></td>
								<td><s:property value="email" /></td>
								<td><s:property value="denuncias.size()" /></td>
								<s:if test="#uactual.estado == true ">
									<td>Habilitado</td>
								<td>
									<button type="button" id="deshabilitar-usuario" usuario="<s:property value="id"/>" class="btn btn-default quitarFixture" aria-label="Left Align">
			 								<span class="glyphicon glyphicon-remove-circle" aria-hidden="true" ></span>
									</button>	
								</td>
								</s:if>
								<s:else>
									<td>Deshabilitado</td>
									<td></td>
								</s:else>

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