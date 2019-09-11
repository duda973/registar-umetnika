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

	<div class="wrap-pad">
		<p class="demo naslov">
			<b>UNOS NOVE REFERENCE</b>
		</p>
		<p style="text-align: center">Popunite podatke</p>

		<div class="container">
			<form:form action="sacuvaj-novu-referencu" modelAttribute="referenca"
				method="POST">
				<form:hidden path="referencaId" />

				<div class="row">
					<div class="col-25">
						<label for="Naziv">Naziv</label>
					</div>
					<div class="col-75">
						<form:input required="required" type="text" path="naziv" cssClass="form-control"
							placeholder="Naziv reference.." />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label for="datum">Datum</label>
					</div>
					<div class="col-75">
						<form:input required="required" path="datum" type="date" cssClass="form-control" />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label for="opis">Opis</label>
					</div>
					<div class="col-75">
						<form:textarea required="required" path="opis" placeholder="Opis.."
							style="height: 200px"></form:textarea>
					</div>
				</div>

				<div class="row">
					<label class="margintop10" for="submit"></label> <input
						type="submit" name="pocni" value="Potvrdi"
						class="form-control btn-primary btn-xl">
				</div>
				<div class="row">
					<input type="button" value="Odustani"
						class="form-control btn-info text-center"
						onclick="window.location.href='${pageContext.request.contextPath}/administracija/umetnici'; return false;" />
				</div>
			</form:form>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

</body>

</html>
