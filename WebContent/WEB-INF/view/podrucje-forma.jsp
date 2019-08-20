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
                    <h1><i class="fa fa-book small-icons bk-color-brown"></i>Kulturno podrucje forma</h1>

                    <form:form action="sacuvaj-kulturno-podrucje" modelAttribute="podrucje" method="POST">
                      <form:hidden path="podrucjeId" />

                      <label class="margintop10" for="nazivPodrucja">Naziv kulturnog podrucja</label>
                      <form:input path="nazivPodrucja" cssClass="form-control" />

                      <label class="margintop10" for="uloga">Da li je umetnicko?</label>
					  <form:radiobutton path="umetnicko" id="da" value="da"/>
					  <form:radiobutton path="umetnicko" id="ne" value="ne"/>
	
                      <label class="margintop10" for="submit"></label>
                      <input type="submit" value="Sacuvaj kulturno podrucje" class="form-control btn-success margintop10 text-center">
                    </form:form>
                  </div>
                  
                  <div class="margintop10">
                    <input type="button" value="Odustani" class="form-control btn-info text-center" onclick="window.location.href='${pageContext.request.contextPath}/administracija/kulturna-podrucja'; return false;" />
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
