package registar_umetnika.regum.entity;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
