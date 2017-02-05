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
		<form:form modelAttribute="newPet" class="form-horizontal" enctype="multipart/formdata">
		<form:errors path="*" cssClass="alert alert-danger" element="div"/>
		<a href="<c:url value="/j_spring_security_logout"/>" class="btn btn-danger" style="float: right; align:right;">Wyloguj się</a>
			<fieldset>
				<legend>Dodaj nowego zwierzaka</legend>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="owner"><spring:message code="addPet.label.owner"/></label>
					<div class="col-lg-2">
						<form:select path="owner">
							<c:forEach items="${owners }" var="owner">
								<option value="${owner.ID }">${owner.firstName } ${owner.lastName }</option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="petName"><spring:message code="addPet.label.petName"/></label>
					<div class="col-lg-10">
						<form:input path="petName" id="petName" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					  <label class="control-label col-lg-2 col-lg-2"><spring:message code="addPet.label.animalType"/></label>
					  <div class="col-lg-2">
						  <form:select path="animalType" cssClass="form-control">
						    <option value="<spring:message code="addPet.option.dog"/>"><spring:message code="addPet.option.dog"/></option>
						    <option value="<spring:message code="addPet.option.cat"/>"><spring:message code="addPet.option.cat"/></option>
						    <option value="<spring:message code="addPet.option.hamster"/>"><spring:message code="addPet.option.hamster"/></option>
						    <option value="<spring:message code="addPet.option.parrot"/>"><spring:message code="addPet.option.parrot"/></option>
						  </form:select>
					  </div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-4 col-lg-2" for="birthDate"><spring:message code="addPet.label.birthDate"/></label>
					<div class="col-lg-10">
						<form:input path="birthDate" id="birthDate" type="text" class="form:input-large"/>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value="<spring:message code="addPet.form.submit"/>"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>
	</section>
</body>
</html>