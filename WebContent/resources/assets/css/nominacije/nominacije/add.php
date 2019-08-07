<?php
include 'konekcija.php';
include 'film.php';
include 'glumac.php';
include 'nominacija.php';

$glumacID = trim($_POST['glumac']);
$filmID = trim($_POST['film']);
$razlogNominacije = trim($_POST['razlogNominacije']);

$nominacija = new Nominacija($filmID,$glumacID,$razlogNominacije);

$nominacija->sacuvaj($konekcija);

header("Location: index.php");

 ?>
