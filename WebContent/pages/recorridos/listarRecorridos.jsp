<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<script id="recorrido-template" type="text/x-handlebars-template">
<div  class="list-group-item ">
							<div class="row">
								<div class="col-sm-4">
									<h4 class="list-group-item-heading">Recorrido # {{id}} </h4>
								</div>
							</div>
							<div class="row">
								<div class=" col-sm-2 col-md-2		col-md-offset-2">
									{{#if participando}}
										<button class="btn btn-default "  disabled>
											 Participando
										</button>
									{{else}}
										{{#if pendiente}}
											<button class="btn btn-default "  disabled>
											 Pendiente
											</button>
										{{else}}
											<button class="btn btn-default "  onclick="window.document.location='../recorridos/solicitar?&recorrido={{id}}';">
											 	Unirse
											</button>
										{{/if}}
									{{/if}}
								</div>
								<div class=" col-sm-3 col-md-3		col-md-offset-1">
									Hora Partida:{{horaPartida}}
								</div>
								<div class="col-md-1">
									{{#if calificado}}
										<button class="btn btn-default btn btn-default" disabled >Ya calificado</button>
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
										 	<button  class="btn btn-default" disabled>Ya denunciado!</button>	
								 	{{else}}										
											<button class="btn btn-default"  onclick="window.document.location='../recorridos/denunciar?&idRecorrido={{id}}';"> Denunciar</button>	
									{{/if}}
								</div>
							</div>
							<div class="row">
								<div	class="col-sm-3 col-md-3			col-md-offset-5">
									Hora Regreso:{{horaRegreso}} 
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
									Asientos: {{asientos}}
								</div>
								
							</div>

</div>
</script>
<script id="paginador-template" type="text/x-handlebars-template">			
			<nav class="text-center">
				<ul class="pagination">
					<li><a href="#" class="ant-pagina" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a>
					</li>
					 {{#each comments}}
						<li><a class="paginar" pagina="{{pagina}}" href="#">{{pagina}}</a></li>
					 {{/each}}
					<li><a href="#" class="sig-pagina" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</ul>
			</nav>
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
					<s:iterator value="recorridos" var="rActual">
						<div  class="list-group-item ">
							<div class="row">
								<div class="col-sm-4">
									<h4 class="list-group-item-heading">Recorrido #<s:property value="#rActual['id']"/></h4>
								</div>
							</div>
							<div class="row">
								<div class=" col-sm-2 col-md-2		col-md-offset-2">
									<s:if test="#rActual['participando'] == 'true'" >
										<button class="btn btn-default "  onclick="window.document.location='../recorridos/recorrido?&recorrido=<s:property value="#rActual['id']"/>';">
											 Detalles
										</button>
									</s:if>
									<s:elseif test="#rActual['pendiente'] == 'true'">
											<button class="btn btn-default "  disabled>
											 Pendiente
											</button>
									</s:elseif>
									<s:else>
											<button class="btn btn-default "  onclick="window.document.location='../recorridos/solicitar?&recorrido=<s:property value="#rActual['id']"/>';">
											 	Unirse
											</button>
									</s:else>
								</div>
								<div class=" col-sm-3 col-md-3		col-md-offset-1">
									Hora Partida:<s:property value="#rActual['horaPartida']"/>
								</div>
								<div class="col-md-1">
									<s:if test="#rActual['calificado'] == 'true'" >
										<button class="btn btn-default btn btn-default" disabled >Ya calificado</button>
									</s:if>
											<s:elseif  test="#rActual['puedeCalificar'] == 'true'">
													<button class="btn btn-default btn btn-success"  onclick="window.document.location='../recorridos/upVote?&recorrido=<s:property value="#rActual['id']"/>';">
														<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>
													</button>
											</s:elseif>
								</div>
								<div class="col-md-2 ">
									<s:if test="#rActual['denunciado'] == 'true'" >
										 	<button  class="btn btn-default" disabled>Ya denunciado!</button>	
									</s:if>
									<s:else>									
											<button class="btn btn-default"  onclick="window.document.location='../recorridos/denunciar?&idRecorrido=<s:property value="#rActual['id']"/>';"> Denunciar</button>	
									</s:else>
								</div>
							</div>
							<div class="row">
								<div	class="col-sm-3 col-md-3			col-md-offset-5">
									Hora Regreso:<s:property value="#rActual['horaRegreso']"/>
								</div>
								<div class="col-md-1 ">
								<s:if test="#rActual['calificado'] == 'true'" >
								</s:if>
									<s:elseif  test="#rActual['puedeCalificar'] == 'true'">
														<button type="button" class="btn btn-default  btn-danger" onclick="window.document.location='../recorridos/downVote?&recorrido=<s:property value="#rActual['id']"/>';" aria-label="Left Align">
													  <span class="glyphicon glyphicon-download" aria-hidden="true"></span>
													</button>
									</s:elseif>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									Asientos: <s:property value="#rActual['asientos']"/>
								</div>
								
							</div>

					</div>
					</s:iterator>
					<s:iterator value="misRecorridos">
						<a href="#" class="list-group-item ">
							<div class="row">
								<div class="col-sm-4">
									<h4 class="list-group-item-heading">Recorrido # <s:property value="id"/> </h4>
								</div>
							</div>

							<div class="row">
								<div class=" col-sm-3 col-md-3		col-md-offset-5">
									Hora Partida:<s:property value="horaPartida"/>
								</div>
							</div>
							<div class="row">
								<div	class="col-sm-3 col-md-3			col-md-offset-5">
									Hora Regreso:<s:property value="horaRegreso"/> 
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									Asientos: <s:property value="asientos"/>
								</div>
								
							</div>
		
						</a>
					</s:iterator>
				</div>
				<nav class="text-center">
					<ul class="pagination">
						<li><a href="#" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>

	<!-- end Home news -->
	<t:footer />
</t:base>