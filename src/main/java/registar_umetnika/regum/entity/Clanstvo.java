package registar_umetnika.regum.entity;

import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "clanstvo")
public class Clanstvo implements Serializable{
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "umetnikID")
	private Umetnik umetnik;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "udruzenjeID")
	private Udruzenje udruzenje;

	@Column(name = "datum")
	private Date datum;
	
	public Clanstvo() {
	}

	public Clanstvo(Umetnik umetnik, Udruzenje udruzenje, Date datum) {
		this.umetnik = umetnik;
		this.udruzenje = udruzenje;
		this.datum = datum;
	}

	public Umetnik getUmetnik() {
		return umetnik;
	}

	public void setUmetnik(Umetnik umetnik) {
		this.umetnik = umetnik;
	}

	public Udruzenje getUdruzenje() {
		return udruzenje;
	}

	public void setUdruzenje(Udruzenje udruzenje) {
		this.udruzenje = udruzenje;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "Clanstvo [umetnik=" + umetnik + ", udruzenje=" + udruzenje + ", datum=" + datum + "]";
	}
	
}
