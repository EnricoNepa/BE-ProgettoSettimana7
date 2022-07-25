package it.presentation;

import it.data.NumTelefono;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.business.RubricaEJB;
import it.data.Contatto;

/**
 * Servlet implementation class inserisciServlet
 */
public class inserisciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    RubricaEJB rubricaEjb;
    public inserisciServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contatto contatto = new Contatto();
		NumTelefono numtelefono1 = new NumTelefono();
		ArrayList<NumTelefono> numeri = new ArrayList<>();
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		
		numtelefono1.setNumTelefono(tel1);
		contatto.setNome(nome);
		contatto.setCognome(cognome);
		contatto.setEmail(email);
		numtelefono1.setContatto(contatto);
		numeri.add(numtelefono1);

		if(tel2.equals("")) {
			
		}
		else {
			NumTelefono numtelefono2 = new NumTelefono();
			numtelefono2.setNumTelefono(tel2);
			numtelefono2.setContatto(contatto);
			numeri.add(numtelefono2);
		}
		
		
		contatto.setNumTelefoni(numeri);
		
		
		
		rubricaEjb.inserisci(contatto);
		request.getServletContext().getRequestDispatcher("/OperazioneEffettuata.html").forward(request, response);
	}

}
