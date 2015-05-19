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
	
	Handlebars.registerHelper('paginador', function(paginas, options) {
		  var out = ""; 
		  for(var i=1, l=paginas+1; i<l; i++) {
			out +='<li><a class="paginar" pagina="'+i+'" href="#">'+i+'</a></li>';
		  }
		  return out;
		});
	
	$('#agergarFecha').click(function(){
		$('#listFechas').append('<li><select></select> vs <select></select> <button id="eliminarFecha">eliminar</button></li>');
	});
	$('body').on("click","#filtrar-votos",function(){	
		$.get('filtradoVoto',function(jsonData,status){
		 var data = JSON.parse(jsonData);
		 $('#recorrido-list').empty();
		 for(var a=0; data!=null && a<data.length;a++){
			 var source   = $("#recorrido-template").html();
			 var template = Handlebars.compile(source);
			 var html    = template(data[a]);
			 $('#recorrido-list').append(html);
		 }
	    	
	    });
	});
	

	$('body').on("click","#cancelar-recorrido",function(){	 
		$('#cancelar-recorrido-form').submit();
	});
	
	$('body').on("click","#spanish",function(){	   	
		$('#locale').val('es_SP');
		$('#idioma').submit();
	});
	
	$('body').on("click","#english",function(){	
		$('#locale').val('en_US');
		$('#idioma').submit();
	});
	
	$('body').on("click","#deshabilitar-usuario",function(){	
		var r = confirm("¿Està seguro que desea deshabilitar el usuario?");
		if(r==true){
			$(this).prop('disabled', true);
			$.post('deshabilitar',{usuario : $(this).attr('usuario')},function(jsonData,status){ 				
			});
		}	    	
	  
	});
	

	$('body').on("click","#btn-crear-rec",function(){	    	
		$('#polygon').val(polygon);
		$('#startA').val(startFinal.A);
		$('#startF').val(startFinal.F);
		$('#endA').val(endFinal.A);
		$('#endF').val(endFinal.F);
		$('#alta-reco').submit();
	});
	
});