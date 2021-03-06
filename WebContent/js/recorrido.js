


$(document).ready(function(){ 
	var PAGINA_ACTUAL = 1;	
	
	var completar_listar_recorridos = function(json){
		 $('#recorrido-list').empty();
		 for(var a=0; data.data!=null && a<data.data.length;a++){
			 var source   = $("#recorrido-template").html();
			 var template = Handlebars.compile(source);
			 var html    = template(data.data[a]);
			 $('#recorrido-list').append(html);
		 }
		if(data.data!=null && data.data.length!=0){
			$('#input-paginador').empty();
			var source   = $("#paginador-template").html();
			var template = Handlebars.compile(source);
			var html    = template(data.input);
			$('#input-paginador').append(html);
		}
		}
	
	$.fn.extend({
		getRecorridos: function (pagina) {
			$.post('getRecorridosPaginados',{pagina : pagina,paginas : $("input[name=paginas]").val()},function(jsonData,status){
				 var data = JSON.parse(jsonData);
				
				completar_lista_recorridos(data);
				
				// Pasar a otro template de paginador

//				PAGINA_ACTUAL = data.paginaActual;
//				ULTIMA_PAGINA = data.ultima;
			});
	    return pagina;
	    }
	});
	
	$('body').on("click","#filtrar-votos",function(){	
		$.post('filtradoVoto',{paginas : $("input[name=paginas]").val()},function(jsonData,status){
			 var data = JSON.parse(jsonData);
			 $('#recorrido-list').empty();
			 for(var a=0; data.data!=null && a<data.data.length;a++){
				 var source   = $("#recorrido-template").html();
				 var template = Handlebars.compile(source);
				 var html    = template(data.data[a]);
				 $('#recorrido-list').append(html);
			 }
			if(data.data!=null && data.data.length!=0){
				$('input-paginador').empty();
				var source   = $("#paginador-template").html();
				var template = Handlebars.compile(source);
				var html    = template(data.input);
				$('#input-paginador').append(html);
			}
			
			
			// Pasar a otro template de paginador

//			PAGINA_ACTUAL = data.paginaActual;
//			ULTIMA_PAGINA = data.ultima;
		});
	});
	
	$('body').on("click",".paginar",function(){	
		$().getRecorridos($(this).attr('pagina'));
		//Actualizo pagina actual.
		PAGINA_ACTUAL = $(this).attr('pagina');
	});
	
	
	$("#reco-filter").keypress(function (e) {
        if (e.keyCode == 13) {
        	$.post('getRecorridosPaginados',{pagina : pagina,paginas : $("input[name=paginas]").val(), filtro : 'direccion' , palabra : $("#reco-filter").val()},function(jsonData,status){
				 var data = JSON.parse(jsonData);
				
				completar_lista_recorridos(data);
				
			});
        }
    });
	
	
	
});

function do_inicializar(){
	$().getRecorridos(1);
}
