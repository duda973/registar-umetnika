<?php
include 'konekcija.php';
include 'film.php';
include 'glumac.php';
include 'nominacija.php';

$glumacID = trim($_GET['idglumca']);
$filmID = trim($_GET['idfilma']);

$nominacija = new Nominacija($filmID,$glumacID,"");

$nominacija->obrisi($konekcija);

header("Location: index.php");

 ?>
