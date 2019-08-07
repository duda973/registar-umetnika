<?php
include 'konekcija.php';
include 'glumac.php';

  $glumci = Glumac::vratiSveGlumce($konekcija);

  foreach($glumci as $g){

?>
<option value="<?php echo $g->getIdGlumca() ?>"><?php echo $g->getIme() ?></option>

<?php

  }
 ?>
