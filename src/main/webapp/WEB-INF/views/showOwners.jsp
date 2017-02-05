<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

</head>
<body>
	<section class="container">
		<div class="row">
			<c:forEach items="${owners}" var="owner">
				<div class="col-sm-6 col-md-6" style="padding-bottom: 10px">
					
					<div class="thumbnail">
						<div class="caption">
							<img src="<c:url value="/resource/images/avatar.jpg"></c:url>" alt="image" style=" width:30%; align: right; float: right; padding-bottom: 30px"/>
							<h3>Imie: ${owner.firstName }</h3>
							<h3>Nazwisko: ${owner.lastName }</h3>
							<p>Miasto: ${owner.city }</p>
							<p>Adres: ${owner.address }</p>
							<p>Numer telefonu: ${owner.phoneNumber }</p>
							<p>
								<a href="<spring:url value="/owners/edit?ID=${owner.ID }"/>" class="btn btn-primary"><span class="glyphicon glyphicon-trash"></span> Edytuj</a>
								<a href="<spring:url value="/owners/remove?ID=${owner.ID }"/>" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span> Usuń</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>