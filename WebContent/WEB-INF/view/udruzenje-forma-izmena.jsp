<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

      <!DOCTYPE html>
      <html lang="en">

      <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Registar samostalnih umetnika</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/assets/css/font-awesome.min.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/assets/css/prettyPhoto.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/resources/assets/css/style.css" rel="stylesheet" />
      </head>

      <body>
        <%@ include file="header.jsp" %>

          <section id="about-section">
            <div class="wrap-pad">
              <div class="row">
                <div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 ">
                  <div class="text-center">
                    <h1>
						<i class="fa fa-book small-icons bk-color-brown"></i>Udruzenje forma
					</h1>
	
                    <form:form action="sacuvaj-izmene" modelAttribute="udruzenje" method="POST">
                      <form:hidden path="udruzenjeId" />
					
                      <label class="margintop10" for="maticniBroj">Maticni broj</label>
                      <form:input path="maticniBroj" cssClass="form-control" />

                      <label class="margintop10" for="pib">PIB</label>
                      <form:input path="pib" cssClass="form-control" />

                      <label class="margintop10" for="naziv">Naziv</label>
                      <form:input path="naziv" cssClass="form-control" />

                      <label class="margintop10" for="sediste">Sediste</label>
                      <form:input path="sediste" cssClass="form-control" />

                      <label class="margintop10" for="adresa">Adresa</label>
                      <form:input path="adresa" cssClass="form-control" />
                      
                      <label class="margintop10" for="datumOsnivanja">Datum osnivanja</label>
                      <form:input type="date" path="datumOsnivanja" cssClass="form-control" />
                      
                      <label class="margintop10" for="zastupnik">Zastupnik</label>
                      <form:input path="zastupnik" cssClass="form-control" />
                      
                      <label class="margintop10" for="registarskibroj">Registarski broj</label>
                      <form:input path="registarskiBroj" cssClass="form-control" />                      

                      <label class="margintop10" for="submit"></label>
                      <input type="submit" value="Sacuvaj izmene" class="form-control btn-success margintop10 text-center">
                    </form:form>
                  </div>
                  
                  <div class="margintop10">
                    <input type="button" value="Odustani" class="form-control btn-info text-center" onclick="window.location.href='${pageContext.request.contextPath}/administracija/udruzenja'; return false;" />
                  </div>

                </div>

              </div>
            </div>
          </section>

          <%@ include file="footer.jsp" %>

          <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.js"></script>
          <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js"></script>
          <script src="${pageContext.request.contextPath}/resources/assets/js/jquery.prettyPhoto.js"></script>
          <script src="${pageContext.request.contextPath}/resources/assets/js/scrollReveal.js"></script>
          <script src="${pageContext.request.contextPath}/resources/assets/scripts/custom.js"></script>
      </body>

      </html>
