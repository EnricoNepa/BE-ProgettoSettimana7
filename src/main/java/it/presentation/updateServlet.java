package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import it.business.RubricaEJB;
import it.data.Contatto;
import it.data.NumTelefono;

/**
 * Servlet implementation class updateServlet
 */
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    RubricaEJB rubricaEjb;
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contatto contatto = new Contatto();
		NumTelefono numTel1 = new NumTelefono();
		NumTelefono numTel2 = new NumTelefono();
		
		Long id = Long.valueOf(request.getParameter("id"));
		contatto = rubricaEjb.getContattoById(id);
		ArrayList<NumTelefono> numeri = contatto.getNumTelefoni();
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email = request.getParameter("email");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
//		contatto.setId(id);
		
		numTel1.setContatto(contatto);
		numTel2.setContatto(contatto);
		
		if(!(nome.equals(""))) {
			contatto.setNome(nome);
		}
		else if(!(cognome.equals(""))) {
			contatto.setCognome(cognome);
		}
		else if(!(email.equals(""))) {
			contatto.setEmail(email);
		}
		else if(numeri.size()==1) {
			if(tel1.equals("")){}
			else {
				numTel1.setNumTelefono(tel1);
			numeri.set(0, numTel1);
			}
			if(tel2.equals("")){}
			else {
				numTel2.setNumTelefono(tel2);
			numeri.add(numTel2);
			}
		}
		else if(numeri.size()>1) {
			if(tel1.equals("")){}
			else {
			numeri.set(0, numTel1);
			}
			if(tel2.equals("")){}
			else {
			numeri.set(1,numTel2);
			}
		}
		
		
		contatto.setNumTelefoni(numeri);
		
		rubricaEjb.modificaContatto(contatto);
		request.getServletContext().getRequestDispatcher("/OperazioneEffettuata.html").forward(request, response);
	}

}
