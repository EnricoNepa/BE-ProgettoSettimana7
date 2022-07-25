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

/**
 * Servlet implementation class deleteServlet
 */
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
    RubricaEJB rubricaEjb;
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.valueOf(request.getParameter("id"));
		rubricaEjb.delete(id);
		request.getServletContext().getRequestDispatcher("/OperazioneEffettuata.html").forward(request, response);
	}

}
