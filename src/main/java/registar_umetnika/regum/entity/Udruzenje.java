package registar_umetnika.regum.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="udruzenje")
public class Udruzenje {
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
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name = "podrucjeid")
	private KulturnoPodrucje kulturnoPodrucje;
	

	public Udruzenje() {
	}

	public Udruzenje(int maticniBroj, int pib, String naziv, String sediste, String adresa, Date datumOsnivanja,
			String zastupnik, KulturnoPodrucje kulturnoPodrucje) {
		super();
		this.maticniBroj = maticniBroj;
		this.pib = pib;
		this.naziv = naziv;
		this.sediste = sediste;
		this.adresa = adresa;
		this.datumOsnivanja = datumOsnivanja;
		this.zastupnik = zastupnik;
		this.kulturnoPodrucje = kulturnoPodrucje;
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

	public KulturnoPodrucje getKulturnoPodrucje() {
		return kulturnoPodrucje;
	}

	public void setKulturnoPodrucje(KulturnoPodrucje kulturnoPodrucje) {
		this.kulturnoPodrucje = kulturnoPodrucje;
	}

	@Override
	public String toString() {
		return "Udruzenje [udruzenjeId=" + udruzenjeId + ", maticniBroj=" + maticniBroj + ", pib=" + pib + ", naziv="
				+ naziv + ", sediste=" + sediste + ", adresa=" + adresa + ", datumOsnivanja=" + datumOsnivanja
				+ ", zastupnik=" + zastupnik + ", kulturnoPodrucje=" + kulturnoPodrucje + "]";
	}
}
