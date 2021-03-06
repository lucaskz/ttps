<%@ tag language="java" pageEncoding="UTF-8"%>
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
				<li class="<s:if test="#session.seccion == 'index'"> active </s:if>"><a
					href="${pageContext.request.contextPath}/"><s:text name="header.seccion.home" /></a></li>
				<li
					class="dropdown <s:if test="#session.seccion == 'eventos'"> active </s:if> "><a
					href="#" class="dropdown-toggle" data-toggle="dropdown"
					role="button" aria-expanded="false"><s:text name="header.seccion.eventos" /><span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<s:if test="#session.perfil == 'administrador' ">
							<li><a
								href="${pageContext.request.contextPath}/eventos/crearEvento"><s:text name="header.seccion.crearEvento" /></a></li>
						</s:if>						
						<li><a href="${pageContext.request.contextPath}/eventos/listarEventos"><s:text name="header.seccion.listarEvento" /></a></li>
						<!-- 						<li class="divider"></li> -->
					</ul></li>
				<li
					class="dropdown <s:if test="#session.seccion == 'recorridos'"> active </s:if> "><a
					href="#" class="dropdown-toggle" data-toggle="dropdown"
					role="button" aria-expanded="false"><s:text name="header.seccion.recorridos" /> <span
						class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<s:if test="#session.status == 'autenticado'">
							<li><a
								href="${pageContext.request.contextPath}/recorridos/registrar"><s:text name="header.seccion.crearRecorridos" /></a></li>
						</s:if>
						<li><a
							href="${pageContext.request.contextPath}/recorridos/listar"><s:text name="header.seccion.listarRecorridos" /></a></li>
						<!-- 						<li class="divider"></li> -->

					</ul></li>
				<s:if test="#session.perfil == 'administrador' ">
					<li
						class="<s:if test="#session.seccion == 'administracion'"> active </s:if>"><a
						href="${pageContext.request.contextPath}/admin/"><s:text name="header.seccion.administracion" /></a></li>
				</s:if>
				<s:if test="#session.status != 'autenticado' ">
					<li
						class="<s:if test="#session.seccion == 'registro'"> active </s:if>"><a
						href="${pageContext.request.contextPath}/registro"><s:text name="header.seccion.registrarse" /></a></li>

				</s:if>
				<li style="padding-left:5px">
					<s:form action="idioma" name="idioma" id="idioma">
						<input type="hidden" name="locale" id="locale" value=""/>
						<a class="navbar-brand" id="spanish" href="#">
	       			 <img alt="Brand" height="20" width="40" src="${pageContext.request.contextPath}/img/spanish_flag.png">
	     			</a>
	     			<a class="navbar-brand" id="english" href="#">
	       			 <img alt="Brand" height="20" width="40" src="${pageContext.request.contextPath}/img/english_flag.png">
	     			</a>
					</s:form>
				</li>
			</ul>


			<s:if test="#session.status == 'autenticado'">
				<ul class="nav navbar-nav navbar-right">
					<li><a><img
							src="${pageContext.request.contextPath}/retrieveImage?imageId=${avatar }"
							style="max-width: 32px; max-height: 32px; width: auto; border-radius: 3px; border: 0;" /></a></li>
					<li><a href="#">Bienvenido, ${user.nombre }</a></li>
					<li><a
						href="${pageContext.request.contextPath}/mensajes/recibidos"><s:text name="header.mensaje.mensajes" /><span
							class="badge">${noLeidos}</span></a></li>
					<li><a href="${pageContext.request.contextPath}/logout"><s:text name="header.seccion.logout" /></a></li>

				</ul>

			</s:if>
			<s:else>
				<form id="autenticar" name="autenticar"
					action="${pageContext.request.contextPath}/login/autenticar.action"
					method="post" class="navbar-form navbar-right" role="form">

					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control"
							name="email">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" name="password"
							class="form-control">
					</div>
					<button type="submit" class="btn btn-success"><s:text name="header.seccion.login" /></button>
				</form>
			</s:else>

		</div>
		<!--/.navbar-collapse -->
	</div>
</div>
<!--  end NavBar-->
<!-- end header -->