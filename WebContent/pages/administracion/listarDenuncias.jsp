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
							<th><s:text name="denuncia.tabla.nombre" /></th>
							<th><s:text name="denuncia.tabla.apellido" /></th>
							<th><s:text name="denuncia.tabla.mail" /></th>
							<th><s:text name="denuncia.tabla.creador" /></th>
							<th><s:text name="denuncia.tabla.estado" /></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="denuncias" var="dactual">
							<tr>
								<th scope="row"><s:property value="id"/></th>
								<td><s:property value="denunciado.nombre" /></td>
								<td><s:property value="denunciado.apellido" /></td>
								<td><s:property value="denunciado.email" /></td>
								<td><s:property value="creador.nombre" /></td>
								<s:if test="#uactual.apobada == true ">
									<td><s:text name="denuncia.tabla.denunciado" /></td>
								</s:if>
								<s:else>
									<button type="button" id="aprobar-denuncia" denuncia="<s:property value="id"/>" class="btn btn-default quitarFixture" aria-label="Left Align">
			 								<span class="glyphicon glyphicon-ok" aria-hidden="true" ></span>
									</button>	
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