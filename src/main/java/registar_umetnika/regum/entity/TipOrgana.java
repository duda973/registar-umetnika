package registar_umetnika.regum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tiporgana")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipOrgana {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tiporganaid")
	private int tipOrganaId;
	
	@Column(name = "naziv")
	private String naziv;

}
