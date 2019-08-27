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
							<i class="fa fa-book small-icons bk-color-blue"></i> Lista umetnika
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
									<c:url var="izmeniLink" value="/administracija/umetnici/izmeni-umetnika">
										<c:param name="umetnikID"
											value="${trenutniUmetnik.umetnikId}" />
									</c:url>
									<c:url var="obrisiLink" value="/administracija/umetnici/obrisi-umetnika">
										<c:param name="umetnikID"
											value="${trenutniUmetnik.umetnikId}" />
									</c:url>
									<c:url var="udruzenjeLink" value="/administracija/umetnici/prikaz">
										<c:param name="umetnikID"
											value="${trenutniUmetnik.umetnikId}" />
									</c:url>

									<tr onclick="window.location='${umetnikLink}';">
										<td>${trenutniUmetnik.ime}</td>
										<td>${trenutniUmetnik.prezime}</td>
										<td>${trenutniUmetnik.jmbg}</td>
										<td><a href="${obrisiLink}"></a>Obrisi</td>
									<tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<sec:authorize access="hasAuthority('Superadmin')">
						<div class="margintop10">
							<input type="button" value="Dodaj novog umetnika"
								class="form-control btn-info text-center"
								onclick="window.location.href='${pageContext.request.contextPath}/administracija/umetnici/dodaj-novog-umetnika'; return false;"
								/>
						</div>
						<div class="margintop10">
							<input type="button" value="Svi umetnici"
								class="form-control btn-info text-center"
								onclick="window.location.href='${pageContext.request.contextPath}/administracija/umetnici'; return false;" />
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
