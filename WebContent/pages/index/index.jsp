<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
	
	
	<t:header user="${usrLogin}"  />
    	<!--  Slider -->
	<div class="container">
		<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="${pageContext.request.contextPath}/img/Google-Maps-logo.jpg" alt="...">
					<div class="carousel-caption">...</div>
				</div>
				<div class="item">
					<img src="${pageContext.request.contextPath}/img/Google-Maps-logo.jpg" alt="...">
					<div class="carousel-caption">...</div>
				</div>
				...
			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	<!--  end Slider -->
    
    <div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<s:iterator value="recorridos" var="rActual">
			<div class="col-md-4">
				<h2><s:text name="sidebarRecorrido.seccion.recorrido" /> # <s:property value="id"/></h2>
				<div class="row">
					<div class="col-xs-8 col-sm-6">
						<s:if test="#rActual.polygon != null">
							<img src="http://maps.googleapis.com/maps/api/staticmap?size=140x140&path=weight:3|color:blue|enc:<s:property value="polygon"/>&markers=color:red|label:Llegada|<s:property value="endA"/>,<s:property value="endF"/>&markers=color:red|label:Partida|<s:property value="startA"/>,<s:property value="startF"/>" />
						</s:if>
						<s:else>
							<img src="${pageContext.request.contextPath}/img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"	style="max-height: 140px;">
						</s:else>
						
						
					</div>
					<div class="col-xs-4 col-sm-6">
						<p><s:text name="recorrido.form.direccionDesde" /> : <s:property value="direccionDesde"/></p>
						<p><s:text name="recorrido.form.direccionHasta" /> : <s:property value="direccionHasta"/></p>
						<p><s:text name="recorrido.lista.pasajeros" /> :  <s:property value="rActual.pasajeros.size()"/></p>
					</div>
				</div>


				<p>
					<a class="btn btn-default"  href="${pageContext.request.contextPath}/recorridos/listar" role="button" ><s:text name="recorrido.lista.verDetalles" />	&raquo;</a>
				</p>
			</div>
			</s:iterator>
		</div>
		<!-- end Home news -->
    </div>
    
 
    



	<t:footer></t:footer>
</t:base>