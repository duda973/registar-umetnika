<?php

class Glumac
{
    private $idglumca;
    private $ime;


    public function setIdGlumca($idglumca)
    {
        $this->idglumca = $idglumca;
    }

    public function setIme($ime)
    {
        $this->ime = $ime;
    }



    public function getIdGlumca()
    {
        return $this->idglumca;
    }

    public function getIme()
    {
        return $this->ime;
    }


    public  function  __construct($idglumca,$ime){
        $this->idglumca = $idglumca;
        $this->ime = $ime;

    }

    public static function vratiSveGlumce($konekcija)
  	{
  		$result = $konekcija->query('select * from glumac ');

  		$glumci = array();
  		while($red = $result->fetch_assoc()) {

        $glumac = new Glumac($red['idglumca'],$red['ime']);


  			array_push($glumci, $glumac);
      	}

      	return $glumci;
  	}
}

?>
