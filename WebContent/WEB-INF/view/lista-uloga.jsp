<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
				<i class="fa fa-book"></i> Uloge aplikacije</h1>

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th class='text-center'>Naziv uloge</th>
						<th class='text-center'>Opcije</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="trenutnaUloga" items="${uloge}">
						<c:url var="prikazPoUloziLink"
							value="/administracija/korisnici-po-ulozi">
							<c:param name="ulogaId" value="${trenutnaUloga.ulogaId}" />
						</c:url>
						<tr>
							<td>${trenutnaUloga.nazivUloge}</td>
							<td><a href="${prikazPoUloziLink}">Prikazi korisnike</a></td>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="margintop10">
			<input type="button" value="Svi korisnici"
				class="form-control btn-info text-center"
				onclick="window.location.href='${pageContext.request.contextPath}/administracija/korisnici'; return false;" />
		</div>

	</div>


	<%@ include file="footer.jsp"%>

</body>

</html>
