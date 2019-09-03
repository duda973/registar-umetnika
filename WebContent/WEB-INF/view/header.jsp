<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<header id="header-nav" role="banner">
  <div id="navbar" class="navbar navbar-default">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/pocetna">
        <i class="fa fa-book color-brown"></i>
        <strong>e
        </strong>Registar samostalnih umetnika</a>

      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    
    
    <div class="collapse navbar-collapse">
      <ul class="nav navbar-nav flot-nav">
        <li>
          <a href="${pageContext.request.contextPath}/pocetna">
            <i class="fa fa-home color-brown"></i> Pocetna strana</a>
        </li>
        
        <li>
          <a href="${pageContext.request.contextPath}/administracija">
            <i class="fa fa-check color-brown"></i>
            Administracija</a>
        </li>
        
        <sec:authorize access="!isAuthenticated()">
        <li>
          <a href="${pageContext.request.contextPath}/login">
            <i class="fa fa-users color-brown"></i>
            Login</a>
        </li>
		</sec:authorize>
        
		<sec:authorize access="isAuthenticated()">
        <li>
          <a href="${pageContext.request.contextPath}/logout">
            <i class="fa fa-users color-brown"></i>
            Logout</a>
        </li>
		<li>
          <a href="${pageContext.request.contextPath}/profil">
            <i class="fa fa-users color-brown"></i>
            ${sessionScope.user}</a>
        </li>
		</sec:authorize>
		
      </ul>
    </div>
  </div>
</header>
