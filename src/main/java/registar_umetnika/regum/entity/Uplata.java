package registar_umetnika.regum.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "uplata")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Uplata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uplataid")
	private int uplataId;
	
	@Column(name = "zdravstveno")
	private double zdravstveno;
	
	@Column(name = "penzionoinvalidsko")
	private double penzionoInvalidsko;
	
	@Column(name = "osnovica")
	private double osnovica;
	
	@Column(name = "datumuplate")
	private Date datumUplate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="umetnikid")
	@JsonManagedReference
	private Umetnik umetnik;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="uplataorganid")
	@JsonManagedReference
	private Organ organ;
}
