package registar_umetnika.regum.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pripadnostudruzenja")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
