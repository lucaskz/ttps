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

			<div class="col-sm-9 col-md-11 no-float " >

					<div class="form-group">
						<label for="inputAsunto"><s:text name="mensaje.form.asunto" /></label> <input
							name="asunto" type="text" class="form-control"
							id="inputAsunto" placeholder="Asunto del mensaje" value="<s:property value="mensaje.asunto" />" readonly> 
					</div>

					<div class="form-group">
						<label for="inputMensaje"><s:text name="mensaje.form.mensaje" /></label>
						<textarea readonly class="form-control" id="inputMensaje" name="texto" rows="4"><s:property value="mensaje.texto" /></textarea> 
					</div>

					<!-- /.col-lg-6 -->
				

			</div>
		</div>
	</div>
	<!-- end Home news -->
	<t:footer />
</t:base>