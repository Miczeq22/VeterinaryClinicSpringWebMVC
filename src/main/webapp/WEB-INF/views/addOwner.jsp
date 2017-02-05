<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<section class="container">	
		<form:form modelAttribute="newOwner" class="form-horizontal" enctype="multipart/form-data">
			<form:errors path="*" cssClass="alert alert-danger" element="div"/>
			<a href="<c:url value="/j_spring_security_logout"/>" class="btn btn-danger" style="float: right; align:right;">Wyloguj się</a>
			<fieldset>
				<legend>Dodaj nowego klienta</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="firstName">Imie: </label>
						<div class="col-lg-10">
							<form:input id="firstName" path="firstName" type="text" class="form:input-large"/>
							<form:errors path="firstName" cssClass="text-danger"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-2 col-lg-2" for="lastName">Nazwisko: </label>
						<div class="col-lg-10">
							<form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
							<form:errors path="lastName" cssClass="text-danger"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-4 col-lg-2" for="city">Miasto: </label>
						<div class="col-lg-10">
							<form:input id="city" path="city" type="text" class="form:input-large"/>
							<form:errors path="city" cssClass="text-danger"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-4 col-lg-2" for="address">Adres: </label>
						<div class="col-lg-10">
							<form:input id="address" path="address" type="text" class="form:input-large"/>
							<form:errors path="address" cssClass="text-danger"/>
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-lg-4 col-lg-2" for="phoneNumber">Telefon: </label>
						<div class="col-lg-10">
							<form:input id="phoneNumber" path="phoneNumber" type="tel" class="form:input-large" pattern="[0-9]{9}" maxlength="9"/>
							<form:errors path="phoneNumber" cssClass="text-danger"/>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-lg-offset-2 col-lg-10">
							<input type="submit" id="btnAdd" class="btn btn-primary" value ="Dodaj"/>
						</div>
					</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>