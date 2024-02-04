package it.cefi.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "risposte")
public class Risposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRisposta; 
	
	@Column
	private String testoRisposta;
	
	@Column
	private Boolean corretta; 
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idDomanda")
	private Domanda domanda;

	public int getIdRisposta() {
		return idRisposta;
	}

	public void setIdRisposta(int idRisposta) {
		this.idRisposta = idRisposta;
	}

	public String getTestoRisposta() {
		return testoRisposta;
	}

	public void setTestoRisposta(String testoRisposta) {
		this.testoRisposta = testoRisposta;
	}

	public Boolean getCorretta() {
		return corretta;
	}

	public void setCorretta(Boolean corretta) {
		this.corretta = corretta;
	}

	public Domanda getDomanda() {
		return domanda;
	}

	public void setDomanda(Domanda domanda) {
		this.domanda = domanda;
	}
	

}
