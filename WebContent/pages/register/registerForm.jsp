<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap 101 Template</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
<style>
  body {
    padding-top: 60px;
  }
  @media (max-width: 980px) {
    body {
      padding-top: 0;
    }
  }
</style>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

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
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="form">
					<div class="form-group">
						<input type="text" placeholder="Email" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>
	<!--  end NavBar-->




	<!-- Home news -->
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-6 col-md-offset-1">
				<s:form  name="register" action="register" method="post" role="form">
					<div class="form-group">
						<label for="inputName">Nombre</label> <input
							type="text" class="form-control" id="inputName" name="nombre"
							placeholder="Ingresa tu nombre">
					</div>
					<div class="form-group">
						<label for="inputApellido">Apellido</label> <input
							type="text" class="form-control" id="inputApellido" name="apellido"
							placeholder="Ingresa tu apellido">
					</div>
					<div class="form-group">
						<label for="inputTelefono">Teléfono</label> <input
							type="text" class="form-control" id="inputTelefono" name="telefono"
							placeholder="Ingresa tu teléfono">
					</div>
					<div class="form-group">
						<label for="inputEmail">Dirección de Correo</label> <input name="email"
							type="email" class="form-control" id="inputEmail"
							placeholder="Ingresa tu email">

					</div>
					<div class="form-group">
						<label for="inputPassword">Password</label> <input name="password"
							type="password" class="form-control" id="inputPassword"
							placeholder="Password">
					</div>

					<div class="checkbox">
						<label> <input type="checkbox"> Check me out
						</label>
					</div>
					<button type="submit" class=" btn btn-primary btn-lg btn btn-success">Submit</button>
				</s:form>
			</div>
			<div class="col-md-4 ">
								<div class="form-group">
						<label for="exampleInputFile">Foto Personal</label> <input
							type="file" id="exampleInputFile">
						<p class="help-block">Suba su foto personal para el sitio.</p>
					</div>
			</div>
			<div class="col-md-4 ">
				<img src="photo.jpg" alt="..." class="img-thumbnail" style="max-height: 290px"">
			</div>

		</div>


		<!-- end Home news -->

		<hr>

		<footer>
			<p>&copy; Company 2014</p>
		</footer>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>