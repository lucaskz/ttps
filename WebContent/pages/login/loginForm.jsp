<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:base>
	
	<div class="container">
	
		<form id="autenticar" name="autenticar" action="${pageContext.request.contextPath}/login/autenticar.action" method="post" class="form-signin">
	
			<h2 class="form-signin-heading"><s:text name="login.form.title" /></h2>
			<label for="inputEmail" class="sr-only"><s:text name="login.form.mail" /></label>
			<input name="email" type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required autofocus>
			<label for="inputPassword" class="sr-only"><s:text name="login.form.password" /></label>
			<input name="password" type="password" id="inputPassword"
				class="form-control" placeholder="Password" required>
	
			<button class="btn btn-lg btn-primary btn-block btn-success" type="submit"><s:text name="boton.ingresar" /></button>
		</form>
	
	</div>
	<t:footer></t:footer>
</t:base>
