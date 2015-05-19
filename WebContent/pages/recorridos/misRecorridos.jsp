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
				<div class="row list-group" id="recorrido-list">
					<s:iterator value="misRecorridos">
						<a href="${pageContext.request.contextPath}/recorridos/recorrido?&recorrido=<s:property value="id" />" class="list-group-item ">
							<div class="row">
								<div class="col-sm-4">
									<h4 class="list-group-item-heading"><s:text name="sidebarRecorrido.seccion.recorrido" /> # <s:property value="id"/> </h4>
								</div>
							</div>

							<div class="row">
								<div class=" col-sm-3 col-md-3		col-md-offset-5">
									<s:text name="recorrido.lista.horaPartida" /> <s:property value="horaPartida"/>
								</div>
							</div>
							<div class="row">
								<div	class="col-sm-3 col-md-3			col-md-offset-5">
									<s:text name="recorrido.lista.horaRegreso" /><s:property value="horaRegreso"/> 
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									<s:text name="recorrido.lista.asientos" /> <s:property value="asientos"/>
								</div>
								
							</div>
		
						</a>
					</s:iterator>
				</div>
				<nav class="text-center" id="input-paginador">
				
				</nav>
			</div>
		</div>
	</div>

	<!-- end Home news -->
	<t:footer />
</t:base>