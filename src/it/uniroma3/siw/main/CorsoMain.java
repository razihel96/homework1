

//non ho trovato la necessità di modificare il comportamento di default delle diverse associazioni 


package it.uniroma3.siw.main;
 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import it.uniroma3.siw.model.Allievo;
import it.uniroma3.siw.model.Corso;
import it.uniroma3.siw.model.Docente;
import it.uniroma3.siw.model.Società;


public class CorsoMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("corsi-unit");
		EntityManager em = emf.createEntityManager();
		
		LocalDate dataDiInizio = LocalDate.of(2022, 3, 1);
		LocalDate dataDiNascita = LocalDate.of(1970, 10, 20);
		LocalDate dataDiNascita2 = LocalDate.of(1996, 11, 16);
		
		
		//DOCENTE
		Docente docente = new Docente();
		docente.setNome("Paolo");
		docente.setCognome("Merialdo");
		docente.setDataDiNascita(dataDiNascita);
		docente.setLuogoDiNascita("Roma");		
		docente.setPartitaIva(1234567891);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(docente);
		tx.commit();
		
		
		Docente docente2 = new Docente();
		docente2.setNome("Maurizio");
		docente2.setCognome("Patrignani");
		docente2.setDataDiNascita(dataDiNascita);
		docente2.setLuogoDiNascita("Roma");		
		docente2.setPartitaIva(33445566);

		tx.begin();
		em.persist(docente2);
		tx.commit();
		
		Docente docente3 = new Docente();
		docente3.setNome("Pierpaolo");
		docente3.setCognome("Esposito");
		docente3.setDataDiNascita(dataDiNascita);
		docente3.setLuogoDiNascita("Roma");		
		docente3.setPartitaIva(1112223334);

		tx.begin();
		em.persist(docente3);
		tx.commit();
		
		Docente docente4 = new Docente();
		docente4.setNome("Paolo");
		docente4.setCognome("Atzeni");
		docente4.setDataDiNascita(dataDiNascita);
		docente4.setLuogoDiNascita("Roma");		
		docente4.setPartitaIva(555111137);

		tx.begin();
		em.persist(docente4);
		tx.commit();
		
		
		//CORSO
		Corso corso = new Corso();
		corso.setNome("Sistemi Informativi Su Web");
		corso.setDataDiInizio(dataDiInizio);
		corso.setDurataInMesi(6);
		corso.setDocente(docente);

		tx.begin();
		em.persist(corso);
		tx.commit();
		
		Corso corso2 = new Corso();
		corso2.setNome("Analisi I");
		corso2.setDataDiInizio(dataDiInizio);
		corso2.setDurataInMesi(6);
		corso2.setDocente(docente3);

		tx.begin();
		em.persist(corso2);
		tx.commit();
		
		Corso corso3 = new Corso();
		corso3.setNome("Basi di Dati");
		corso3.setDataDiInizio(dataDiInizio);
		corso3.setDurataInMesi(6);
		corso3.setDocente(docente4);

		tx.begin();
		em.persist(corso3);
		tx.commit();
		
		Corso corso4 = new Corso();
		corso4.setNome("Algoritmi e Strutture di Dati");
		corso4.setDataDiInizio(dataDiInizio);
		corso4.setDurataInMesi(6);
		corso4.setDocente(docente2);

		tx.begin();
		em.persist(corso4);
		tx.commit();
		
		Corso corso5 = new Corso();
		corso5.setNome("Algoritmi per Big Data");
		corso5.setDataDiInizio(dataDiInizio);
		corso5.setDurataInMesi(6);
		corso5.setDocente(docente2);

		tx.begin();
		em.persist(corso5);
		tx.commit();
		
		
		//LISTA ALLIEVO-CORSO
		List<Corso> listaGiampaolo = new ArrayList<Corso>(); 
		listaGiampaolo.add(corso);
		listaGiampaolo.add(corso2);
		listaGiampaolo.add(corso3);
		
		List<Corso> listaMarco = new ArrayList<Corso>(); 
		listaMarco.add(corso);
		listaMarco.add(corso4);
		
		List<Corso> listaCarlo = new ArrayList<Corso>(); 
		listaCarlo.add(corso2);
		
		
		
		//SOCIETA
		Società società = new Società();
		società.setRagioneSociale("Abc");
		società.setIndirizzo("via Marconi 30");
		società.setNumeroTelefono(123456789);
		
		tx.begin();
		em.persist(società);
		tx.commit();
		
		Società società2 = new Società();
		società2.setRagioneSociale("Def");
		società2.setIndirizzo("via Marconi 80");
		società2.setNumeroTelefono(100100200);
		
		tx.begin();
		em.persist(società2);
		tx.commit();
		
		
		//ALLIEVO
		Allievo allievo = new Allievo();
		allievo.setMatricola(168754);
		allievo.setNome("Giampaolo");
		allievo.setCognome("Neri");
		allievo.setDataDiNascita(dataDiNascita2);
		allievo.setLuogoDiNascita("Milano");
		allievo.setEmail("giampaoloneri1@gmail.com");
		allievo.setSocietà(società);
		allievo.setCorso(listaGiampaolo);
	
		tx.begin();
		em.persist(allievo);
		tx.commit();
		
		Allievo allievo2 = new Allievo();
		allievo2.setMatricola(131222);
		allievo2.setNome("Marco");
		allievo2.setCognome("Bianchi");
		allievo2.setDataDiNascita(dataDiNascita2);
		allievo2.setLuogoDiNascita("Roma");
		allievo2.setEmail("marcobianchi1@gmail.com");
		allievo2.setSocietà(società);
		allievo2.setCorso(listaMarco);
	
		tx.begin();
		em.persist(allievo2);
		tx.commit();
		
		Allievo allievo3 = new Allievo();
		allievo3.setMatricola(889871);
		allievo3.setNome("Carlo");
		allievo3.setCognome("Rossi");
		allievo3.setDataDiNascita(dataDiNascita2);
		allievo3.setLuogoDiNascita("Torino");
		allievo3.setEmail("carlorossi1@gmail.com");
		allievo3.setSocietà(società2);
		allievo3.setCorso(listaCarlo);
	
		tx.begin();
		em.persist(allievo3);
		tx.commit();
		
		List<Allievo> listaAnalisi = new ArrayList<Allievo>();
		listaAnalisi.add(allievo);
		listaAnalisi.add(allievo2);
		
		List<Allievo> listaSIW = new ArrayList<Allievo>();
		listaSIW.add(allievo3);
		listaSIW.add(allievo);
		
		List<Allievo> listaASD = new ArrayList<Allievo>();
		listaASD.add(allievo2);

		
		

		

		em.close();
		emf.close();
		
		

	}


}
