package client.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("P")
public class ClientPhysique extends Client {
//	@Version
//	@Column(name = "VERSION")
//	private Integer version;
	@Column(name = "physical_title", length = 100)
	private String TitrePhysique;
	@Column(name = "first_name", length = 100)
	private String prénom;

	public ClientPhysique() {
	}

	public String getTitrePhysique() {
		return TitrePhysique;
	}

	public void setTitrePhysique(String titrePhysique) {
		TitrePhysique = titrePhysique;
	}

	public String getPrénom() {
		return prénom;
	}

	public void setPrénom(String prénom) {
		this.prénom = prénom;
	}

}
