
<div class="col-md-3">
	<div class="profile-sidebar text-center">
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
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/administracija/umetnici/${umetnik.jmbg}/dodaj-referencu'; return false;"
				type="button" class="form-control btn btn-primary btn-sm">Dodaj
				referencu</button>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/administracija/umetnici/izmeni-podatke?jmbg=${umetnik.jmbg}'; return false;"
				type="button" class="form-control btn btn-primary btn-sm">Izmeni
				podatke</button>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/administracija/korisnici/dodaj-novog-korisnika?umetnikID=${umetnik.umetnikId}'; return false;"
				type="button" class="form-control btn btn-primary btn-sm">Napravi nalog umetniku</button>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/logout'; return false;"
				type="button" class="form-control btn btn-danger btn-sm">Odjavi
				se</button>
		</div>

		<div class="profile-usermenu">
			<ul class="nav flex-column">
				<li id="osnovne-info" class="nav-item"><a class="nav-link"
					href="${infoLink}"><i class="glyphicon glyphicon-home"></i>
						Osnovne informacije</a></li>
				<li id="uplate" class="nav-item"><a class="nav-link" href="${uplateLink}"><i
						class="glyphicon glyphicon-usd"></i> Uplate</a></li>
				<li id="reference" class="nav-item"><a class="nav-link"
					href="${referenceLink}"><i class="glyphicon glyphicon-flag"></i>
						Reference</a></li>
			</ul>
		</div>
	</div>
</div>

<script type="text/javascript">

	
	$("#osnovne-info").click(function(){
		$("#osnovne-info").toggleClass("active");	
		$("#uplate").removeClass("active");
		$("#reference").removeClass("active");
	});
	
	$("#reference").click(function(){
		$("#reference").toggleClass("active");	
		$("#osnovne-info").removeClass("active");
		$("#uplate").removeClass("active");
	});
	
	$("#uplate").click(function(){
		$("#uplate").toggleClass(active);	
		$("#osnovne-info").removeClass("active");
		$("#reference").removeClass("active");
	});
	
</script>



