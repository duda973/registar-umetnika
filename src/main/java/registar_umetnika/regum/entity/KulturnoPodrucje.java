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
@Table(name = "kulturnopodrucje")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KulturnoPodrucje implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "podrucjeid")
	private int podrucjeId;

	@Column(name = "nazivpodrucja")
	private String nazivPodrucja;

	@Column(name = "umetnicko")
	private String umetnicko;

	@OneToMany(mappedBy = "kulturnoPodrucje", cascade = CascadeType.ALL)
	private Set<PripadnostUdruzenja> pripadnostiUdruzenja = new HashSet<>();

}
