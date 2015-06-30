<%@tag description="Recorridos sidebar" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-2 col-md-2 sidebar no-float" >
	<ul class="nav nav-sidebar">
		<li class=" <s:if test="#session.accion == 'recibidos'"> active </s:if> "><a href="${pageContext.request.contextPath}/mensajes/recibidos"><s:text name="sidebarMensaje.seccion.recibidos" /></a></li>
	</ul>
	<ul class="nav nav-sidebar">
		<li class=" <s:if test="#session.accion == 'enviados'"> active </s:if> "><a
			href="${pageContext.request.contextPath}/mensajes/enviados"><s:text name="sidebarMensaje.seccion.enviados" /></a></li>
	</ul>
	<ul class="nav nav-sidebar">
		<li class=" <s:if test="#session.accion == 'redactar'"> active </s:if> "><a
			href="${pageContext.request.contextPath}/mensajes/redactar"><s:text name="sidebarMensaje.seccion.redactar" /></a></li>
	</ul>

</div>