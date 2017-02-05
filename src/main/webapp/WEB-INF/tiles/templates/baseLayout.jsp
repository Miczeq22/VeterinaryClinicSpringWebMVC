<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width = device-width, initialscale = 1.0">
<link rel="stylesheet" href="http://getbootstrap.com/dist/css/bootstrap.css">
<link rel="stylesheet" href="http://getbootstrap.com/examples/jumbotron/jumbotron.css">
<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
	
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<tiles:insertAttribute name="navigation"/>
				</ul>
			</div>
		</div>
	</nav>	

	<div class="container">
		<div class="jumbotron">
			<h1><tiles:insertAttribute name="heading"/></h1>
			<p><tiles:insertAttribute name="tagline"/></p>
		</div>
		<div class="row">
			<tiles:insertAttribute name="content"/>
		</div>
		<footer class="footer">
			<div class="container" style="padding-top: 60px;">
				<tiles:insertAttribute name="footer"/>
			</div>
		</footer>
	</div>
</body>
</html>