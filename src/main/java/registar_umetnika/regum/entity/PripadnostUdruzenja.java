package registar_umetnika.regum.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pripadnostudruzenja")
public class PripadnostUdruzenja implements Serializable{
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="udruzenjeId")
	private Udruzenje udruzenje;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="kulturnopodrucjeId")
	private KulturnoPodrucje kulturnoPodrucje;

	@Column(name="datumunosa")
	private Date datumUnosa;

	@Column(name="reprezentativno")
	private String reprezentativno;

	@Column(name="datumunosaubazu")
	private Date datumUnosaUBazu;

	public PripadnostUdruzenja() {
	}

	public PripadnostUdruzenja(Udruzenje udruzenje, KulturnoPodrucje kulturnoPodrucje, Date datumUnosa,
			String reprezentativno, Date datumUnosaUBazu) {
		this.udruzenje = udruzenje;
		this.kulturnoPodrucje = kulturnoPodrucje;
		this.datumUnosa = datumUnosa;
		this.reprezentativno = reprezentativno;
		this.datumUnosaUBazu = datumUnosaUBazu;
	}

	public Udruzenje getUdruzenje() {
		return udruzenje;
	}

	public void setUdruzenje(Udruzenje udruzenje) {
		this.udruzenje = udruzenje;
	}

	public KulturnoPodrucje getKulturnoPodrucje() {
		return kulturnoPodrucje;
	}

	public void setKulturnoPodrucje(KulturnoPodrucje kulturnoPodrucje) {
		this.kulturnoPodrucje = kulturnoPodrucje;
	}

	public Date getDatumUnosa() {
		return datumUnosa;
	}

	public void setDatumUnosa(Date datumUnosa) {
		this.datumUnosa = datumUnosa;
	}

	public String getReprezentativno() {
		return reprezentativno;
	}

	public void setReprezentativno(String reprezentativno) {
		this.reprezentativno = reprezentativno;
	}

	public Date getDatumUnosaUBazu() {
		return datumUnosaUBazu;
	}

	public void setDatumUnosaUBazu(Date datumUnosaUBazu) {
		this.datumUnosaUBazu = datumUnosaUBazu;
	}

	@Override
	public String toString() {
		return "PripadnostUdruzenja [udruzenje=" + udruzenje + ", kulturnoPodrucje=" + kulturnoPodrucje
				+ ", datumUnosa=" + datumUnosa + ", reprezentativno=" + reprezentativno + ", datumUnosaUBazu="
				+ datumUnosaUBazu + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(udruzenje.getNaziv(), kulturnoPodrucje.getNazivPodrucja(), datumUnosa, reprezentativno,
				datumUnosaUBazu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PripadnostUdruzenja))
			return false;
		PripadnostUdruzenja other = (PripadnostUdruzenja) obj;
		if (datumUnosa == null) {
			if (other.datumUnosa != null)
				return false;
		} else if (!datumUnosa.equals(other.datumUnosa))
			return false;
		if (datumUnosaUBazu == null) {
			if (other.datumUnosaUBazu != null)
				return false;
		} else if (!datumUnosaUBazu.equals(other.datumUnosaUBazu))
			return false;
		if (kulturnoPodrucje == null) {
			if (other.kulturnoPodrucje != null)
				return false;
		} else if (!kulturnoPodrucje.equals(other.kulturnoPodrucje))
			return false;
		if (reprezentativno == null) {
			if (other.reprezentativno != null)
				return false;
		} else if (!reprezentativno.equals(other.reprezentativno))
			return false;
		if (udruzenje == null) {
			if (other.udruzenje != null)
				return false;
		} else if (!udruzenje.equals(other.udruzenje))
			return false;
		return true;
	}
	
	public void resetuj() {
		this.datumUnosa = null;
		this.datumUnosaUBazu = null;
		this.kulturnoPodrucje = null;
		this.reprezentativno = null;
		this.udruzenje = null;
	}
}
