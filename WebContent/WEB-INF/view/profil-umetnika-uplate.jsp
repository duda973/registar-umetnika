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
							<b>UPLATE</b>
						</p>
						<div style="overflow-x: auto;">
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th>Osnovica</th>
										<th>Zdravstveno</th>
										<th>Penziono i invalidsko</th>
										<th>Datum</th>
										<th>Organ uplate</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${uplate}" var="trenutnaUplata">
										<tr>
											<td>${trenutnaUplata.osnovica}</td>
											<td>${trenutnaUplata.zdravstveno}</td>
											<td>${trenutnaUplata.penzionoInvalidsko}</td>
											<td>${trenutnaUplata.datumUplate}</td>
											<td>${trenutnaUplata.organ.naziv}</td>
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
