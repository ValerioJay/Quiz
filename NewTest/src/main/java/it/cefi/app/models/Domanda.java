package it.cefi.app.models;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "domande")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Domanda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDomanda; 
	
	@Column
	private String testoDomanda; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "domanda",  cascade = CascadeType.ALL)
	private List<Risposta> risposte;

	public int getIdDomanda() {
		return idDomanda;
	}

	public void setIdDomanda(int idDomanda) {
		this.idDomanda = idDomanda;
	}

	public String getTestoDomanda() {
		return testoDomanda;
	}

	public void setTestoDomanda(String testoDomanda) {
		this.testoDomanda = testoDomanda;
	}

	public List<Risposta> getRisposte() {
		return risposte;
	}

	public void setRisposte(List<Risposta> risposte) {
		this.risposte = risposte;
	}
	
	

	
	
	
}
