<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
	<t:header user="${usrLogin}" />
	<!-- Home news -->
	<div class="container">
		<!-- 		</button> -->
		<!-- 		<button> -->
		<!-- 			<b>+</b> -->
		<!-- Example row of columns -->
		<s:iterator value="recibidos">
		
			<div>
				<div class="col-md-4">
					<h2>
						<s:property value="nombre" />
					</h2>
					<div class="row">
						<div class="col-xs-4 col-sm-6">
							<p>
								De :
								<s:property value="creador.nombre" />
							</p>
							<p>
								Fecha :
								<s:property value="fecha" />
							</p>
							<p>
								Hora :
								<s:property value="hora" />
							</p>
							<p>
								Texto :
								<s:property value="texto" />
							</p>
						</div>
					</div>
				</div>
			</div>
		</s:iterator>
	</div>

	<!-- end Home news -->
	<t:footer />
</t:base>