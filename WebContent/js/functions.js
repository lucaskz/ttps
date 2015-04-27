/**
 * 
 */

function PreviewImage() {
	var oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById("inputFile").files[0]);

	oFReader.onload = function(oFREvent) {
		document.getElementById("uploadPreview").src = oFREvent.target.result;
	};
};


$(document).ready(function(){ 
	
	$('#agergarFecha').click(function(){
		$('#listFechas').append('<li><select></select> vs <select></select> <button id="eliminarFecha">eliminar</button></li>')
	});
	
});