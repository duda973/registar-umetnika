package registar_umetnika.regum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tiporgana")
public class TipOrgana {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tiporganaid")
	private int tipOrganaId;
	
	@Column(name = "naziv")
	private String naziv;

	public TipOrgana() {
	}
	
	public TipOrgana(String naziv) {
		super();
		this.naziv = naziv;
	}

	public TipOrgana(int tipOrganaId, String naziv) {
		super();
		this.tipOrganaId = tipOrganaId;
		this.naziv = naziv;
	}

	public int getTipOrganaId() {
		return tipOrganaId;
	}

	public void setTipOrganaId(int tipOrganaId) {
		this.tipOrganaId = tipOrganaId;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "TipOrgana [tipOrganaId=" + tipOrganaId + ", naziv=" + naziv + "]";
	}
	
	
}
