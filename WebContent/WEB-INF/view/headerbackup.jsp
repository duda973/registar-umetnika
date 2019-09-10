<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<header id="header-nav" role="banner">
	<div id="navbar" class="navbar navbar-dark bg-primary">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/pocetna"> <i
				class="fas fa-palette color-white"></i> <strong>e</strong>Umetnici
			</a>

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>


		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav flot-nav">
				<li><a href="${pageContext.request.contextPath}/pocetna"> <i
						class="fa fa-home color-white"></i> Pocetna
				</a></li>

				<li><a href="${pageContext.request.contextPath}/administracija">
						<i class="fa fa-check color-white"></i> Administracija
				</a></li>

				<sec:authorize access="!isAuthenticated()">
					<li><a href="${pageContext.request.contextPath}/login"> <i
							class="fa fa-users color-white"></i> Login
					</a></li>
				</sec:authorize>

				<sec:authorize access="isAuthenticated()">
					<li><a href="${pageContext.request.contextPath}/logout"> <i
							class="fa fa-users color-white"></i> Logout
					</a></li>
					<li><a href="${pageContext.request.contextPath}/profil"> <i
							class="fa fa-users color-white"></i> ${sessionScope.user}
					</a></li>
				</sec:authorize>
			</ul>
		</div>
	</div>
	</div>
</header>
