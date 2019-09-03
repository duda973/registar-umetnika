package registar_umetnika.regum.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "udruzenje")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Udruzenje implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "udruzenjeId")
	private int udruzenjeId;

	@Column(name = "maticnibroj")
	private int maticniBroj;

	@Column(name = "pib")
	private int pib;

	@Column(name = "naziv")
	private String naziv;

	@Column(name = "sediste")
	private String sediste;

	@Column(name = "adresa")
	private String adresa;

	@Column(name = "datumosnivanja")
	private Date datumOsnivanja;

	@Column(name = "zastupnik")
	private String zastupnik;
	
	@Column(name = "registarskibroj")
	private int registarskiBroj;

	@OneToMany(mappedBy = "udruzenje", cascade = CascadeType.ALL)
	private Set<PripadnostUdruzenja> pripadnostiUdruzenja = new HashSet<>();

	@OneToMany(mappedBy = "udruzenje", cascade = CascadeType.ALL)
	private Set<Clanstvo> clanstva = new HashSet<>();
	
}
