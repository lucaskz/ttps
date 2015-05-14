<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<script id="entry-template" type="text/x-handlebars-template">
<div  class="list-group-item ">
							<div class="row">
								<div class="col-sm-4">
									<h4 class="list-group-item-heading">Recorrido #{{recorrido}} </h4>
								</div>
							</div>

							<div class="row">
								<div class=" col-sm-2 col-md-2		col-md-offset-2">
									<button class="btn btn-default "  onclick="window.document.location='../recorridos/solicitar?&recorrido={{recorrido}}';">
											Unirse
									</button>
								</div>
								<div class=" col-sm-3 col-md-3		col-md-offset-1">
									Hora Partida:{{horaPartida}}
								</div>
								<div class="col-md-1">
									<s:if test="{{calificar}} == 'true'" >
										<button class="btn btn-default btn btn-success"  onclick="window.document.location='../recorridos/upVote?&recorrido={{recorrido}}';">
											<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>
										</button>
									</s:if>
								</div>
								<div class="col-md-2 ">
									<s:if test="{{denunciado}} == 'false'" >
										<button class="btn btn-default"  onclick="window.document.location='../recorridos/denunciar?&idRecorrido={{recorrido}}';"> Denunciar</button>
									</s:if>
									<s:else>
										<button  class="btn btn-default" disabled>Ya denunciado!</button>
									</s:else>
								</div>
							</div>
							<div class="row">
								<div	class="col-sm-3 col-md-3			col-md-offset-5">
									Hora Regreso:{{horaRegreso}} 
								</div>
								<div class="col-md-1 ">
									<s:if test="{{calificar}} == 'true'" >
										<button type="button" class="btn btn-default  btn-danger"   onclick="window.document.location='../recorridos/downVote?&recorrido={{recorrido}}';" aria-label="Left Align">
											  <span class="glyphicon glyphicon-download" aria-hidden="true"></span>
										</button>
									</s:if>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									Asientos: {{asientos}}
								</div>
								
							</div>
						
						<s:if test="{{calificar}} == 'true'" >
							<button class="btn btn-default" reco="{{recorrido}}" > Up </button>
							<button class="btn btn-default" reco="{{recorrido}}" > Down </button>
						</s:if>

</div>
</script>
<t:base>
	<t:header user="${usrLogin}" />
	<!-- Home news -->
	<div class="container " style="display: table;">
		<div class="row" style="display: table-row;">

			<t:recorridosSidebar></t:recorridosSidebar>

			<div class="col-sm-9 col-md-11 no-float ">

				<div class="list-group">
					<s:iterator value="recorridos" var="rActual">
						<div  class="list-group-item ">
							<div class="row">
								<div class="col-sm-4">
									<h4 class="list-group-item-heading">Recorrido #<s:property value="#rActual['id']"/> </h4>
								</div>
							</div>

							<div class="row">
								<div class=" col-sm-2 col-md-2		col-md-offset-2">
									<button class="btn btn-default "  onclick="window.document.location='../recorridos/solicitar?&recorrido=<s:property value="#rActual['id']"/>';">
											Unirse
									</button>
								</div>
								<div class=" col-sm-3 col-md-3		col-md-offset-1">
									Hora Partida:<s:property value="#rActual['horaPartida']"/>
								</div>
								<div class="col-md-1">
									<s:if test="#rActual['calificar'] == 'true'" >
										<button class="btn btn-default btn btn-success"  onclick="window.document.location='../recorridos/upVote?&recorrido=<s:property value="#rActual['id']"/>';">
											<span class="glyphicon glyphicon-upload" aria-hidden="true"></span>
										</button>
									</s:if>
								</div>
								<div class="col-md-2 ">
									<s:if test="#rActual['denunciado'] == 'false'" >
										<button class="btn btn-default"  onclick="window.document.location='../recorridos/denunciar?&idRecorrido=<s:property value="#rActual['id']"/>';"> Denunciar</button>
									</s:if>
									<s:else>
										<button  class="btn btn-default" disabled>Ya denunciado!</button>
									</s:else>
								</div>
							</div>
							<div class="row">
								<div	class="col-sm-3 col-md-3			col-md-offset-5">
									Hora Regreso:<s:property value="#rActual['horaRegreso']"/> 
								</div>
								<div class="col-md-1 ">
									<s:if test="#rActual['calificar'] == 'true'" >
										<button type="button" class="btn btn-default  btn-danger"   onclick="window.document.location='../recorridos/downVote?&recorrido=<s:property value="#rActual['id']"/>';" aria-label="Left Align">
											  <span class="glyphicon glyphicon-download" aria-hidden="true"></span>
										</button>
									</s:if>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									Asientos: <s:property value="#rActual['asientos']"/>
								</div>
								
							</div>
						
						<s:if test="#rActual['calificar'] == 'true'" >
							<button class="btn btn-default" reco="<s:property value="#rActual['id']"/>" > Up </button>
							<button class="btn btn-default" reco="<s:property value="#rActual['id ']"/>" > Down </button>
						</s:if>

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