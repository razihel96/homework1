package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Allievo {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private int matricola;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;
	private String email;
	private LocalDate dataDiNascita;
	private String luogoDiNascita;
	
	//bidirezionale
	@ManyToMany
	private List<Corso> corso; //ogni allievo può frequentare più corsi 
	
	@ManyToOne
	private Società società; //ogni allievo appartiene ad una sola società 

	
	//COSTRUTTO	
	  public Allievo() {
	    }

	    public Allievo(int matricola, String nome, String cognome, String email, LocalDate dataDiNascita, String luogoDiNascita) {
	        this.matricola = matricola;
	    	this.nome = nome;
	    	this.cognome = cognome;
	    	this.email = email;
	        this.dataDiNascita = dataDiNascita;
	        this.luogoDiNascita = luogoDiNascita;
	    }
	    
	    
	//SETTER
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;		
	}
	
	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}
	
	public void setSocietà(Società società) {
		this.società = società;
	}
	
	public void setCorso(List<Corso> corso) {
		this.corso = corso;		
	}

	
	//GETTER
	public int getMatricola() {
		return this.matricola;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCognome() {
		return this.cognome;
	}
	
	public String getEmail() {
		return this.email;
	}

	public LocalDate getDataDiNascita() {
		return this.dataDiNascita;		
	}
	
	public String getLuogoDiNascita() {
		return this.luogoDiNascita;
	}
	
	public Società getSocietà() {
		return this.società;
	}
	
	public List<Corso> getCorso() {
		return this.corso;		
	}
	
	public boolean equals(Object obj) {
		Allievo allievo = (Allievo)obj;
		return this.getNome().equals(allievo.getNome());
	}

	
	//STRING
	   public String toString() {
	        final StringBuilder sb = new StringBuilder();
	        sb.append("Allievo");
	        sb.append("{matricola=").append(matricola);
	        sb.append(", nome=").append(nome);
	        sb.append(", cognome=").append(cognome);
	        sb.append(", email=").append(email);
	        sb.append(", data di nascita=").append(dataDiNascita);
	        sb.append(", luogo di nascita='").append(luogoDiNascita);
	        sb.append("}\n");
	        return sb.toString();
	    }




	
}
