<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<section class="container">
		<form:form modelAttribute="petToEdit" class="form-horizontal" enctype="multipart/formdata">
		<a href="<c:url value="/j_spring_security_logout"/>" class="btn btn-danger" style="float: right; align:right;">Wyloguj się</a>
			<fieldset>
				<legend>Edytuj istniejącego zwierzaka</legend>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="owner">Właściciel: </label>
					<div class="col-lg-2">
						<form:select path="owner">
							<c:forEach items="${owners }" var="owner">
								<option value="${owner.ID }">${owner.firstName } ${owner.lastName }</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="petName">Imie: </label>
					<div class="col-lg-10">
						<form:input path="petName" id="petName" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					  <label class="control-label col-lg-2 col-lg-2">Gatunek: </label>
					  <div class="col-lg-2">
						  <form:select path="animalType" cssClass="form-control">
						    <option value="Pies">Pies</option>
						    <option value="Kot">Kot</option>
						  </form:select>
					  </div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4 col-lg-2" for="birthDate">Data urodzenia: </label>
					<div class="col-lg-10">
						<form:input path="birthDate" id="birthDate" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="Edytuj"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>