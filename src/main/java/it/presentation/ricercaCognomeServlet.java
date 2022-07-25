package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import it.business.RubricaEJB;
import it.data.Contatto;

/**
 * Servlet implementation class ricercaCognomeServlet
 */
public class ricercaCognomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    RubricaEJB rubricaEjb;
    public ricercaCognomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contatto contatto = new Contatto();
		String cognome = request.getParameter("cognome");
		contatto = rubricaEjb.getContattoByCognome(cognome);
		HttpSession session = request.getSession();
		session.setAttribute("contatto", contatto);
		request.getServletContext().getRequestDispatcher("/ricercacognome.jsp").forward(request, response);
	}

}
