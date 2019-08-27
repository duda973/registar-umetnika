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
import javax.persistence.Table;

@Entity
@Table(name = "referenca")
public class Referenca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "referencaid")
	private int referencaId;

	@Column(name = "naziv")
	private String naziv;

	@Column(name = "opis")
	private String opis;

	@Column(name = "datum")
	private Date datum;

	@Column(name = "odobren")
	private int odobren;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "umetnikid")
	private Umetnik umetnik;

	public Referenca() {
	}

	public Referenca(int referencaId, String naziv, String opis, Date datum, int odobren, Umetnik umetnik) {
		this.referencaId = referencaId;
		this.naziv = naziv;
		this.opis = opis;
		this.datum = datum;
		this.odobren = odobren;
		this.umetnik = umetnik;
	}

	public Referenca(int referencaId) {
		super();
		this.referencaId = referencaId;
	}

	public Referenca(String naziv, String opis, Date datum, int odobren) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.datum = datum;
		this.odobren = odobren;
	}

	public Referenca(String naziv, String opis, Date datum, int odobren, Umetnik umetnik) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.datum = datum;
		this.odobren = odobren;
		this.umetnik = umetnik;
	}

	public int getReferencaId() {
		return referencaId;
	}

	public void setReferencaId(int referencaId) {
		this.referencaId = referencaId;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getOdobren() {
		return odobren;
	}

	public void setOdobren(int odobren) {
		this.odobren = odobren;
	}

	public Umetnik getUmetnik() {
		return umetnik;
	}

	public void setUmetnik(Umetnik umetnik) {
		this.umetnik = umetnik;
	}

	@Override
	public String toString() {
		return "Referenca [referencaId=" + referencaId + ", naziv=" + naziv + ", opis=" + opis + ", datum=" + datum
				+ ", odobren=" + odobren + ", umetnik=" + umetnik + "]";
	}

}
