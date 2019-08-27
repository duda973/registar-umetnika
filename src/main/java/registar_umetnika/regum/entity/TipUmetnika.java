package registar_umetnika.regum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipumetnika")
public class TipUmetnika {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipumetnikaid")
	private int tipUmetnikaId;

	@Column(name = "nazivtipa")
	private String nazivTipa;
	
	public TipUmetnika() {
	}
	
	public TipUmetnika(int id) {
		this.tipUmetnikaId = id;
	}
	
	public TipUmetnika(int tipUmetnikaId, String nazivTipa) {
		this.tipUmetnikaId = tipUmetnikaId;
		this.nazivTipa = nazivTipa;
	}

	public int getTipUmetnikaId() {
		return tipUmetnikaId;
	}

	public void setTipUmetnikaId(int tipUmetnikaId) {
		this.tipUmetnikaId = tipUmetnikaId;
	}

	public String getNazivTipa() {
		return nazivTipa;
	}

	public void setNazivTipa(String nazivTipa) {
		this.nazivTipa = nazivTipa;
	}

	@Override
	public String toString() {
		return String.valueOf(this.tipUmetnikaId);
	}
	
	
}
