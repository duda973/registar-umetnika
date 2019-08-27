package registar_umetnika.regum.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "umetnik")
public class Umetnik implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "umetnikid")
	private int umetnikId;
	
	@Column(name = "prezime")
	private String prezime;
	
	@Column(name = "ime")
	private String ime;
	
	@Column(name = "imeroditelja")
	private String imeRoditelja;
	
	@Column(name = "jmbg")
	private String jmbg;
	
	@Column(name = "datumrodjenja")
	private Date datumRodjenja;
	
	@Column(name = "mestorodjenja")
	private String mestoRodjenja;
	
	@Column(name = "opstinarodjenja")
	private String opstinaRodjenja;
	
	@Column(name = "drzavljanstvo")
	private String drzavljanstvo;
	
	@Column(name = "prebivaliste")
	private String prebivaliste;
	
	@Column(name = "adresa")
	private String adresa;
	
	@Column(name = "brojtelefona")
	private String brojTelefona;
	
	@Column(name = "delatnost")
	private String delatnost;
	
	@Column(name = "datumpocetkaobavljanjadelatnosti")
	private Date datumPocetkaObavljanjaDelatnosti;
	
	@Column(name = "brojakta")
	private String brojAkta;
	
	@Column(name = "statuszaposlenja")
	private String statusZaposlenja;
	
	@Column(name = "mestozaposlenja")
	private String mestoZaposlenja;
	
	@Column(name = "datumprestankaobavljanjadelatnosti")
	private Date datumPrestankaObavljanjaDelatnosti;
	
	@Column(name = "ispunjenostuslova")
	private int ispunjenostUslova;
	
	@Column(name = "datumupisa")
	private Date datumUpisa;
	
	@Column(name = "napomena")
	private String napomena;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "tipumetnikaid")
	private TipUmetnika tipUmetnika;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "proglasenodID")
	private Udruzenje proglasenOdUdruzenja;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "korisnikID")
	private Korisnik korisnik;

	@OneToMany(mappedBy = "umetnik", cascade = CascadeType.ALL)
	private Set<Uplata> uplate = new HashSet<>();
	
	@OneToMany(mappedBy = "umetnik", cascade = CascadeType.ALL)
	private Set<Clanstvo> clanstva = new HashSet<>();
	
	public Umetnik(int umetnikId, String prezime, String ime, String imeRoditelja, String jmbg, Date datumRodjenja,
			String mestoRodjenja, String opstinaRodjenja, String drzavljanstvo, String prebivaliste, String adresa,
			String brojTelefona, String delatnost, Date datumPocetkaObavljanjaDelatnosti, String brojAkta,
			String statusZaposlenja, String mestoZaposlenja, Date datumPrestankaObavljanjaDelatnosti,
			int ispunjenostUslova, Date datumUpisa, String napomena, TipUmetnika tipUmetnika,
			Udruzenje proglasenOdUdruzenja, Korisnik korisnik) {
		this.umetnikId = umetnikId;
		this.prezime = prezime;
		this.ime = ime;
		this.imeRoditelja = imeRoditelja;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.mestoRodjenja = mestoRodjenja;
		this.opstinaRodjenja = opstinaRodjenja;
		this.drzavljanstvo = drzavljanstvo;
		this.prebivaliste = prebivaliste;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.delatnost = delatnost;
		this.datumPocetkaObavljanjaDelatnosti = datumPocetkaObavljanjaDelatnosti;
		this.brojAkta = brojAkta;
		this.statusZaposlenja = statusZaposlenja;
		this.mestoZaposlenja = mestoZaposlenja;
		this.datumPrestankaObavljanjaDelatnosti = datumPrestankaObavljanjaDelatnosti;
		this.ispunjenostUslova = ispunjenostUslova;
		this.datumUpisa = datumUpisa;
		this.napomena = napomena;
		this.tipUmetnika = tipUmetnika;
		this.proglasenOdUdruzenja = proglasenOdUdruzenja;
		this.korisnik = korisnik;
	}

	public Umetnik(String prezime, String ime, String imeRoditelja, String jmbg, Date datumRodjenja, String mestoRodjenja,
			String opstinaRodjenja, String drzavljanstvo, String prebivaliste, String adresa, String brojTelefona,
			String delatnost, Date datumPocetkaObavljanjaDelatnosti, String brojAkta, String statusZaposlenja,
			String mestoZaposlenja, Date datumPrestankaObavljanjaDelatnosti, int ispunjenostUslova, Date datumUpisa,
			String napomena, TipUmetnika tipUmetnika, Udruzenje proglasenOdUdruzenja, Korisnik korisnik) {
		this.prezime = prezime;
		this.ime = ime;
		this.imeRoditelja = imeRoditelja;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.mestoRodjenja = mestoRodjenja;
		this.opstinaRodjenja = opstinaRodjenja;
		this.drzavljanstvo = drzavljanstvo;
		this.prebivaliste = prebivaliste;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.delatnost = delatnost;
		this.datumPocetkaObavljanjaDelatnosti = datumPocetkaObavljanjaDelatnosti;
		this.brojAkta = brojAkta;
		this.statusZaposlenja = statusZaposlenja;
		this.mestoZaposlenja = mestoZaposlenja;
		this.datumPrestankaObavljanjaDelatnosti = datumPrestankaObavljanjaDelatnosti;
		this.ispunjenostUslova = ispunjenostUslova;
		this.datumUpisa = datumUpisa;
		this.napomena = napomena;
		this.tipUmetnika = tipUmetnika;
		this.proglasenOdUdruzenja = proglasenOdUdruzenja;
		this.korisnik = korisnik;
	}

	public Umetnik(String prezime, String ime, String imeRoditelja, String jmbg, Date datumRodjenja, String mestoRodjenja,
			String opstinaRodjenja, String drzavljanstvo, String prebivaliste, String adresa, String brojTelefona,
			String delatnost, Date datumPocetkaObavljanjaDelatnosti, String brojAkta, String statusZaposlenja,
			String mestoZaposlenja, Date datumPrestankaObavljanjaDelatnosti, int ispunjenostUslova, Date datumUpisa,
			String napomena) {
		this.prezime = prezime;
		this.ime = ime;
		this.imeRoditelja = imeRoditelja;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.mestoRodjenja = mestoRodjenja;
		this.opstinaRodjenja = opstinaRodjenja;
		this.drzavljanstvo = drzavljanstvo;
		this.prebivaliste = prebivaliste;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.delatnost = delatnost;
		this.datumPocetkaObavljanjaDelatnosti = datumPocetkaObavljanjaDelatnosti;
		this.brojAkta = brojAkta;
		this.statusZaposlenja = statusZaposlenja;
		this.mestoZaposlenja = mestoZaposlenja;
		this.datumPrestankaObavljanjaDelatnosti = datumPrestankaObavljanjaDelatnosti;
		this.ispunjenostUslova = ispunjenostUslova;
		this.datumUpisa = datumUpisa;
		this.napomena = napomena;
	}

	public Umetnik() {
	}

	
	
	public int getUmetnikId() {
		return umetnikId;
	}

	public void setUmetnikId(int umetnikId) {
		this.umetnikId = umetnikId;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getImeRoditelja() {
		return imeRoditelja;
	}

	public void setImeRoditelja(String imeRoditelja) {
		this.imeRoditelja = imeRoditelja;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getMestoRodjenja() {
		return mestoRodjenja;
	}

	public void setMestoRodjenja(String mestoRodjenja) {
		this.mestoRodjenja = mestoRodjenja;
	}

	public String getOpstinaRodjenja() {
		return opstinaRodjenja;
	}

	public void setOpstinaRodjenja(String opstinaRodjenja) {
		this.opstinaRodjenja = opstinaRodjenja;
	}

	public String getDrzavljanstvo() {
		return drzavljanstvo;
	}

	public void setDrzavljanstvo(String drzavljanstvo) {
		this.drzavljanstvo = drzavljanstvo;
	}

	public String getPrebivaliste() {
		return prebivaliste;
	}

	public void setPrebivaliste(String prebivaliste) {
		this.prebivaliste = prebivaliste;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getDelatnost() {
		return delatnost;
	}

	public void setDelatnost(String delatnost) {
		this.delatnost = delatnost;
	}

	public Date getDatumPocetkaObavljanjaDelatnosti() {
		return datumPocetkaObavljanjaDelatnosti;
	}

	public void setDatumPocetkaObavljanjaDelatnosti(Date datumPocetkaObavljanjaDelatnosti) {
		this.datumPocetkaObavljanjaDelatnosti = datumPocetkaObavljanjaDelatnosti;
	}

	public String getBrojAkta() {
		return brojAkta;
	}

	public void setBrojAkta(String brojAkta) {
		this.brojAkta = brojAkta;
	}

	public String getStatusZaposlenja() {
		return statusZaposlenja;
	}

	public void setStatusZaposlenja(String statusZaposlenja) {
		this.statusZaposlenja = statusZaposlenja;
	}

	public String getMestoZaposlenja() {
		return mestoZaposlenja;
	}

	public void setMestoZaposlenja(String mestoZaposlenja) {
		this.mestoZaposlenja = mestoZaposlenja;
	}

	public Date getDatumPrestankaObavljanjaDelatnosti() {
		return datumPrestankaObavljanjaDelatnosti;
	}

	public void setDatumPrestankaObavljanjaDelatnosti(Date datumPrestankaObavljanjaDelatnosti) {
		this.datumPrestankaObavljanjaDelatnosti = datumPrestankaObavljanjaDelatnosti;
	}

	public int getIspunjenostUslova() {
		return ispunjenostUslova;
	}

	public void setIspunjenostUslova(int ispunjenostUslova) {
		this.ispunjenostUslova = ispunjenostUslova;
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public TipUmetnika getTipUmetnika() {
		return tipUmetnika;
	}

	public void setTipUmetnika(TipUmetnika tipUmetnika) {
		this.tipUmetnika = tipUmetnika;
	}

	public Udruzenje getProglasenOdUdruzenja() {
		return proglasenOdUdruzenja;
	}

	public void setProglasenOdUdruzenja(Udruzenje proglasenOdUdruzenja) {
		this.proglasenOdUdruzenja = proglasenOdUdruzenja;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Set<Uplata> getUplate() {
		return uplate;
	}

	public void setUplate(Set<Uplata> uplate) {
		this.uplate = uplate;
	}
	
	
	
	public Set<Clanstvo> getClanstva() {
		return clanstva;
	}

	public void setClanstva(Set<Clanstvo> clanstva) {
		this.clanstva = clanstva;
	}

	@Override
	public String toString() {
		return "Umetnik [umetnikId=" + umetnikId + ", prezime=" + prezime + ", ime=" + ime + ", imeRoditelja="
				+ imeRoditelja + ", jmbg=" + jmbg + ", datumRodjenja=" + datumRodjenja + ", mestoRodjenja="
				+ mestoRodjenja + ", opstinaRodjenja=" + opstinaRodjenja + ", drzavljanstvo=" + drzavljanstvo
				+ ", prebivaliste=" + prebivaliste + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona
				+ ", delatnost=" + delatnost + ", datumPocetkaObavljanjaDelatnosti=" + datumPocetkaObavljanjaDelatnosti
				+ ", brojAkta=" + brojAkta + ", statusZaposlenja=" + statusZaposlenja + ", mestoZaposlenja="
				+ mestoZaposlenja + ", datumPrestankaObavljanjaDelatnosti=" + datumPrestankaObavljanjaDelatnosti
				+ ", ispunjenostUslova=" + ispunjenostUslova + ", datumUpisa=" + datumUpisa + ", napomena=" + napomena
				+ ", tipUmetnika=" + tipUmetnika + ", proglasenOdUdruzenja=" + proglasenOdUdruzenja + ", korisnik="
				+ korisnik + "]";
	}


	
	
}
