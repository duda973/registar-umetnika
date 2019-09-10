package registar_umetnika.regum.entity;

import java.io.Serializable;
import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "umetnik")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Umetnik implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "umetnikid")
	private int umetnikId;
	
	@Column(name = "prezime")
	private String prezime;
	
	@Column(name = "ime")
	private String ime;
	
	@Column(name = "imeroditelja")
	private String imeRoditelja;
	
	@Column(name = "jmbg")
	private String jmbg;
	
	@Column(name = "datumrodjenja")
	private Date datumRodjenja;
	
	@Column(name = "mestorodjenja")
	private String mestoRodjenja;
	
	@Column(name = "opstinarodjenja")
	private String opstinaRodjenja;
	
	@Column(name = "drzavljanstvo")
	private String drzavljanstvo;
	
	@Column(name = "prebivaliste")
	private String prebivaliste;
	
	@Column(name = "adresa")
	private String adresa;
	
	@Column(name = "brojtelefona")
	private String brojTelefona;
	
	@Column(name = "delatnost")
	private String delatnost;
	
	@Column(name = "datumpocetkaobavljanjadelatnosti")
	private Date datumPocetkaObavljanjaDelatnosti;
	
	@Column(name = "brojakta")
	private String brojAkta;
	
	@Column(name = "statuszaposlenja")
	private String statusZaposlenja;
	
	@Column(name = "mestozaposlenja")
	private String mestoZaposlenja;
	
	@Column(name = "datumprestankaobavljanjadelatnosti")
	private Date datumPrestankaObavljanjaDelatnosti;
	
	@Column(name = "ispunjenostuslova")
	private int ispunjenostUslova;
	
	@Column(name = "datumupisa")
	private Date datumUpisa;
	
	@Column(name = "napomena")
	private String napomena;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "tipumetnikaid")
	private TipUmetnika tipUmetnika;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "proglasenodID")
	private Udruzenje proglasenOdUdruzenja;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "korisnikID")
	private Korisnik korisnik;

	@OneToMany(mappedBy = "umetnik", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Uplata> uplate = new HashSet<>();
	
	@OneToMany(mappedBy = "umetnik", cascade = CascadeType.ALL)
	private Set<Clanstvo> clanstva = new HashSet<>();
	
}
