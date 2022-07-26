package it.data;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="contatto")

public class Contatto {
	
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	
	private ArrayList<NumTelefono> numTelefoni;

	
	
	
//	public Contatto(String nome, String cognome, String email, ArrayList<NumTelefono> numTelefoni) {
//		super();
//		this.nome = nome;
//		this.cognome = cognome;
//		this.email = email;
//		this.numTelefoni = numTelefoni;
//	}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="nome", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="cognome", nullable = false)
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy="contatto",cascade=CascadeType.ALL)
	public ArrayList<NumTelefono> getNumTelefoni() {
		return numTelefoni;
	}

	public void setNumTelefoni(ArrayList<NumTelefono> numTelefoni) {
		this.numTelefoni = numTelefoni;
	}
	
	

}
