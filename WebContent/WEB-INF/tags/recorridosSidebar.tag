<%@tag description="Recorridos sidebar" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="col-sm-2 col-md-2 sidebar no-float">
	<ul class="nav nav-sidebar">
		<li class=" <s:if test="#session.accion == 'listar'"> active </s:if> "><a
			href="${pageContext.request.contextPath}/recorridos/listar">Recorridos
		</a></li>
	</ul>
	<s:if test="#session.status == 'autenticado'">
		<ul class="nav nav-sidebar">
			<li
				class=" <s:if test="#session.accion == 'misRecorridos'"> active </s:if> "><a
				href="${pageContext.request.contextPath}/recorridos/misRecorridos">Mis
					Recorridos</a></li>
		</ul>

		<ul class="nav nav-sidebar">
			<li
				class=" <s:if test="#session.accion == 'registrar'"> active </s:if> "><a
				href="${pageContext.request.contextPath}/recorridos/registrar">Crear
					Recorrido</a></li>
		</ul>
	</s:if>
</div>