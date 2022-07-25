package it.business;

import java.util.ArrayList;
import java.util.List;

import it.data.Contatto;
import it.data.NumTelefono;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class RubricaEJB
 */
@Stateless
@LocalBean
public class RubricaEJB implements RubricaEJBRemote, RubricaEJBLocal {

	@PersistenceContext(name = "RubricaProgettoSettimana7")
	EntityManager em;

	public RubricaEJB() {
		// TODO Auto-generated constructor stub
	}

	public List<Contatto> getContatti() {
		Query q = em.createQuery("SELECT c FROM Contatto c");
		@SuppressWarnings("unchecked")
		List<Contatto> contatti = (List<Contatto>) q.getResultList();
		return contatti;
	}

	public void inserisci(Contatto contatto) {
		em.persist(contatto);
	}

	public Contatto getContattoById(Long id) {
		return em.find(Contatto.class, id);
	}

	public Contatto getContattoByCognome(String cognome) {
		Contatto contatto = new Contatto();
		Query query = em.createQuery("SELECT c FROM Contatto c WHERE c.cognome LIKE :cognome");
		query.setParameter("cognome", "%" + cognome + "%");
		contatto = (Contatto) query.getSingleResult();
		return contatto;
	}

	public Contatto getContattoByNumero(String numero) {
		Contatto contatto = new Contatto();
		NumTelefono numTel = new NumTelefono();
		numTel = em.find(NumTelefono.class, numero);
		contatto = numTel.getContatto();
		return contatto;
	}


	public Contatto modificaContatto(Contatto contatto) {
		return em.merge(contatto);
	}

	public void delete(Long id) {
		Contatto contatto = new Contatto();
		contatto = getContattoById(id);
		em.remove(contatto);
	}
}
