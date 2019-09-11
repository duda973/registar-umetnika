<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
	
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container">
		<a class="navbar-brand"
			href="${pageContext.request.contextPath}/pocetna"> <i
			class="fas fa-palette color-white"></i> <strong>e</strong>Umetnici
		</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"> 
					<a class="nav-link" href="${pageContext.request.contextPath}/pocetna">
						<i class="fas fa-home"></i> Pocetna
					</a>
				</li>
			</ul>
			
			<ul class="navbar-nav">		
				<li class="nav-item active"><a class="nav-link" href="/regum/administracija/umetnici"> <i
						class="fa fa-users color-white"></i> Umetnici
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="/regum/administracija/udruzenja"> <i
						class="fa fa-users color-white"></i> Udruzenja
				</a></li>
				
				<sec:authorize access="hasAuthority('Superadmin') OR hasAuthority('Ministarstvo')">
					<li class="nav-item dropdown active">
					<a  class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"><i class="fas fa-users-cog"></i> Administracija</a>
						
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="/regum/administracija/korisnici">Korisnici</a> 
							<a class="dropdown-item" href="/regum/administracija/udruzenja">Udruzenja</a>
							<a class="dropdown-item" href="/regum/administracija/umetnici">Umetnici</a>
							<a class="dropdown-item" href="/regum/administracija/kulturna-podrucja">Kulturna podrucja</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="${pageContext.request.contextPath}/administracija">Sve opcije</a>						
						</div>
					</li>
				</sec:authorize>

				<sec:authorize access="!isAuthenticated()">
					<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/login"> <i
							class="fa fa-users color-white"></i> Login
					</a></li>
				</sec:authorize>

				<sec:authorize access="isAuthenticated()">
					<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/logout"> <i
							class="fa fa-users color-white"></i> Logout
					</a></li>
					<li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/profil"> <i
							class="fa fa-users color-white"></i> ${sessionScope.user}
					</a></li>
				</sec:authorize>
			</ul>
		</div>
	</div>
</nav>