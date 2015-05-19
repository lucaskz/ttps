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
							<th><s:text name="evento.tabla.nombre" /></th>
							<th><s:text name="evento.tabla.fecha" /></th>
							<th><s:text name="evento.tabla.ciudad" /></th>
							<th><s:text name="evento.tabla.estado" /></th>
							<th><s:text name="evento.tabla.deshabilitar" /></th>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="eventos" var="eactual">
						<tr class="clickeable" onclick="window.document.location='evento?&id=<s:property value="id"/>';" >
							<th scope="row"><s:property value="id"/></th>
							<td><s:property value="nombre"/></td>
							<td><s:property value="fecha"/></td>
							<td><s:property value="ciudad"/></td>
							<s:if test="#eactual.estado == true ">
									<td><s:text name="estado.habilitado" /></td>
								<td>
									<button type="button" id="deshabilitar-usuario" evento="<s:property value="id"/>" class="btn btn-default quitarFixture" aria-label="Left Align">
			 								<span class="glyphicon glyphicon-remove-circle" aria-hidden="true" ></span>
									</button>	
								</td>
								</s:if>
								<s:else>
									<td><s:text name="estado.deshabilitado" /></td>
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