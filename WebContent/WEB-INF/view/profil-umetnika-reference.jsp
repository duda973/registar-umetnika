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

	<c:url var="uplateLink"
		value="/administracija/umetnici/${umetnik.jmbg}/uplate">
	</c:url>
	<c:url var="referenceLink"
		value="/administracija/umetnici/${umetnik.jmbg}/reference">
	</c:url>
	<c:url var="infoLink" value="/administracija/umetnici/${umetnik.jmbg}">
	</c:url>

	<div class="wrap-pad">
		<div class="container pt-3">
			<div class="row profile">

				<%@ include file="profil-umetnika-import.jsp" %>

				<div class="col-md-9">
					<div class="profile-content">
						<p class="demo naslov">
							<b>Reference</b>
						</p>
						<div style="overflow-x: auto;">
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th>Naziv</th>
										<th>Opis</th>
										<th>Datum</th>
										<th>Odobren</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${reference}" var="trenutnaReferenca">
										<tr>
											<td>${trenutnaReferenca.naziv}</td>
											<td>${trenutnaReferenca.opis}</td>
											<td>${trenutnaReferenca.datum}</td>
											<c:choose>
												<c:when test="${trenutnaReferenca.odobren == 0}">
													<td>Ne</td>
												</c:when>
												<c:otherwise>
													<td>Da</td>
												</c:otherwise>
											</c:choose>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

</body>

</html>
