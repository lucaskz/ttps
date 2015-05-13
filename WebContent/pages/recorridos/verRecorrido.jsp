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
				<div class="row">
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
			</div>
		</div>
	</div>
	<!-- end Home news -->
	<t:footer />
</t:base>