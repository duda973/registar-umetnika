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

	<div class="text-center">
		<div class="wrap-pad container">
			<h1 class="pb-3">
				<i class="fas fa-cog"></i> Administracija
				aplikacije
			</h1>

			<c:url var="korisniciLink" value="/administracija/korisnici">
			</c:url>
			<c:url var="udruzenjaLink" value="/administracija/udruzenja">
			</c:url>
			<c:url var="umetniciLink" value="/administracija/umetnici">
			</c:url>
			<c:url var="podrucjaLink" value="/administracija/kulturna-podrucja">
			</c:url>

			<div class="row mt-2 justify-content-around">
				<button type="button" class="btn btn-primary col-5 admin-opcija"
					onclick="window.location='${korisniciLink}';">Korisnici</button>
				<button type="button" class="btn btn-primary col-5 admin-opcija"
					onclick="window.location='${udruzenjaLink}';">Udruzenja</button>
			</div>
			<div class="row mt-2 justify-content-around">
				<button type="button" class="btn btn-primary col-5 admin-opcija"
					onclick="window.location='${umetniciLink}';">Umetnici</button>
				<button type="button" class="btn btn-primary col-5 admin-opcija"
					onclick="window.location='${podrucjaLink}';">Kulturna
					podrucja</button>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
	
</body>

</html>
