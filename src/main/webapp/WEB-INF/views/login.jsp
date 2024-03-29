<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Produkty</title>
</head>
<body>

	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Zaloguj się</h3>
						</div>
						<div class="panel-body">
							<c:if test="${not empty error }">
								<div class="alert alert-danger">
									Wprowadzono niepoprawny login lub hasło
								</div>
							</c:if>
							
							<form action="<c:url value="j_spring_security_check"></c:url>" method="post">
								<fieldset>
									<div class="form-group">
										<input class="form-control" placeholder="Nazwa użytkownika" name="j_username" type="text"/>
									</div>
									
									<div class="form-group">
										<input class="form-control" placeholder="Hasło" name="j_password" type="password" value=""/>
									</div>
									
									<input class="btn btn-lg btn-success btn-block" type="submit" value="Zaloguj się"/>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>