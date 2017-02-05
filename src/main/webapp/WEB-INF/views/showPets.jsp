<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Wykaz zwierząt</title>
</head>
<body>
	<section class="container">
		<div class="row">
			<c:forEach items="${pets}" var="pet">
				<div class="col-sm-3 col-md-3">
					<div class="thumbnail">
						<div class="caption">
							<h3>Imie: ${pet.petName }</h3>
							<p>Gatunek: ${pet.animalType }</p>
							<p>Data urodzenia: ${pet.birthDate }</p>
							<p>Właściciel: ${pet.owner.firstName } ${pet.owner.lastName }</p>
							<p>
								<a href="<spring:url value="/pets/edit?ID=${pet.ID }"/>" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span> Edytuj</a>
								<a href="<spring:url value="/pets/remove?ID=${pet.ID }"/>" class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span> Usuń</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div> 
	</section>
</body>
</html>