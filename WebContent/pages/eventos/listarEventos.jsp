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

<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
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
				<form class="navbar-form navbar-right" role="form" id="autenticar" name="autenticar" action="login/autenticar.action" method="post" >
					
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
	<!--  Slider -->
	<div class="container">
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="img/Google-Maps-logo.jpg" alt="...">
					<div class="carousel-caption">...</div>
				</div>
				<div class="item">
					<img src="img/Google-Maps-logo.jpg" alt="...">
					<div class="carousel-caption">...</div>
				</div>
				...
			</div>

			<!-- Controls -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>
	</div>
	<!--  end Slider -->


	<!-- Home news -->
	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Heading</h2>
				<div class="row">
					<div class="col-xs-8 col-sm-6">
						<img src="img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"
							style="max-height: 140px;">
					</div>
					<div class="col-xs-4 col-sm-6">
						<p>Origen :</p>
						<p>Destino :</p>
					</div>
				</div>


				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<div class="row">
					<div class="col-xs-8 col-sm-6">
						<img src="img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"
							style="max-height: 140px;">
					</div>
					<div class="col-xs-4 col-sm-6">
						<p>Origen :</p>
						<p>Destino :</p>
					</div>
				</div>


				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<div class="row">
					<div class="col-xs-8 col-sm-6">
						<img src="img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"
							style="max-height: 140px;">
					</div>
					<div class="col-xs-4 col-sm-6">
						<p>Origen :</p>
						<p>Destino :</p>
					</div>
				</div>


				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<h2>Heading</h2>
				<div class="row">
					<div class="col-xs-8 col-sm-6">
						<img src="img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"
							style="max-height: 140px;">
					</div>
					<div class="col-xs-4 col-sm-6">
						<p>Origen :</p>
						<p>Destino :</p>
					</div>
				</div>


				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<div class="row">
					<div class="col-xs-8 col-sm-6">
						<img src="img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"
							style="max-height: 140px;">
					</div>
					<div class="col-xs-4 col-sm-6">
						<p>Origen :</p>
						<p>Destino :</p>
					</div>
				</div>


				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Heading</h2>
				<div class="row">
					<div class="col-xs-8 col-sm-6">
						<img src="img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"
							style="max-height: 140px;">
					</div>
					<div class="col-xs-4 col-sm-6">
						<p>Origen :</p>
						<p>Destino :</p>
					</div>
				</div>


				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
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