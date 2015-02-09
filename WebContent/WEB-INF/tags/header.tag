<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@tag import="clases.Usuario"%>
<%-- <%@attribute name="user" required="true" type="clases.Usuario"%> --%>
<%@attribute name="user" type="clases.Usuario"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- haeder -->
<!--  Nav Bar -->
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">UNLP @ 2015</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="${pageContext.request.contextPath}/">Home</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Eventos
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Crear Evento</a></li>
						<li><a href="#">Listar eventos</a></li>
<!-- 						<li class="divider"></li> -->
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Recorridos
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">Crear Recorrido</a></li>
						<li><a href="#">Listar Recorridos</a></li>
<!-- 						<li class="divider"></li> -->

					</ul></li>
			</ul>
			
			<s:if  test="user eq null">
				<form class="navbar-form navbar-right" role="form" id="autenticar"
					name="autenticar" action="login/autenticar.action" method="post">
	
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
		   </s:if>
		   <s:else>
		   	 <ul  class="navbar-right">
		   	 	<li><a href="#">Mensajes<span class="badge">0</span></a></li>
		   	 </ul>
		   </s:else>
   
		</div>
		<!--/.navbar-collapse -->
	</div>
</div>
<!--  end NavBar-->
<!-- end header -->