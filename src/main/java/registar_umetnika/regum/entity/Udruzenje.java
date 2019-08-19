package registar_umetnika.regum.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "udruzenje")
public class Udruzenje implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "udruzenjeId")
	private int udruzenjeId;

	@Column(name = "maticnibroj")
	private int maticniBroj;

	@Column(name = "pib")
	private int pib;

	@Column(name = "naziv")
	private String naziv;

	@Column(name = "sediste")
	private String sediste;

	@Column(name = "adresa")
	private String adresa;

	@Column(name = "datumosnivanja")
	private Date datumOsnivanja;

	@Column(name = "zastupnik")
	private String zastupnik;
	
	@Column(name = "registarskibroj")
	private int registarskiBroj;

	@OneToMany(mappedBy = "udruzenje", cascade = CascadeType.ALL)
	private Set<PripadnostUdruzenja> pripadnostiUdruzenja = new HashSet<>();

	@OneToMany(mappedBy = "udruzenje", cascade = CascadeType.ALL)
	private Set<Clanstvo> clanstva = new HashSet<>();
	
	public Udruzenje() {
	}

	// sve
	public Udruzenje(int udruzenjeId, int maticniBroj, int pib, String naziv, String sediste, String adresa,
			Date datumOsnivanja, String zastupnik, int registarskiBroj, Set<PripadnostUdruzenja> pripadnostiUdruzenja) {
		this.udruzenjeId = udruzenjeId;
		this.maticniBroj = maticniBroj;
		this.pib = pib;
		this.naziv = naziv;
		this.sediste = sediste;
		this.adresa = adresa;
		this.datumOsnivanja = datumOsnivanja;
		this.zastupnik = zastupnik;
		this.registarskiBroj = registarskiBroj;
		this.pripadnostiUdruzenja = pripadnostiUdruzenja;
	}

	// bez id-a
	public Udruzenje(int maticniBroj, int pib, String naziv, String sediste, String adresa, Date datumOsnivanja,
			String zastupnik, int registarskiBroj, Set<PripadnostUdruzenja> pripadnostiUdruzenja) {
		this.maticniBroj = maticniBroj;
		this.pib = pib;
		this.naziv = naziv;
		this.sediste = sediste;
		this.adresa = adresa;
		this.datumOsnivanja = datumOsnivanja;
		this.zastupnik = zastupnik;
		this.registarskiBroj = registarskiBroj;
		this.pripadnostiUdruzenja = pripadnostiUdruzenja;
	}
	
	// bez ida i bez seta
	public Udruzenje(int maticniBroj, int pib, String naziv, String sediste, String adresa, Date datumOsnivanja,
			String zastupnik, int registarskiBroj) {
		super();
		this.maticniBroj = maticniBroj;
		this.pib = pib;
		this.naziv = naziv;
		this.sediste = sediste;
		this.adresa = adresa;
		this.datumOsnivanja = datumOsnivanja;
		this.zastupnik = zastupnik;
		this.registarskiBroj = registarskiBroj;
	}

	
	public int getRegistarskiBroj() {
		return registarskiBroj;
	}

	public void setRegistarskiBroj(int registarskiBroj) {
		this.registarskiBroj = registarskiBroj;
	}

	public int getUdruzenjeId() {
		return udruzenjeId;
	}

	public void setUdruzenjeId(int udruzenjeId) {
		this.udruzenjeId = udruzenjeId;
	}

	public int getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(int maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getSediste() {
		return sediste;
	}

	public void setSediste(String sediste) {
		this.sediste = sediste;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Date getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public String getZastupnik() {
		return zastupnik;
	}

	public void setZastupnik(String zastupnik) {
		this.zastupnik = zastupnik;
	}

	public Set<PripadnostUdruzenja> getPripadnostiUdruzenja() {
		return pripadnostiUdruzenja;
	}

	public void setPripadnostiUdruzenja(Set<PripadnostUdruzenja> pripadnostiUdruzenja) {
		this.pripadnostiUdruzenja = pripadnostiUdruzenja;
	}

	public Set<Clanstvo> getClanstva() {
		return clanstva;
	}

	public void setClanstva(Set<Clanstvo> clanstva) {
		this.clanstva = clanstva;
	}
	
	
}
