package registar_umetnika.regum.entity;

import java.sql.Date;

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
@Table(name = "tipumetnika")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipUmetnika {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipumetnikaid")
	private int tipUmetnikaId;

	@Column(name = "nazivtipa")
	private String nazivTipa;
}
