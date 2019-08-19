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
							<i class="fa fa-book small-icons bk-color-blue"></i> Lista
							kulturnih podrucja
						</h1>

						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th class='text-center'>Naziv podrucja</th>
									<th class='text-center'>Umetnicko</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="trenutnoPodrucje" items="${podrucja}">
									<c:url var="obrisiLink"
										value="/administracija/kulturna-podrucja/obrisi-kulturno-podrucje">
										<c:param name="podrucjeId"
											value="${trenutnoPodrucje.podrucjeId}" />
									</c:url>
									<c:url var="udruzenjaLink"
										value="/administracija/kulturna-podrucja/udruzenja">
										<c:param name="podrucjeId"
											value="${trenutnoPodrucje.podrucjeId}" />
									</c:url>

									<tr onclick="window.location='${udruzenjaLink}';">
										<td>${trenutnoPodrucje.nazivPodrucja}</td>
										<td>${trenutnoPodrucje.umetnicko}</td>
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
