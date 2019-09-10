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

				<div class="col-md-3">
					<div class="profile-sidebar">
						<div class="profile-userpic">
							<img
								src="https://static.change.org/profile-img/default-user-profile.svg"
								class="img-responsive" alt="">
						</div>

						<div class="profile-usertitle">
							<div class="profile-usertitle-name">${umetnik.ime}
								${umetnik.prezime}</div>
							<div class="profile-usertitle-job">${umetnik.tipUmetnika.nazivTipa}</div>
						</div>

						<div class="profile-userbuttons">
							<button type="button" class="btn btn-primary btn-sm">Dodaj
								referencu</button>
							<button type="button" class="btn btn-danger btn-sm">Odjavi
								se</button>
						</div>

						<div class="profile-usermenu">
							<ul class="nav">
								<li class="active"><a href="${infoLink}"><i
										class="glyphicon glyphicon-home"></i> Osnovne informacije</a></li>
								<li><a href="${uplateLink}"><i
										class="glyphicon glyphicon-usd"></i> Uplate</a></li>
								<li><a href="${referenceLink}"><i
										class="glyphicon glyphicon-flag"></i> Reference</a></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="col-md-9">
					<div class="profile-content">
						<ul class="demo">
							<li class="demo">Datum rodjenja: ${umetnik.datumRodjenja}</li>
							<li class="demo">JMBG: ${umetnik.jmbg}</li>
							<li class="demo">Mesto rodjenja: ${umetnik.mestoRodjenja}</li>
							<li class="demo">Opstina: ${umetnik.opstinaRodjenja}</li>
							<li class="demo">Drzavljanstvo: ${umetnik.drzavljanstvo}</li>
							<li class="demo">Prebivaliste: ${umetnik.prebivaliste}</li>
							<li class="demo">Adresa: ${umetnik.adresa}</li>
							<li class="demo">Broj telefona: ${umetnik.brojTelefona}</li>
							<li class="demo">Delatnost: ${umetnik.delatnost}</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>

</html>
