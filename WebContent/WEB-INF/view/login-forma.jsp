<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Registar samostalnih umetnika</title>
<%@ include file="import-header.jsp"%>
</head>

<body>
	<%@ include file="header.jsp"%>

	<div class="wrap-pad container">
		<div class="text-center">

			<h1>
				<i class="fa fa-book small-icons bk-color-blue"></i>Login forma
			</h1>
			<c:url var="loginUrl" value="/login" />
			<form:form method="POST" action="${loginUrl}">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">
						<p>Pogresno uneti podaci</p>
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success">
						<p>Uspesno ste se izlogovali</p>
					</div>
				</c:if>
				<label for="username">Username</label>
				<input type="text" name="username" class="form-control"
					placeholder="Unesite username" />
				<label for="password">Password</label>
				<input type="password" name="password" class="form-control"
					placeholder="Unesite sifru">
				<label for="submit"></label>

				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<input type="submit" name="login" value="Log in"
					class="form-control btn-info mt-2 text-center">
			</form:form>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>

</html>
