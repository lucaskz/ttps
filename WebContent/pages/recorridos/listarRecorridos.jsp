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

				<div class="list-group">
					<s:iterator value="recorridos">
						<a href="#" class="list-group-item ">
							<div class="row">
								<h4 class="list-group-item-heading">List group item heading</h4>
							</div>

							<div class="row">
								<div
									class="list-group-item-text col-sm-3 col-md-3
							col-md-offset-5">
									Hora Partida:<s:property value="horaPartida" />
								</div>
							</div>
							<div class="row">
								<div
									class="list-group-item-text col-sm-3 col-md-3
							col-md-offset-5">
									Hora Regreso:<s:property value="horaRegreso" />
								</div>
							</div>
							<div class="row">
								Asientos:<s:property value="asientos" />
							</div>
							<a class="btn btn-default" href="${pageContext.request.contextPath}/recorridos/denunciar?idRecorrido=<s:property value="id" />" role="button">Denunciar
						&raquo;</a>

						</a>
					</s:iterator>
					<s:iterator value="misRecorridos">
						<a href="#" class="list-group-item ">
							<div class="row">
								<h4 class="list-group-item-heading">List group item heading</h4>
							</div>

							<div class="row">
								<div
									class="list-group-item-text col-sm-3 col-md-3
							col-md-offset-5">
									Hora Partida:<s:property value="horaPartida" />
								</div>
							</div>
							<div class="row">
								<div
									class="list-group-item-text col-sm-3 col-md-3
							col-md-offset-5">
									Hora Regreso:<s:property value="horaRegreso" />
								</div>
							</div>
							<div class="row">
								Asientos:<s:property value="asientos" />
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