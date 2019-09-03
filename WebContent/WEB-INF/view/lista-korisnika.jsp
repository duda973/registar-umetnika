<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

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
							<i class="fa fa-book small-icons bk-color-blue"></i>Korisnici
							aplikacije
						</h1>

						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th class='text-center'>Ime</th>
									<th class='text-center'>Prezime</th>
									<th class='text-center'>Username</th>
									<sec:authorize access="hasAuthority('Superadmin')">
										<th class='text-center' style='width: 20%;'>Password</th>
									</sec:authorize>
									<th class='text-center'>Email</th>
									<th class='text-center'>Uloga</th>
									<sec:authorize access="hasAuthority('Superadmin')">
										<th class='text-center'>Opcije</th>
									</sec:authorize>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="trenutniKorisnik" items="${korisnici}">
									<c:url var="izmeniLink" value="/administracija/korisnici/izmeni-korisnika">
										<c:param name="korisnikId"
											value="${trenutniKorisnik.korisnikId}" />
									</c:url>
									<c:url var="obrisiLink" value="/administracija/korisnici/obrisi-korisnika">
										<c:param name="korisnikId"
											value="${trenutniKorisnik.korisnikId}" />
									</c:url>
									<tr>
										<td>${trenutniKorisnik.ime}</td>
										<td>${trenutniKorisnik.prezime}</td>
										<td>${trenutniKorisnik.username}</td>
										<sec:authorize access="hasAuthority('Superadmin')">
											<td style='width: 20%;'>********</td>
										</sec:authorize>
										<td>${trenutniKorisnik.email}</td>
										<td>${trenutniKorisnik.uloga.nazivUloge}</td>
										<sec:authorize access="hasAuthority('Superadmin')">
											<td><a href="${izmeniLink}">Izmeni</a> | <a
												href="${obrisiLink}">Obrisi</a></td>
										</sec:authorize>
									<tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<sec:authorize access="hasAuthority('Superadmin')">
						<div class="margintop10">
							<input type="button" value="Dodaj korisnika"
								class="form-control btn-info text-center"
								onclick="window.location.href='${pageContext.request.contextPath}/administracija/korisnici/dodaj-novog-korisnika'; return false;"
								/>
						</div>
						<div class="margintop10">
							<input type="button" value="Uloge"
								class="form-control btn-info text-center"
								onclick="window.location.href='${pageContext.request.contextPath}/administracija/korisnici/uloge'; return false;" />
						</div>
						<div class="margintop10">
							<input type="button" value="Svi korisnici"
								class="form-control btn-info text-center"
								onclick="window.location.href='${pageContext.request.contextPath}/administracija/korisnici'; return false;" />
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
