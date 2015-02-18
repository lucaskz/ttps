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
				<s:form name="enviar" action="enviar" method="post" role="form">

				
					<div class="form-group">
						<label for="inputPara">Para</label> <input type="datetime"
							class="form-control" id="inputPara" name="para"
							placeholder="Enviar a un correo destino">
					</div>

					<div class="form-group">
						<label for="inputAsunto">Asunto</label> <input
							name="asunto" type="text" class="form-control"
							id="inputAsunto" placeholder="Asunto del mensaje">
					</div>

					<div class="form-group">
						<label for="inputMensaje">Mensaje</label>
						<textarea class="form-control" id="inputMensaje" name="texto" rows="4"></textarea> 
					</div>

					<!-- /.col-lg-6 -->
					<button type="submit"
						class=" btn btn-primary btn-lg btn btn-success">Submit</button>
				</s:form>
				<s:fielderror />

			</div>
		</div>
	</div>
	<!-- end Home news -->
	<t:footer />
</t:base>