package registar_umetnika.regum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kulturnopodrucje")
public class KulturnoPodrucje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "podrucjeid")
	private int podrucjeId;
	
	@Column(name = "nazivpodrucja")
	private String nazivPodrucja;
	
	@Column(name = "umetnicko")
	private String umetnicko;

	public KulturnoPodrucje() {
	}
	
	public KulturnoPodrucje(String nazivPodrucja) {
		this.nazivPodrucja = nazivPodrucja;
	}
	
	public KulturnoPodrucje(int podrucjeId, String nazivPodrucja, String umetnicko) {
		this.podrucjeId = podrucjeId;
		this.nazivPodrucja = nazivPodrucja;
		this.umetnicko = umetnicko;
	}

	public int getPodrucjeId() {
		return podrucjeId;
	}

	public void setPodrucjeId(int podrucjeId) {
		this.podrucjeId = podrucjeId;
	}

	public String getNazivPodrucja() {
		return nazivPodrucja;
	}

	public void setNazivPodrucja(String nazivPodrucja) {
		this.nazivPodrucja = nazivPodrucja;
	}

	public String getUmetnicko() {
		return umetnicko;
	}

	public void setUmetnicko(String umetnicko) {
		this.umetnicko = umetnicko;
	}

	@Override
	public String toString() {
		return nazivPodrucja;
	}
}
