<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
	<t:header user="${usrLogin}" />
	<!-- Home news -->



	<div class="container " style="display: table;">
		<div class="row" style="display: table-row;">

			<t:mensajesSidebar></t:mensajesSidebar>

			<div class="col-sm-9 col-md-11 no-float ">



				<div class="list-group">
					<s:iterator value="recibidos">
						<a href="mensaje?&id=<s:property value="id" />" class="list-group-item  ">
							<div class="row">
								<div class="list-group-item-text col-sm-3 col-md-3">

									<h4>
										<s:if test="leido == false ">
											<strong>
										</s:if>
										<s:property value="creador.nombre" />
										<s:property value="creador.apellido" />
										<s:if test="leido == false ">
											</strong>
										</s:if>
									</h4>
								</div>
								<div class="list-group-item-text col-sm-4 col-md-6">
									<s:if test="leido == false ">
										<strong>
									</s:if>
									<s:property value="asunto" />
									<s:if test="leido == false ">
										</strong>
									</s:if>
								</div>
								<div class="list-group-item-text col-sm-2 col-md-2">
									<s:property value="fecha" />
								</div>
							</div>
						</a>
					</s:iterator>
				</div>
			</div>
		</div>
	</div>
	<!-- end Home news -->
	<t:footer />
</t:base>