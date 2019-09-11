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
				<i class="fa fa-book"></i>Udruzenje forma
			</h1>

			<form:form action="odaberi-kulturna-podrucja"
				modelAttribute="udruzenje" method="POST" class="mt-3">
				<form:hidden path="udruzenjeId" />
				<form:hidden path="korisnik.korisnikId" />

				<div class="row">
					<div class="col-25">
						<label class="" for="maticniBroj">Maticni broj</label>
					</div>
					<div class="col-75">
						<form:input required="required" path="maticniBroj" cssClass="form-control" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="" for="pib">PIB</label>
					</div>
					<div class="col-75">
						<form:input required="required" path="pib" cssClass="form-control" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="" for="naziv">Naziv</label>
					</div>
					<div class="col-75">
						<form:input required="required" path="naziv" cssClass="form-control" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="" for="sediste">Sediste</label>
					</div>
					<div class="col-75">
						<form:input required="required" path="sediste" cssClass="form-control" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="" for="adresa">Adresa</label>
					</div>
					<div class="col-75">
						<form:input required="required" path="adresa" cssClass="form-control" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="" for="datumOsnivanja">Datum
							osnivanja</label>
					</div>
					<div class="col-75">
						<form:input required="required" type="date" path="datumOsnivanja"
							cssClass="form-control" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="" for="zastupnik">Zastupnik</label>
					</div>
					<div class="col-75">
						<form:input required="required" path="zastupnik" cssClass="form-control" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label class="" for="registarskibroj">Registarski
							broj</label>
					</div>
					<div class="col-75">
						<form:input required="required" path="registarskiBroj" cssClass="form-control" />
					</div>
				</div>

				<label class="margintop10" for="submit"></label>
				<input type="submit" name="pocni" value="Nastavi dalje"
					class="form-control btn-success mb-3 text-center">
			</form:form>
		</div>

		<div class="mb-4 mt-3">
			<input type="button" value="Odustani"
				class="form-control btn-info text-center"
				onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja'; return false;" />
		</div>

	</div>


	<%@ include file="footer.jsp"%>

</body>

</html>
