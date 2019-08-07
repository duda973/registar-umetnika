<?php

class Nominacija
{
    private $film;
    private $glumac;
    private $razlogNominacije;

    public function setFilm($film)
    {
        $this->film = $film;
    }

    public function setGlumac($glumac)
    {
        $this->glumac = $glumac;
    }

    public function setRazlogNominacije($razlogNominacije)
    {
        $this->razlogNominacije = $razlogNominacije;
    }

    public function getFilm()
    {
        return $this->film;
    }

    public function getGlumac()
    {
        return $this->glumac;
    }

    public function getRazlogNominacije()
    {
        return $this->razlogNominacije;
    }

    public  function  __construct($film,$glumac,$razlogNominacije){
        $this->film = $film;
        $this->glumac = $glumac;
        $this->razlogNominacije = $razlogNominacije;
    }

    public static function vratiSveNominacije($konekcija)
  	{
  		$result = $konekcija->query('select * from nominacija n join glumac g on n.idglumca=g.idglumca join film f on n.idfilma=f.idfilma');

  		$nominacije = array();
  		while($red = $result->fetch_assoc()) {

        $film = new Film($red['idfilma'],$red['naziv'],$red['produkcija'],$red['godina']);
        $glumac = new Glumac($red['idglumca'],$red['ime']);

        $nominacija = new Nominacija($film,$glumac,$red['razlogNominacije']);

  			array_push($nominacije, $nominacija);
      	}

      	return $nominacije;
  	}
    public static function vratiSveNominacijeSearch($konekcija,$search)
  	{
  		$result = $konekcija->query('select * from nominacija n join glumac g on n.idglumca=g.idglumca join film f on n.idfilma=f.idfilma where g.ime LIKE "%'.$search.'%"');

  		$nominacije = array();
  		while($red = $result->fetch_assoc()) {

        $film = new Film($red['idfilma'],$red['naziv'],$red['produkcija'],$red['godina']);
        $glumac = new Glumac($red['idglumca'],$red['ime']);

        $nominacija = new Nominacija($film,$glumac,$red['razlogNominacije']);

  			array_push($nominacije, $nominacija);
      	}

      	return $nominacije;
  	}

    public function sacuvaj($konekcija){
        $konekcija->query("Insert into nominacija values ($this->film,$this->glumac,'$this->razlogNominacije')");
        return true;
    }
    public function obrisi($konekcija){
        $konekcija->query("delete from nominacija where idfilma= $this->film and idglumca = $this->glumac");
        return true;
    }
}

?>
