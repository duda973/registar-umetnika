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
				<i class="fa fa-book small-icons bk-color-brown"></i>Kulturno
				podrucje forma
			</h1>

			<form:form action="sacuvaj-kulturno-podrucje"
				modelAttribute="podrucje" method="POST">
				<form:hidden path="podrucjeId" />

				<label class="margintop10" for="nazivPodrucja">Naziv
					kulturnog podrucja</label>
				<form:input required="required" path="nazivPodrucja" cssClass="form-control" />

				<label class="margintop10" for="uloga">Da li je umetnicko?</label>
				<form:radiobutton path="umetnicko" id="da" value="da" />
				<form:radiobutton path="umetnicko" id="ne" value="ne" />

				<label class="margintop10" for="submit"></label>
				<input type="submit" value="Sacuvaj kulturno podrucje"
					class="form-control btn-success mb-3 text-center">
			</form:form>
		</div>

		<div class="mb-4 mt-3">
			<input type="button" value="Odustani"
				class="form-control btn-info text-center"
				onclick="window.location.href='${pageContext.request.contextPath}/administracija/kulturna-podrucja'; return false;" />
		</div>

	</div>


	<%@ include file="footer.jsp"%>

</body>

</html>
