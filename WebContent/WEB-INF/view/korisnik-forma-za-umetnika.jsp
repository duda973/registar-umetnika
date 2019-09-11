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
				<form:hidden path="ime" />
				<form:hidden path="prezime" />

				<div class="row">
					<div class="col-25">
						<label class="" for="username">Username</label>
					</div>
					<div class="col-75">
						<form:input required="required" path="username" type="username"
							cssClass="form-control" autocomplete="false" placeholder="Username.." />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="" for="password">Password</label>
					</div>
					<div class="col-75">
						<form:password required="required" path="password" autocomplete="false" cssClass="form-control" placeholder="Sifra.."/>
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="" for="email">Email</label>
					</div>
					<div class="col-75">
						<form:input path="email" required="required" cssClass="form-control" placeholder="Email.."/>
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="" for="uloga">Uloga</label>
					</div>
					<div class="col-75">
						<form:select required="required" path="uloga" cssClass="form-control text-center">
							<form:options items="${uloge}" itemLabel="nazivUloge"
								itemValue="ulogaId" class="form-control text-center" selected="selected" />
						</form:select>
					</div>
				</div>

				<label class="" for="submit"></label>
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
