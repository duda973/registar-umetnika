package registar_umetnika.regum.entity;

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
@Table(name = "organ")
public class Organ {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "organid")
	private int organId;
	
	@Column(name = "naziv")
	private String naziv;
	
	@Column(name = "pib")
	private int pib;
	
	@Column(name = "maticnibroj")
	private int maticniBroj;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name = "tiporganaid")
	private TipOrgana tipOrgana;

	@OneToMany(mappedBy = "organ", cascade = CascadeType.ALL)
	private Set<Uplata> uplate = new HashSet<>();
	
	public Organ() {
	}
	
	public Organ(String naziv, int pib, int maticniBroj) {
		super();
		this.naziv = naziv;
		this.pib = pib;
		this.maticniBroj = maticniBroj;
	}

	public Organ(String naziv, int pib, int maticniBroj, TipOrgana tipOrgana) {
		super();
		this.naziv = naziv;
		this.pib = pib;
		this.maticniBroj = maticniBroj;
		this.tipOrgana = tipOrgana;
	}

	public Organ(int organId, String naziv, int pib, int maticniBroj, TipOrgana tipOrgana) {
		super();
		this.organId = organId;
		this.naziv = naziv;
		this.pib = pib;
		this.maticniBroj = maticniBroj;
		this.tipOrgana = tipOrgana;
	}

	public int getOrganId() {
		return organId;
	}

	public void setOrganId(int organId) {
		this.organId = organId;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getPib() {
		return pib;
	}

	public void setPib(int pib) {
		this.pib = pib;
	}

	public int getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(int maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public TipOrgana getTipOrgana() {
		return tipOrgana;
	}

	public void setTipOrgana(TipOrgana tipOrgana) {
		this.tipOrgana = tipOrgana;
	}

	@Override
	public String toString() {
		return "Organ [organId=" + organId + ", naziv=" + naziv + ", pib=" + pib + ", maticniBroj=" + maticniBroj
				+ ", tipOrgana=" + tipOrgana + "]";
	}
	
	
}
