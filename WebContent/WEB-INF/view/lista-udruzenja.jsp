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
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css'>
<link
	href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/assets/css/prettyPhoto.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/assets/css/style.css"
	rel="stylesheet" />
</head>

<body>
	<%@ include file="header.jsp"%>

	<section id="about-section">
		<div class="wrap-pad">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 ">
					<div class="text-center">
						<h1>
							<i class="fa fa-book small-icons bk-color-blue"></i> Lista udruzenja
						</h1>

						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th class='text-center'>Maticni broj</th>
									<th class='text-center'>PIB</th>
									<th class='text-center'>Naziv</th>
									<th class='text-center'>Sediste</th>
									<th class='text-center'>Adresa</th>
									<th class='text-center'>Datum osnivanja</th>
									<th class='text-center'>Podrucje</th>
									<th class='text-center'>Zastupnik</th>
									<sec:authorize access="hasAuthority('Superadmin')">
										<th class='text-center'>Opcije</th>
									</sec:authorize>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="trenutnoUdruzenje" items="${udruzenja}">
									<c:url var="izmeniLink" value="/administracija/udruzenja/izmeni-udruzenje">
										<c:param name="udruzenjeId"
											value="${trenutnoUdruzenje.udruzenjeId}" />
									</c:url>
									<c:url var="obrisiLink" value="/administracija/udruzenja/obrisi-udruzenje">
										<c:param name="udruzenjeID"
											value="${trenutnoUdruzenje.udruzenjeId}" />
									</c:url>
									<c:url var="clanoviLink" value="/administracija/udruzenja/clanovi">
										<c:param name="udruzenjeID"
											value="${trenutnoUdruzenje.udruzenjeId}" />
									</c:url>

									<tr onclick="window.location='${clanoviLink}';">
										<td>${trenutnoUdruzenje.maticniBroj}</td>
										<td>${trenutnoUdruzenje.pib}</td>
										<td>${trenutnoUdruzenje.naziv}</td>
										<td>${trenutnoUdruzenje.sediste}</td>
										<td>${trenutnoUdruzenje.adresa}</td>
										<td>${trenutnoUdruzenje.datumOsnivanja}</td>
										<td>${trenutnoUdruzenje.kulturnoPodrucje.nazivPodrucja}</td>
										<td>${trenutnoUdruzenje.zastupnik}</td>
										<sec:authorize access="hasAuthority('Superadmin')">
											<td><a href="${izmeniLink}">Izmeni</a> | <a
												href="${obrisiLink}">Obrisi</a>
												</td>
										</sec:authorize>
									<tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<sec:authorize access="hasAuthority('Superadmin')">
						<div class="margintop10">
							<input type="button" value="Dodaj novo udruzenje"
								class="form-control btn-info text-center"
								onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja/dodaj-novo-udruzenje'; return false;"
								/>
						</div>
						<div class="margintop10">
							<input type="button" value="Svi korisnici"
								class="form-control btn-info text-center"
								onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja'; return false;" />
						</div>
					</sec:authorize>

				</div>

			</div>
		</div>
	</section>

	<%@ include file="footer.jsp"%>

	<script
		src="${pageContext.request.contextPath}/resources/assets/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/jquery.prettyPhoto.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/js/scrollReveal.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/assets/scripts/custom.js"></script>
</body>

</html>
