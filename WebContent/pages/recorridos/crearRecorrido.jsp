<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:base>
	<t:header user="${usrLogin}" />
	<!-- Home news -->
	<div class="container">
		<div class="row">
			<s:form name="alta" action="alta" method="post" role="form"	>

				<div class="form-group">
					<div class="input-group">
						<div class="radio">
							<label><input type="radio" name="rol" value="conductor">Conductor</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="rol" value="pasajero">Pasajero</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="rol" value="ambos">Ambos</label>
						</div>
					</div>
					<!-- /input-group -->
				</div>


				<div class="form-group">
					<label for="inputFecha">Fecha</label> <input type="datetime"
						class="form-control" id="inputFecha" name="fecha"
						placeholder="Selcciona una fecha">
				</div>

				<div class="form-group">
					<label for="inputHoraPartida">Hora Partida</label> <input
						name="partida" type="time" class="form-control"
						id="inputHoraPartida" placeholder="Hora de Partida">
				</div>

				<div class="form-group">
					<label for="inputHoraRegreso">Hora Regreso</label> <input
						name="regreso" type="time" class="form-control"
						id="inputHoraRegreso" placeholder="Hora de Regreso">
				</div>

				<div class="form-group">
					<label for="inputDireccionDesde">Dirección Desde</label> <input
						type="text" class="form-control" id="inputDireccionDesde"
						name="desde" placeholder="Ingresa la dirección de partida">
				</div>

				<div class="form-group">
					<label for="inputDireccionHasta">Dirección Hasta</label> <input
						type="text" class="form-control" id="inputDireccionHasta"
						name="hasta" placeholder="Ingresa la dirección del destino ">
				</div>
				<div class="form-group">
					<label for="asientosDisponibles">Asientos disponibles</label> <input
						name="asientos" type="text" class="form-control"
						id="asientosDisponibles"
						placeholder="Cantidad de asientos disponibles">
				</div>
				<!-- /.col-lg-6 -->
				<button type="submit"
					class=" btn btn-primary btn-lg btn btn-success">Submit</button>
			</s:form>
			<s:fielderror />

		</div>

	</div>
	<t:footer></t:footer>

</t:base>