<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
	<t:header user="${usrLogin}" />
	<!-- Home news -->
	<div class="container">
<!-- 		<button> -->
<!-- 			<b>+</b> -->
<!-- 		</button> -->
		<!-- Example row of columns -->

		<s:iterator value="eventos">
			<div>
				<div class="col-md-4">
					<h2>
						<s:property value="nombre" />
					</h2>
					<div class="row">
						<div class="col-xs-8 col-sm-6">
							<img src="${pageContext.request.contextPath}/retrieveImage?imageId=<s:property value="foto.id" />"
								alt="gmap.jpg" class="img-thumbnail" style="max-height: 140px;">
						</div>
						<div class="col-xs-4 col-sm-6">
							<p>
								<s:text name="evento.form.ciudad" /> :
								<s:property value="ciudad" />
							</p>
							<p>
								<s:text name="evento.form.direccion" /> :
								<s:property value="direccion" />
							</p>
							<p>
								<s:text name="evento.form.fecha" /> :
								<s:property value="fecha" />
							</p>
							<p>
								<s:text name="evento.form.hora" /> :
								<s:property value="hora" />
							</p>
						</div>
					</div>


					<p>
						<a class="btn btn-default" href="${pageContext.request.contextPath}/eventos/verEvento?idEvento=<s:property value="id" />" role="button">View details
							&raquo;</a>
					</p>
				</div>


			</div>

			<!-- this outputs the full object, may be useful for debugging -->
		</s:iterator>

	</div>

	<!-- end Home news -->
	<t:footer />
</t:base>