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
				<i class="fa fa-book"></i> Kulturna podrucja</h1>

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th class='text-center'>Naziv podrucja</th>
						<th class='text-center'>Umetnicko</th>
						<th class='text-center'>Opcije</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="trenutnoPodrucje" items="${podrucja}">
						<c:url var="obrisiLink"
							value="/administracija/kulturna-podrucja/obrisi-kulturno-podrucje">
							<c:param name="podrucjeId" value="${trenutnoPodrucje.podrucjeId}" />
						</c:url>
						<c:url var="udruzenjaLink"
							value="/administracija/kulturna-podrucja/udruzenja">
							<c:param name="podrucjeId" value="${trenutnoPodrucje.podrucjeId}" />
						</c:url>

						<tr onclick="window.location='${udruzenjaLink}';">
							<td>${trenutnoPodrucje.nazivPodrucja}</td>
							<td>${trenutnoPodrucje.umetnicko}</td>
							<td><a href="${obrisiLink}">Obrisi</a></td>
						<tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<sec:authorize access="hasAuthority('Superadmin')">
			<div class="margintop10">
				<input type="button" value="Dodaj novo kulturno podrucje"
					class="form-control btn-info text-center"
					onclick="window.location.href='${pageContext.request.contextPath}/administracija/kulturna-podrucja/dodaj-novo-kulturno-podrucje'; return false;" />
			</div>
			<div class="margintop10">
				<input type="button" value="Sva kulturna podrucja"
					class="form-control btn-info text-center"
					onclick="window.location.href='${pageContext.request.contextPath}/administracija/kulturna-podrucja'; return false;" />
			</div>
		</sec:authorize>

	</div>


	<%@ include file="footer.jsp"%>

	
</body>

</html>
