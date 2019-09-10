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
				<i class="fa fa-book"></i> Korisnik forma
			</h1>

			<form:form action="sacuvaj-korisnika" modelAttribute="korisnik"
				method="POST">
				<form:hidden path="korisnikId" />

				<label class="margintop10" for="ime">Ime</label>
				<form:input path="ime" cssClass="form-control" />

				<label class="margintop10" for="prezime">Prezime</label>
				<form:input path="prezime" cssClass="form-control" />

				<label class="margintop10" for="username">Username</label>
				<form:input path="username" type="username" cssClass="form-control" />

				<label class="margintop10" for="password">Password</label>
				<form:password path="password" cssClass="form-control" />

				<label class="margintop10" for="email">Email</label>
				<form:input path="email" cssClass="form-control" />

				<label class="margintop10" for="uloga">Uloga</label>
				<form:select path="uloga" cssClass="form-control text-center">
					<form:options items="${uloge}" itemLabel="nazivUloge"
						itemValue="ulogaId" class="form-control text-center" />
				</form:select>

				<label class="margintop10" for="submit"></label>
				<input type="submit" value="Sacuvaj korisnika"
					class="form-control btn-success text-center mb-3">
			</form:form>
			
			<div class="mb-4 mt-3">
				<input type="button" value="Odustani"
					class="form-control btn-info text-center"
					onclick="window.location.href='${pageContext.request.contextPath}/administracija/korisnici'; return false;" />
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

	
</body>

</html>
