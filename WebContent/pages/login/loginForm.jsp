<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>



<t:base>
	
	<div class="container">
	
		<form id="autenticar" name="autenticar" action="${pageContext.request.contextPath}/login/autenticar.action" method="post" class="form-signin">
	
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input name="email" type="email" id="inputEmail" class="form-control"
				placeholder="Email address" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input name="password" type="password" id="inputPassword"
				class="form-control" placeholder="Password" required>
	
			<button class="btn btn-lg btn-primary btn-block btn-success" type="submit">Sign
				in</button>
		</form>
		<s:fielderror />
	
	</div>
	<t:footer></t:footer>
</t:base>
