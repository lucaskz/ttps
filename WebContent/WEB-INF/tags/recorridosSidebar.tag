<%@tag description="Recorridos sidebar" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-2 col-md-2 sidebar no-float">
	<ul class="nav nav-sidebar">
		<li class=" <s:if test="#session.accion == 'listar'"> active </s:if> "><a href="${pageContext.request.contextPath}/recorridos/listar"><s:text name="sidebarRecorrido.seccion.recorridos" /></a></li>
	</ul>
	<s:if test="#session.status == 'autenticado'">
		<ul class="nav nav-sidebar">
			<li
				class=" <s:if test="#session.accion == 'misRecorridos'"> active </s:if> "><a
				href="${pageContext.request.contextPath}/recorridos/misRecorridos"><s:text name="sidebarRecorrido.seccion.misRecorridos" /></a></li>
		</ul>

		<ul class="nav nav-sidebar">
			<li
				class=" <s:if test="#session.accion == 'registrar'"> active </s:if> "><a
				href="${pageContext.request.contextPath}/recorridos/registrar"><s:text name="sidebarRecorrido.seccion.crearRecorrido" /></a></li>
		</ul>
		<ul class="nav nav-sidebar">
			<li
				class=" <s:if test="#session.accion == 'solicitudes'"> active </s:if> "><a
				href="${pageContext.request.contextPath}/recorridos/solicitudes"><s:text name="sidebarRecorrido.seccion.solicitudes" /></a></li>
		</ul>
	</s:if>
</div>