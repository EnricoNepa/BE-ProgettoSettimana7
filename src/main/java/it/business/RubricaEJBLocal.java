package it.business;

import java.util.List;

import it.data.Contatto;
import jakarta.ejb.Local;

@Local
public interface RubricaEJBLocal {

	public List<Contatto> getContatti();
	public void inserisci(Contatto contatto);
	public Contatto getContattoById(Long id);
	public Contatto getContattoByCognome(String cognome);
	public Contatto getContattoByNumero(String numero);
	public Contatto modificaContatto(Contatto contatto);
	public void delete(Long id);
	
}
