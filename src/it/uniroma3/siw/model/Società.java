package it.uniroma3.siw.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Società {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String ragioneSociale;
	private String indirizzo;
	private int numeroTelefono;
	
	
	//COSTRUTTO	
	  public Società() {
	    }

	    public Società(String ragioneSociale, String indirizzo, int numeroTelefono) {
	        this.ragioneSociale = ragioneSociale;
	        this.indirizzo = indirizzo;
	        this.numeroTelefono = numeroTelefono;
	    }


	//SETTER
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;

	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	//GETTER
	public String getRagioneSociale() {
		return this.ragioneSociale;

	}
	public String getIndirizzo() {
		return this.indirizzo;
	}
	public int getNumeroTelefono() {
		return this.numeroTelefono;
	}


	//STRING
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("Società");
		sb.append("{ragione sociale=").append(ragioneSociale);
		sb.append(", indirizzo=").append(indirizzo);
		sb.append(", numero di telefono=").append(numeroTelefono);

		sb.append("}\n");
		return sb.toString();
	}
}
