<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<li class="active"><a href="<spring:url value="/"/>" >Strona Główna</a></li>
<li><a href="<spring:url value="/owners/add"/>">Dodaj nowego klienta</a></li>
<li><a href="<spring:url value="/owners/all"/>" >Pokaż klientów</a></li>
<li><a href="<spring:url value="/pets/add"/>">Dodaj nowego zwierzaka</a></li>
<li><a href="<spring:url value="/pets/all"/>" >Pokaż zwierzaki</a></li>