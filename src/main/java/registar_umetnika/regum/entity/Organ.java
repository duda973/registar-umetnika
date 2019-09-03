package registar_umetnika.regum.entity;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "organ")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
