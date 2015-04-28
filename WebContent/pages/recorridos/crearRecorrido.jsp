<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>




<t:base>
	<meta charset="utf-8">
	<style>
html, body, #map-canvas {
	height: 300px;
	margin: 0px;
	padding: 0px;
	margin-bottom: 10px;
}
body {
	padding-top: 60px;
}

</style>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>


	<script>
		var directionsDisplay;
		var directionsService = new google.maps.DirectionsService();

		function initialize() {
			directionsDisplay = new google.maps.DirectionsRenderer();

			var mapOptions = {
				zoom : 4,
				center : new google.maps.LatLng(-25.363882, 131.044922)
			};

			var markers = [];

			var map = new google.maps.Map(
					document.getElementById('map-canvas'), mapOptions);

			directionsDisplay.setMap(map);

			google.maps.event.addListener(map, 'click', function(event) {
				placeMarker(event.latLng);
			});

			function calcRoute() {
				var start = markers[0].getPosition();
				var end = markers[1].getPosition();
				var request = {
					origin : start,
					destination : end,
					travelMode : google.maps.TravelMode.DRIVING
				};
				directionsService.route(request, function(response, status) {
					if (status == google.maps.DirectionsStatus.OK) {
						directionsDisplay.setDirections(response);
					}
				});
			}

			// Sets the map on all markers in the array.
			function setAllMap(map) {
				for (var i = 0; i < markers.length; i++) {
					markers[i].setMap(map);
				}
			}

			// Removes the markers from the map, but keeps them in the array.
			function clearMarkers() {
				setAllMap(null);
			}

			function placeMarker(location) {
				var marker = new google.maps.Marker({
					position : location,
					map : map
				});
				markers.push(marker);
				if (markers.length == 2) {
					clearMarkers();
					calcRoute()
				}
			}
		}

		google.maps.event.addDomListener(window, 'load', initialize);
	</script>

	<t:header user="${usrLogin}" />
	<!-- Home news -->
	<div class="container" style="display: table;">
		<div class="row" style="display: table-row;">
			<t:recorridosSidebar></t:recorridosSidebar>
			<div class="col-sm-9 col-md-11 no-float ">
				<s:form name="alta" action="alta" method="post" role="form">

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
						<label for="inputFecha">Fecha</label> <input type="date"
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
						<label for="asientosDisponibles">Asientos disponibles</label> <input
							name="asientos" type="text" class="form-control"
							id="asientosDisponibles"
							placeholder="Cantidad de asientos disponibles">
					</div>
					
					<div class="form-group">
						<label for="eventoRecorrido">Evento asociado al recorrido</label>
						<s:select name="eventoSeleccionado"  cssClass="form-control" list="opcionEventos" listKey="id" listValue="nombre" />
<!-- 						 <input -->
<!-- 							name="asientos" type="text" class="form-control" -->
<!-- 							id="asientosDisponibles" -->
<!-- 							placeholder="Cantidad de asientos disponibles"> -->
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

					<div id="map-canvas"></div>
					<div id="warnings_panel"
						style="width: 100%; height: 10%; text-align: center"></div>
					<!-- /.col-lg-6 -->
					<button type="submit"
						class=" btn btn-primary btn-lg btn btn-success">Submit</button>
				</s:form>

				<s:fielderror />

			</div>
		</div>

	</div>

	<t:footer></t:footer>

</t:base>