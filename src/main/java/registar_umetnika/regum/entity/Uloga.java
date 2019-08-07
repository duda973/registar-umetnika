package registar_umetnika.regum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "uloga")
public class Uloga {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ulogaid", unique = true, nullable = false)
	private int ulogaId;

	@Column(name = "nazivuloge")
	private String nazivUloge;

	public Uloga() {
	}

	public Uloga(String nazivUloge) {
		super();
		this.nazivUloge = nazivUloge;
	}

	public Uloga(int ulogaId, String nazivUloge) {
		super();
		this.ulogaId = ulogaId;
		this.nazivUloge = nazivUloge;
	}

	public int getUlogaId() {
		return ulogaId;
	}

	public void setUlogaId(int ulogaId) {
		this.ulogaId = ulogaId;
	}

	public String getNazivUloge() {
		return nazivUloge;
	}

	public void setNazivUloge(String nazivUloge) {
		this.nazivUloge = nazivUloge;
	}

	@Override
	public String toString() {
		return nazivUloge;
	}

}
