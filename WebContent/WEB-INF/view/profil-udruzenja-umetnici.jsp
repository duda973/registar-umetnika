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

	<c:url var="umetniciLink"
		value="/administracija/udruzenja/${udruzenje.pib}/umetnici">
	</c:url>
	<c:url var="infoLink"
		value="/administracija/udruzenja/${udruzenje.pib}">
	</c:url>
	<c:url var="podrucjaLink"
		value="/administracija/udruzenja/${udruzenje.pib}/kulturna-podrucja">
	</c:url>

	<div class="wrap-pad">
		<div class="container pt-3">
			<div class="row profile">

				<div class="col-md-3">
					<div class="profile-sidebar text-center">
						<div class="profile-userpic">
							<img
								src="https://static.change.org/profile-img/default-user-profile.svg"
								class="img-responsive" alt="">
						</div>

						<div class="profile-usertitle">
							<div class="profile-usertitle-name">${udruzenje.naziv}
								${umetnik.prezime}</div>
						</div>

						<div class="profile-userbuttons">
							<button
								onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja/izmeni-udruzenje?udruzenjeID=${udruzenje.udruzenjeId}'; return false;"
								type="button" class="btn btn-primary btn-sm">Izmeni
								podatke</button>
							<button
								onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja/obrisi-udruzenje?udruzenjeID=${udruzenje.udruzenjeId}'; return false;"
								type="button" class="btn btn-primary btn-sm">Obrisi udruzenje</button>
						</div>

						<div class="profile-usermenu">
							<ul class="nav flex-column">
								<li class="nav-item"><a class="nav-link" href="${infoLink}"><i
										class="glyphicon glyphicon-home"></i> Osnovne informacije</a></li>
								<li class="active nav-item"><a class="nav-link"
									href="${umetniciLink}"><i class="glyphicon glyphicon-usd"></i>
										Umetnici</a></li>
								<li class="nav-item"><a class="nav-link"
									href="${podrucjaLink}"><i class="glyphicon glyphicon-usd"></i>
										Kulturna podrucja</a></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="col-md-9">
					<div class="profile-content">
						<p class="demo naslov">
							<b>Umetnici</b>
						</p>
						<div class="text-center" style="overflow-x: auto;">
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th>Ime</th>
										<th>Prezime</th>
										<th>JMBG</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${umetnici}" var="trenutniUmetnik">
										<c:url var="umetnikLink"
											value="/administracija/umetnici/${trenutniUmetnik.jmbg}"></c:url>
										<tr onclick="window.location='${umetnikLink}';">
											<td>${trenutniUmetnik.ime}</td>
											<td>${trenutniUmetnik.prezime}</td>
											<td>${trenutniUmetnik.jmbg}</td>
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>

						<input type="button" value="Dodaj umetnika"
							class="form-control btn-info text-center"
							onclick="window.location.href='${pageContext.request.contextPath}/administracija/umetnici/dodaj-novog-umetnika?udruzenjeID=${udruzenje.udruzenjeId}'; return false;" />

					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>

</html>
