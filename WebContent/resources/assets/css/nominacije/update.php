<?php
include 'konekcija.php';
include 'film.php';
include 'glumac.php';
include 'nominacija.php';

$naziv = trim($_POST['naziv']);
$filmID = trim($_POST['film']);

$film = new Film($filmID,$naziv,"","");

$film->izmeniNaziv($konekcija);

header("Location: index.php");

 ?>
