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
						<a href="#" class="list-group-item  ">
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
				<nav class="text-center">
					<ul class="pagination">
						<li><a href="#" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<!-- end Home news -->
	<t:footer />
</t:base>