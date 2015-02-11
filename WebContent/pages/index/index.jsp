<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:base>
	
	
	<t:header user="${usrLogin}"  />
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
					<img src="${pageContext.request.contextPath}/img/Google-Maps-logo.jpg" alt="...">
					<div class="carousel-caption">...</div>
				</div>
				<div class="item">
					<img src="${pageContext.request.contextPath}/img/Google-Maps-logo.jpg" alt="...">
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
    
    <div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>Heading</h2>
				<div class="row">
					<div class="col-xs-8 col-sm-6">
						<img src="${pageContext.request.contextPath}/img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"
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
						<img src="${pageContext.request.contextPath}/img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"
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
						<img src="${pageContext.request.contextPath}/img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"
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
						<img src="${pageContext.request.contextPath}/img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"
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
						<img src="${pageContext.request.contextPath}/img/gmap.jpg" alt="gmap.jpg" class="img-thumbnail"
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
    </div>
    
 
    



	<t:footer></t:footer>
</t:base>