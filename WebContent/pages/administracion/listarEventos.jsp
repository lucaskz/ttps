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
							<th>Fecha</th>
							<th>Ciudad</th>
							<th>#</th>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="eventos">
						<tr class="clickeable" onclick="window.document.location='evento?&id=<s:property value="id"/>';" >
							<th scope="row"><s:property value="id"/></th>
							<td><s:property value="nombre"/></td>
							<td><s:property value="fecha"/></td>
							<td><s:property value="ciudad"/></td>
							<td>											
								<button type="button" class="btn btn-default quitarFixture" aria-label="Left Align">
			 						<span class="glyphicon glyphicon-remove-circle" aria-hidden="true" ></span>
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