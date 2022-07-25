package it.presentation;

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
 * Servlet implementation class selectServlet
 */
public class selectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    RubricaEJB rubricaEjb;
    public selectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Contatto> listaContatti = rubricaEjb.getContatti();
		HttpSession session = request.getSession();
		session.setAttribute("listaContatti", listaContatti);
		request.getServletContext().getRequestDispatcher("/select.jsp").forward(request, response);
	}

}
