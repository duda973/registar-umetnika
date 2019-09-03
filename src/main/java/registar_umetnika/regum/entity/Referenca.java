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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "referenca")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
