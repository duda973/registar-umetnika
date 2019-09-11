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
				<i class="fa fa-book"></i> Udruzenja
			</h1>

			<table class="table table-hover">
				<thead class="thead-dark">
					<tr>
						<th class='text-center'>Naziv</th>
						<th class='text-center'>Maticni broj</th>
						<th class='text-center'>PIB</th>
						<th class='text-center'>Registarski broj</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="trenutnoUdruzenje" items="${udruzenja}">
						<c:url var="izmeniLink"
							value="/administracija/udruzenja/izmeni-udruzenje">
							<c:param name="udruzenjeId"
								value="${trenutnoUdruzenje.udruzenjeId}" />
						</c:url>
						<c:url var="obrisiLink"
							value="/administracija/udruzenja/obrisi-udruzenje">
							<c:param name="udruzenjeID"
								value="${trenutnoUdruzenje.udruzenjeId}" />
						</c:url>
						<c:url var="udruzenjeLink"
							value="/administracija/udruzenja/${trenutnoUdruzenje.pib}">
						</c:url>

						<tr onclick="window.location='${udruzenjeLink}';">
							<td><strong>${trenutnoUdruzenje.naziv}</strong></td>
							<td>${trenutnoUdruzenje.maticniBroj}</td>
							<td>${trenutnoUdruzenje.pib}</td>
							<td>${trenutnoUdruzenje.registarskiBroj}</td>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<sec:authorize access="hasAuthority('Superadmin')">
			<div class="margintop10">
				<input type="button" value="Dodaj novo udruzenje"
					class="form-control btn-info text-center"
					onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja/dodaj-novo-udruzenje'; return false;" />
			</div>
			<div class="margintop10">
				<input type="button" value="Sva udruzenja"
					class="form-control btn-info text-center"
					onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja'; return false;" />
			</div>
		</sec:authorize>

	</div>


	<%@ include file="footer.jsp"%>

	
</body>

</html>
