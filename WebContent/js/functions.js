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
		$('#listFechas').append('<li><select></select> vs <select></select> <button id="eliminarFecha">eliminar</button></li>');
	});
	$('body').on("click","#filtrar-votos",function(){	
		$.get('filtradoVoto',function(jsonData,status){
		 var data = JSON.parse(jsonData);
		 for(var a=0; data.recorridos!=null && a<data.recorridos.length;a++){
			 
		 }
	    	
	    });
	});
	
});