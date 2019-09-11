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
				<i class="fa fa-book"></i> Umetnici
			</h1>

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th class='text-center'>Ime</th>
						<th class='text-center'>Prezime</th>
						<th class='text-center'>JMBG</th>
						<th class='text-center'>Opcije</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="trenutniUmetnik" items="${umetnici}">
						<c:url var="izmeniLink"
							value="/administracija/umetnici/izmeni-podatke">
							<c:param name="jmbg" value="${trenutniUmetnik.jmbg}" />
						</c:url>
						<c:url var="obrisiLink"
							value="/administracija/umetnici/obrisi-umetnika">
							<c:param name="umetnikID" value="${trenutniUmetnik.umetnikId}" />
						</c:url>
						<c:url var="umetnikLink"
							value="/administracija/umetnici/${trenutniUmetnik.jmbg}">
						</c:url>

						<tr onclick="window.location='${umetnikLink}';">
							<td>${trenutniUmetnik.ime}</td>
							<td>${trenutniUmetnik.prezime}</td>
							<td>${trenutniUmetnik.jmbg}</td>
							<td><a href="${obrisiLink}">Obrisi</a> | <a
								href="${izmeniLink}">Izmeni</a></td>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<sec:authorize access="hasAuthority('Superadmin')">
			<div class="margintop10">
				<input type="button" value="Dodaj novog umetnika"
					class="form-control btn-info text-center"
					onclick="window.location.href='${pageContext.request.contextPath}/administracija/umetnici/dodaj-novog-umetnika'; return false;" />
			</div>
			<div class="margintop10">
				<input type="button" value="Svi umetnici"
					class="form-control btn-info text-center"
					onclick="window.location.href='${pageContext.request.contextPath}/administracija/umetnici'; return false;" />
			</div>
		</sec:authorize>
	</div>

	<%@ include file="footer.jsp"%>

	
</body>

</html>
