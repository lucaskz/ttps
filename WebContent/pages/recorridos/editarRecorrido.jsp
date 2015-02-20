<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
	<t:header user="${usrLogin}" />
	<!-- Home news -->


	<div class="container ">
		<div class="row">
			<div class="col-sm-9 col-md-12">
				<img alt=""
					src="${pageContext.request.contextPath}/retrieveImage?imageId=${evento.foto.id}" />
			</div>
		</div>
		<div class="row">
			<div class="col-sm- col-md-6">
				<h3>${evento.fecha}</h3>
			</div>
			<div class="col-sm- col-md-6">
				<h3>${evento.hora}</h3>
			</div>
		</div>
		<div class="row">
			<div class="col-sm- col-md-6">
				<h3>${evento.direccion}</h3>
			</div>
			<div class="col-sm- col-md-6">
				<h2>${evento.ciudad}</h2>
			</div>
		</div>
		<s:fielderror />
	</div>
	<!-- end Home news -->
	<t:footer />
</t:base>