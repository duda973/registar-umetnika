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
							<div class="profile-usertitle-name">${udruzenje.naziv}</div>
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
								<li class="active nav-item"><a class="nav-link"
									href="${infoLink}"><i class="glyphicon glyphicon-home"></i>
										Osnovne informacije</a></li>
								<li class="nav-item"><a class="nav-link"
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
						<ul class="demo">
							<li class="demo">PIB: ${udruzenje.pib}</li>
							<li class="demo">Maticni broj: ${udruzenje.maticniBroj}</li>
							<li class="demo">Sediste: ${udruzenje.sediste}</li>
							<li class="demo">Adresa: ${udruzenje.adresa}</li>
							<li class="demo">Datum osnivanja:
								${udruzenje.datumOsnivanja}</li>
							<li class="demo">Zastupnik: ${udruzenje.zastupnik}</li>
							<li class="demo">Registarski broj:
								${udruzenje.registarskiBroj}</li>
						</ul>

					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>

</html>
