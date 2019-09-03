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
@Table(name = "uloga")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Uloga {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ulogaid", unique = true, nullable = false)
	private int ulogaId;

	@Column(name = "nazivuloge")
	private String nazivUloge;
}
