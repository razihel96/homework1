package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Docente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private long partitaIva;
	@Column(nullable = true)	
	private LocalDate dataDiNascita;
	@Column(nullable = true)
	private String luogoDiNascita;
	
	//bidirezionale
	@OneToMany(mappedBy = "docente")
	private List<Corso> corsiDocente; //ogni docente può tenere più corsi 


	//COSTRUTTO	
	public Docente() {
	}

	public Docente(String nome, String cognome, long partitaIva, LocalDate dataDiNascita, String luogoDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.partitaIva = partitaIva;
		this.dataDiNascita = dataDiNascita;
		this.luogoDiNascita = luogoDiNascita;
	}


	//SETTER
	public void setNome(String nome) {
		this.nome = nome;		
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;		
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;	
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;		
	}

	public void setPartitaIva(long partitaIva) {
		this.partitaIva = partitaIva;		
	}

	public void setCorsiDocente(List<Corso> corsiDocente) {
		this.corsiDocente = corsiDocente;		
	}


	//GETTER
	public String getNome() {
		return this.nome;		
	}

	public String getCognome() {
		return this.cognome;		
	}

	public LocalDate getDataDiNascita() {
		return this.dataDiNascita;	
	}

	public String getLuogoDiNascita() {
		return this.luogoDiNascita;		
	}

	public long getPartitaIva() {
		return this.partitaIva;		
	}

	public List<Corso> getCorsiDocente() {
		return this.corsiDocente;		
	}


	//STRING
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Docente");
		sb.append("{nome=").append(nome);
		sb.append(", cognome=").append(cognome);
		sb.append(", data di nascita=").append(dataDiNascita);
		sb.append(", luogo di nascita='").append(luogoDiNascita);
		sb.append(", partita IVA=").append(partitaIva);

		sb.append("}\n");
		return sb.toString();
	}



}
