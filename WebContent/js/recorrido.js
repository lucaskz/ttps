

$(document).ready(function(){ 
	var PAGINA_ACTUAL = 1;
	var ULTIMA_PAGINA = 1;
	
	dataPaginada.put("siguiente",paginador.getNextPage());
	dataPaginada.put("anterior", paginador.getPreviousPage());
	dataPaginada.put("primeraVentana", paginador.getMinPageRange());
	//Ultima pagina	
	dataPaginada.put("ultimaVentana", paginador.getMaxPageRange());			
	//Paginas disponibles		
	dataPaginada.put("ultima", (paginador.getMaxPages()<1) ? 1 : paginador.getMaxPages() );
	//En que pagina estoy actualmente
	dataPaginada.put("paginaActual", paginador.getPage());
	dataPaginada.put("elementos", elementos);
	//Devuelve los inputs que determinan la cantidad de elementos por pagina
	dataPaginada.put("input",getInputPaginador(elementos,cantPaginas));
	dataPaginada.put("data",paginador.getListForPage());
	
	
	
	var getRecorridos = function(pagina){
		$.post('getRecorridos',function(jsonData,status){
			 var data = JSON.parse(jsonData);
			 $('#recorrido-list').empty();
			 for(var a=0; data.elementos!=null && a<data.elementos.length;a++){
				 var source   = $("#recorrido-template").html();
				 var template = Handlebars.compile(source);
				 var html    = template(data.elementos[a]);
				 $('#recorrido-list').append(html);
			 }
			$('#input_paginador').empty();
			$('#input_paginador').prepend(data.input);
			$('#paginador_cert').empty();
			
			
			// Pasar a otro template de paginador

			PAGINA_ACTUAL = data.paginaActual;
			ULTIMA_PAGINA = data.ultima;
		});
	};
	
	getRecorridos();
	
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
	
});