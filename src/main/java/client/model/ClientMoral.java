package client.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
@DiscriminatorValue("M")
public class ClientMoral extends Client {
//	@Version
//	@Column(name = "VERSION")
//	private Integer version;
	@Column(name = "legal_title", length = 100)
	private String TitreMoral;
	@Column(name = "compagny_register", length = 100)
	private String SIRET;

	public ClientMoral() {
	}

	public String getTitreMoral() {
		return TitreMoral;
	}

	public void setTitreMoral(String titreMoral) {
		TitreMoral = titreMoral;
	}

	public String getSIRET() {
		return SIRET;
	}

	public void setSIRET(String sIRET) {
		SIRET = sIRET;
	}

}
