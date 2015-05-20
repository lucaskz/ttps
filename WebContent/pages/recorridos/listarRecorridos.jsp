<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<script id="recorrido-template" type="text/x-handlebars-template">
<div  class="list-group-item ">
							<div class="row">
								<div class="col-sm-4">
									<h4 class="list-group-item-heading"><s:text name="sidebarRecorrido.seccion.recorrido" /> # {{id}} </h4>
								</div>
							</div>
							<div class="row">
								<div class=" col-sm-1 col-md-1		col-md-offset-2" style="margin-top:10%">
									{{#if participando}}										
											<button class="btn btn-default "  onclick="window.document.location='../recorridos/recorrido?&recorrido={{id}}';"><s:text name="recorrido.lista.verDetalles" /></button>										
									{{else}}
										{{#if pendiente}}
											<button class="btn btn-default "  disabled>
											 <s:text name="recorrido.lista.pendiente" />
											</button>
										{{else}}
											<button class="btn btn-default "  onclick="window.document.location='../recorridos/solicitar?&recorrido={{id}}';">
											 	<s:text name="recorrido.lista.unirse" />
											</button>
										{{/if}}
									{{/if}}
								</div>
								<div class="col-sm-2">
									{{#if map}}
										<img src="http://maps.googleapis.com/maps/api/staticmap?size=200x200&path=weight:3|color:blue|enc:{{polygon}}&markers=color:red|label:Llegada|{{endA}},{{endF}}&markers=color:red|label:Partida|{{startA}},{{startF}}" />
									{{/if}}
								</div>
								<div class=" col-sm-3 col-md-3		col-md-offset-1" style="margin-top:5%">
									<h4><s:text name="recorrido.lista.horaPartida" />{{horaPartida}} </h4>
									<h4><s:text name="recorrido.lista.horaRegreso" />{{horaRegreso}}</h4>										
								</div>
								<div class="col-md-1">
									{{#if calificado}}
										<button class="btn btn-default btn btn-default" disabled ><s:text name="recorrido.lista.yaCalificado" /></button>
									{{else}}
											{{#if puedeCalificar}}
													<button class="btn btn-default btn btn-success"  onclick="window.document.location='../recorridos/upVote?&recorrido={{id}}';">
														<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>
													</button>
											{{/if}}
									{{/if}}
								</div>
								<div class="col-md-2 ">
									 {{#if denunciado}}
										 	<button  class="btn btn-default" disabled><s:text name="recorrido.lista.yaDenunciado" /></button>	
								 	{{else}}										
											<button class="btn btn-default"  onclick="window.document.location='../recorridos/denunciar?&idRecorrido={{id}}';"> <s:text name="recorrido.lista.denunciar" /></button>	
									{{/if}}
								</div>
							</div>
							<div class="row">
								<div	class="col-sm-3 col-md-3			col-md-offset-6">
									 
								</div>
								<div class="col-md-1 ">
										{{#if calificado}}
										{{else}}
											{{#if puedeCalificar}}
													<button type="button" class="btn btn-default  btn-danger" onclick="window.document.location='../recorridos/downVote?&recorrido={{id}}';" aria-label="Left Align">
													  <span class="glyphicon glyphicon-download" aria-hidden="true"></span>
													</button>
											{{/if}}
										{{/if}}
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									<s:text name="recorrido.form.asientos" />: {{asientos}}
								</div>								
							</div>
</div>
</script>
<script id="paginador-template" type="text/x-handlebars-template">
				<ul class="pagination">
					{{#if primera}}
					{{else}}
	  				<li><a href="#" id="ant-pagina" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
					{{/if}}
					{{#paginador paginas}}{{/paginador}}
				  {{#if ultima}}
					{{else}}
	  				<li><a href="#" id="sig-pagina" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
					{{/if}}						
				</ul>
</script>
<t:base>
	<t:header user="${usrLogin}" />
	<!-- Home news -->
	<div class="container " style="display: table;">
		<div class="row" style="display: table-row;">

			<t:recorridosSidebar></t:recorridosSidebar>

			<div class="col-sm-9 col-md-11 no-float ">
				<div class="row">
					<div class="col-md-4 col-md-offset-1">
						<label class="control-label"># Recorridos</label>
						<label class="radio-inline"> <input type="radio" name="paginas"  value="5" checked> 5 </label>
      		  <label class="radio-inline"> <input type="radio" name="paginas"  value="10"> 10 </label>
       			 <label class="radio-inline"> <input type="radio" name="paginas"  value="15" > 15 </label>
					</div>				
					<div class="col-md-2 ">
						<button class="btn btn-default" id="filtrar-votos" type="button">Mas Votados</button>
					</div>
					<div class="col-md-2 ">
						<button class="btn btn-default" id="filtrar-pasajeros" type="button">Mas Pasajeros</button>
					</div>
				</div>
				<div class="row list-group" id="recorrido-list">
				</div>
				<nav class="text-center" id="input-paginador">
				
				</nav>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function initialize(){
		 do_inicializar();
		}
	
	
	</script>

	<!-- end Home news -->
	<t:footer />
</t:base>