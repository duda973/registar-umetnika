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
