<%@tag description="Recorridos sidebar" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-2 col-md-2 sidebar no-float" >
	<ul class="nav nav-sidebar">
		<li class=" <s:if test="#session.accion == 'usuarios'"> active </s:if> "><a href="${pageContext.request.contextPath}/admin/"><s:text name="header.seccion.usuarios" /></a></li>
	</ul>
	<ul class="nav nav-sidebar">
		<li class=" <s:if test="#session.accion == 'denuncias'"> active </s:if> "><a
			href="${pageContext.request.contextPath}/admin/denuncias/"><s:text name="usuario.tabla.denuncias" /></a></li>
	</ul>
	<ul class="nav nav-sidebar">
		<li class=" <s:if test="#session.accion == 'eventos'"> active </s:if> "><a
			href="${pageContext.request.contextPath}/admin/eventos"><s:text name="header.seccion.eventos" /></a></li>
	</ul>


</div>