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
						<h2>
							<i class="fa fa-book small-icons bk-color-blue"></i>
							${udruzenje.naziv}
						</h2>
					</div>

					<h2>Osnovne informacije</h2>
					<h4>Datum osnivanja: ${udruzenje.datumOsnivanja}</h4>
					<ul>
						<div class="row">
							<div class="col-lg-6">
								<li><span>Registarski broj </span>${udruzenje.registarskiBroj}</li>
								<li><span>Maticni broj </span>${udruzenje.maticniBroj}</li>
								<li><span>PIB </span>${udruzenje.pib}</li>
							</div>
							<div class="col-lg-6">
								<li><span>Adresa </span>${udruzenje.adresa}</li>
								<li><span>Zastupnik </span>${udruzenje.zastupnik}</li>
								<li><span>Sediste </span>${udruzenje.sediste}</li>
							</div>
						</div>
					</ul>
					<div class="row">
						<div class="col-lg-4 text-center">Naziv podrucja</div>
						<div class="col-lg-4 text-center">Datum unosa</div>
						<div class="col-lg-4 text-center">Opcije</div>
					</div>
					<c:forEach var="trenutnoPodrucje" items="${podrucjaKojimaPripada}">
						<c:url var="obrisiLink" value="/administracija/udruzenja/obrisi-kulturno-podrucje-udruzenju">
							<c:param name="udruzenjeId"
								value="${udruzenje.udruzenjeId}" />
							<c:param name="podrucjeId"
								value="${trenutnoPodrucje.podrucjeId}" />
						</c:url>
						<div class="row">
							<div class="col-lg-4 text-center">${trenutnoPodrucje.nazivPodrucja}</div>
							<c:forEach var="trenutnaPripadnost" items="${pripadnosti}">
								<c:if test="${trenutnaPripadnost.udruzenje.udruzenjeId == udruzenje.udruzenjeId && trenutnaPripadnost.kulturnoPodrucje.podrucjeId == trenutnoPodrucje.podrucjeId}">
									<div class="col-lg-4 text-center">${trenutnaPripadnost.datumUnosa}</div>
								</c:if>
							</c:forEach>
							<div class="col-lg-4 text-center">
							<sec:authorize access="hasAuthority('Superadmin')">
								<a href="${obrisiLink}">Obrisi</a>
							</sec:authorize>
							</div>
						</div>
					</c:forEach>
					<div class="margintop10">
						<div class="row">
							<div class="col-lg-3">
								<input type="button" value="Dodaj kulturno podrucje"
									class="form-control btn-info text-center"
									onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja/dodaj-kulturno-podrucje?udruzenjeID=${udruzenje.udruzenjeId}'; return false;" />
							</div>
							<div class="col-lg-3">
								<input type="button" value="Izmeni podatke"
									class="form-control btn-info text-center"
									onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja/izmeni-udruzenje?udruzenjeID=${udruzenje.udruzenjeId}'; return false;" />
							</div>
							<div class="col-lg-3">
								<input type="button" value="Obrisi udruzenje"
									class="form-control btn-info text-center"
									onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja/obrisi-udruzenje?udruzenjeID=${udruzenje.udruzenjeId}'; return false;" />
							</div>
							<div class="col-lg-3">
								<input type="button" value="Sva udruzenja"
									class="form-control btn-info text-center"
									onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja'; return false;" />
							</div>
						</div>
					</div>
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
