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
				<div class="list-group">
					<a href="#" class="list-group-item ">
						<div class="row">
							<h4 class="list-group-item-heading">List group item heading</h4>
						</div>

						<div class="row">
							<div
								class="list-group-item-text col-sm-3 col-md-3
							col-md-offset-5">
								Hora Partida : 15:00</div>
						</div>
						<div class="row">
							<div
								class="list-group-item-text col-sm-3 col-md-3
							col-md-offset-5">
								Hora Regreso : 19:00</div>
						</div>
						<div class="row">
							<h4>TEST</h4>
						</div>
					</a> <a href="#" class="list-group-item ">
						<div class="row">
							<h4 class="list-group-item-heading">List group item heading</h4>
						</div>

						<div class="row">
							<div
								class="list-group-item-text col-sm-3 col-md-3
							col-md-offset-5">
								Hora Partida : 15:00</div>
						</div>
						<div class="row">
							<div
								class="list-group-item-text col-sm-3 col-md-3
							col-md-offset-5">
								Hora Regreso : 19:00</div>
						</div>
						<div class="row">
							<h4>TEST</h4>
						</div>
					</a> <a href="#" class="list-group-item ">
						<div class="row">
							<h4 class="list-group-item-heading">List group item heading</h4>
						</div>

						<div class="row">
							<div
								class="list-group-item-text col-sm-3 col-md-3
							col-md-offset-5">
								Hora Partida : 15:00</div>
						</div>
						<div class="row">
							<div
								class="list-group-item-text col-sm-3 col-md-3
							col-md-offset-5">
								Hora Regreso : 19:00</div>
						</div>
						<div class="row">
							<h4>TEST</h4>
						</div>
					</a>
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