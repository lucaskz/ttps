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
</style>
	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>


	<script>
		var map;
		var markers = [];
		var directionsDisplay ;
		var directionsService = new google.maps.DirectionsService();
		function initialize() {
			directionsDisplay = new google.maps.DirectionsRenderer();
			var mapOptions = {
				zoom : 8,
				center : new google.maps.LatLng(-34.397, 150.644)
			};
			map = new google.maps.Map(document.getElementById('map-canvas'),
					mapOptions);

			google.maps.event.addListener(map, 'click', function(event) {
				addMarker(event.latLng);
			});

		}

		function addMarker(location) {
			if (markers.length < 2) {
				var marker = new google.maps.Marker({
					position : location,
					map : map
				});
				markers.push(marker);
			
			}else{
				calcRoute();
			}
		}

		function calcRoute() {
			var start = new google.maps.LatLng(markers[0].position.lat(),markers[0].position.lng());
		        //var end = new google.maps.LatLng(38.334818, -181.884886);
		    var end = new google.maps.LatLng(markers[1].position.lat(),markers[1].position.lng());

			var request = {
				origin : start,
				destination : end,
				travelMode : google.maps.TravelMode.DRIVING
			};
			directionsService.route(request, function(result, status) {
			    if (status == google.maps.DirectionsStatus.OK) {
			      directionsDisplay.setDirections(result);
			    }
			  });
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
						<label for="asientosDisponibles">Asientos disponibles</label> <input
							name="asientos" type="text" class="form-control"
							id="asientosDisponibles"
							placeholder="Cantidad de asientos disponibles">
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
					<div id="warnings_panel" style="width:100%;height:10%;text-align:center"></div>
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