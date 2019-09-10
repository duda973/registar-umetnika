<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

	<div class="wrap-pad">
		<p class="demo naslov">
			<b>UNOS NOVOG UMETNIKA</b>
		</p>
		<p style="text-align: center">Popunite podatke</p>

		<div class="container">
			<form:form action="sacuvaj-novog-umetnika" modelAttribute="umetnik"
				method="POST">
				<form:hidden path="umetnikId" />

				<div class="row">
					<div class="col-25">
						<label for="ime">Ime</label>
					</div>
					<div class="col-75">
						<form:input type="text" path="ime" cssClass="form-control"
							placeholder="Ime umetnika.." />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label for="prezime">Prezime</label>
					</div>
					<div class="col-75">
						<form:input type="text" path="prezime" cssClass="form-control"
							placeholder="Prezime umetnika.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="imeRoditelja">Ime roditelja</label>
					</div>
					<div class="col-75">
						<form:input path="imeRoditelja" cssClass="form-control"
							placeholder="Ime roditelja.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="jmbg">JMBG</label>
					</div>
					<div class="col-75">
						<form:input path="jmbg" cssClass="form-control"
							placeholder="JMBG.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="datumrodjenja">Datum rođenja</label>
					</div>
					<div class="col-75">
						<form:input path="datumRodjenja" type="date"
							cssClass="form-control" placeholder="Datum rođenja.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="mrodj">Mesto rođenja</label>
					</div>
					<div class="col-75">
						<form:input path="mestoRodjenja" cssClass="form-control"
							placeholder="Mesto rođenja.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="opstina">Opstina rodjenja</label>
					</div>
					<div class="col-75">
						<form:input path="opstinaRodjenja" cssClass="form-control"
							placeholder="Opstina rodjenja.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="lname">Državljanstvo</label>
					</div>
					<div class="col-75">
						<form:input path="drzavljanstvo" cssClass="form-control"
							placeholder="Drzavljanstvo.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="prebiv">Prebivalište</label>
					</div>
					<div class="col-75">
						<form:input path="prebivaliste" cssClass="form-control"
							placeholder="Prebivaliste.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="adresa">Adresa</label>
					</div>
					<div class="col-75">
						<form:input path="Adresa" cssClass="form-control"
							placeholder="Adresa.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="brtel">Broj telefona</label>
					</div>
					<div class="col-75">
						<form:input path="brojTelefona" cssClass="form-control"
							placeholder="Broj telefona.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="delatnost">Delatnost</label>
					</div>
					<div class="col-75">
						<form:input path="delatnost" cssClass="form-control"
							placeholder="Delatnost.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="dpod">Datum početka obavljanja delatnosti</label>
					</div>
					<div class="col-75">
						<form:input path="datumPocetkaObavljanjaDelatnosti" type="date"
							cssClass="form-control"
							placeholder="Datum početka obavljanja delatnosti.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="brAkta">Broj akta</label>
					</div>
					<div class="col-75">
						<form:input path="brojAkta" cssClass="form-control"
							placeholder="Broj akta.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="status">Status zaposlenja</label>
					</div>
					<div class="col-75">
						<form:input path="statusZaposlenja" cssClass="form-control"
							placeholder="Status zaposlenja.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="mestoZap">Mesto zaposlenja</label>
					</div>
					<div class="col-75">
						<form:input path="mestoZaposlenja" cssClass="form-control"
							placeholder="Mesto zaposlenja.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="dpod">Datum prestanka obavljanja delatnosti</label>
					</div>
					<div class="col-75">
						<form:input path="datumPrestankaObavljanjaDelatnosti" type="date"
							cssClass="form-control"
							placeholder="Datum prestanka obavljanja delatnosti.." />
					</div>
				</div>
				<div class="row">
					<div class="col-25">
						<label for="ispUsl">Ispunjenost uslova</label>
					</div>
					<div class="col-75">
						<form:input path="ispunjenostUslova" cssClass="form-control"
							placeholder="Ispunjenost uslova.." />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label for="ispUsl">Datum upisa</label>
					</div>
					<div class="col-75">
						<form:input path="datumUpisa" type="date" cssClass="form-control"
							placeholder="Datum upisa.." />
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label for="ispUsl">Tip umetnika</label>
					</div>
					<div class="col-75">
						<form:select path="tipUmetnika"
							cssClass="form-control text-center">
							<form:options items="${tipoviUmetnika}" itemLabel="nazivTipa"
								itemValue="tipUmetnikaId" cssClass="form-control text-center" />
						</form:select>
					</div>
				</div>

				<div class="row">
					<div class="col-25">
						<label for="subject">Napomena</label>
					</div>
					<div class="col-75">
						<form:textarea path="napomena" placeholder="Napomena.."
							style="height: 200px"></form:textarea>
					</div>
				</div>

				<div class="row">
					<label class="margintop10" for="submit"></label> <input
						type="submit" name="pocni" value="Potvrdi"
						class="form-control btn-primary btn-xl">
				</div>
				<div class="row">
					<input type="button" value="Odustani"
						class="form-control btn-info text-center"
						onclick="window.location.href='${pageContext.request.contextPath}/administracija/umetnici'; return false;" />
				</div>
			</form:form>
		</div>
	</div>

	<%@ include file="footer.jsp"%>

</body>

</html>
