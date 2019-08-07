<?php
include 'konekcija.php';
include 'film.php';

  $filmovi = Film::vratiSveFilmove($konekcija);

  foreach($filmovi as $f){

?>
<option value="<?php echo $f->getIdFilma() ?>"><?php echo $f->getNaziv() ?></option>

<?php

  }
 ?>
