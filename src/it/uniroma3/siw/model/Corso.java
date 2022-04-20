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
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "findAllCorsi", query = "SELECT c FROM Corso c")
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	@Column(nullable = true)
	private String nome;
	@Column(nullable = true)
	private LocalDate dataDiInizio;
	@Column(nullable = true)
	private int durataInMesi;
	
	
	@ManyToOne
	private Docente docente; //corso tenuto da un solo docente
	
	//bidirezionale
	@ManyToMany (mappedBy = "corso")
	private List<Allievo> allievi; //corso frequentato da 1+ allievi

	
	//COSTRUTTO	
	public Corso() {
	}

	public Corso(String nome, LocalDate dataDiInizio, int durataInMesi) {
		this.nome = nome;
		this.dataDiInizio = dataDiInizio;
		this.durataInMesi = durataInMesi;
	}


	//SETTER
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataDiInizio(LocalDate dataDiInizio) {
		this.dataDiInizio = dataDiInizio;		
	}

	public void setDurataInMesi(int durataInMesi) {
		this.durataInMesi = durataInMesi;		
	}
	
	public void setDocente(Docente docente) {
		this.docente = docente;
	}


	//GETTER
	public String getNome() {
		return this.nome;
	}

	public LocalDate getDataDiInizio() {
		return this.dataDiInizio;
	}

	public int getDurataInMesi() {
		return this.durataInMesi;
	}
	
	public Docente getDocente() {
		return this.docente;
	}

	public boolean equals(Object obj) {
		Corso corso = (Corso)obj;
		return this.getNome().equals(corso.getNome());
	}
	

	//STRING
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Corso");
		sb.append("{nome=").append(nome);
		sb.append(", data di inizio=").append(dataDiInizio);
		sb.append(", durata in mesi='").append(durataInMesi);
		sb.append(", docente=").append(docente);
		sb.append("}\n");
		return sb.toString();
	}



}
