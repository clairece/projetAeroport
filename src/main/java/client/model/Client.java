package client.model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", initialValue = 50, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "no_client")
	private Long id;
	@Column(name = "name")
	private String nom;
	@Column(name = "phone_number")
	private Integer numeroTel;
	@Column(name = "fax_number")
	private Integer numeroFax;
	@Column(name = "email")
	private String email;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "adresse", column = @Column(name = "adresse_client")), 
		@AttributeOverride(name = "zip_code", column = @Column(name = "zip_code_client")), 
		@AttributeOverride(name = "city", column = @Column(name = "city_client")), 
		@AttributeOverride(name = "country", column = @Column(name = "country_client")), 
	})
	private Adresse adresse;
//	@OneToOne
//	@JoinColumn(name = "log_id")
	private Login login;
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Client() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(Integer numeroTel) {
		this.numeroTel = numeroTel;
	}
	public Integer getNumeroFax() {
		return numeroFax;
	}
	public void setNumeroFax(Integer numeroFax) {
		this.numeroFax = numeroFax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Login getlogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	

}
