<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>AccessDenied page</title>
</head>
<body>
	<br/>
	<br/>
	<h1>Postovani <strong>${user}</strong>, nemate pristup ovoj stranici. </h1>
	<br/>
	<a href="<c:url value="/pocetna" />">Nazad na pocetnu stranu</a>  
	<sec:authorize access="hasAuthority('Superadmin') or hasAuthority('Udruzenje') or hasAuthority('Ministarstvo') or hasAuthority('Lokalna samouprava')">
           ili  <a href="<c:url value="/logout" />">logout</a>
    </sec:authorize>
	
</body>
</html>