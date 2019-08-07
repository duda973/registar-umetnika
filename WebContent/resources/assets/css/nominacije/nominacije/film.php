<?php

class Film
{
    private $idfilma;
    private $naziv;
    private $produkcija;
    private $godina;

    public function setIdFilma($idfilma)
    {
        $this->idfilma = $idfilma;
    }

    public function setNaziv($naziv)
    {
        $this->naziv = $naziv;
    }

    public function setProdukcija($produkcija)
    {
        $this->produkcija = $produkcija;
    }

    public function setGodina($godina)
    {
        $this->godina = $godina;
    }

    public function getIdFilma()
    {
        return $this->idfilma;
    }

    public function getNaziv()
    {
        return $this->naziv;
    }

    public function getProdukcija()
    {
        return $this->produkcija;
    }

    public function getGodina()
    {
        return $this->godina;
    }


    public  function  __construct($idfilma,$naziv,$produkcija,$godina){
        $this->idfilma = $idfilma;
        $this->naziv = $naziv;
        $this->produkcija = $produkcija;
        $this->godina = $godina;

    }

    public static function vratiSveFilmove($konekcija)
    {
      $result = $konekcija->query('select * from film');

      $filmovi = array();
      while($red = $result->fetch_assoc()) {

        $film = new Film($red['idfilma'],$red['naziv'],$red['produkcija'],$red['godina']);


        array_push($filmovi, $film);
        }

        return $filmovi;
    }

    public function izmeniNaziv($konekcija){
        $konekcija->query("update film set naziv='$this->naziv' where idfilma=$this->idfilma");
        return true;
    }
}

?>
