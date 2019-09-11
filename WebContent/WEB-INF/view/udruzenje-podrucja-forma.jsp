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
				<i class="fa fa-book small-icons bk-color-brown"></i>Udruzenje forma
			</h1>

			<form:form action="odaberi-kulturna-podrucja"
				modelAttribute="novaPripadnost" method="POST">
				<label class="margintop10">Selektuj kulturno podrucje</label>
				<form:select required="required" path="kulturnoPodrucje"
					cssClass="form-control text-center">
					<form:options items="${podrucja}" itemLabel="nazivPodrucja"
						itemValue="podrucjeId" cssClass="form-control text-center" />
				</form:select>

				<label class="margintop10" for="datumUnosa">Datum unosa</label>
				<form:input required="required" type="date" path="datumUnosa" cssClass="form-control" />

				<label class="margintop10" for="submit"></label>
				<input type="submit" name="dalje"
					value="Unesi novo kulturno podrucje"
					class="form-control btn-info mb-3 text-center">
				<input type="submit" name="odustani" value="Odustani"
					class="form-control btn-warning mb-3 text-center">
				<input type="submit" name="sacuvaj" value="Sacuvaj novo udruzenje"
					class="form-control btn-success mb-4 text-center">

			</form:form>
		</div>
	</div>


	<%@ include file="footer.jsp"%>

</body>

</html>
