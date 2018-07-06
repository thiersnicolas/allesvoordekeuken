package be.vdab.servlets.artikels;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Artikel;
import be.vdab.services.ArtikelService;

/**
 * Servlet implementation class ZoekenOpNaamServlet
 */
@WebServlet("/artikels/zoekenopnaam.htm")
public class ZoekenOpNaamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String VIEW = "/WEB-INF/JSP/artikels/zoekenopnaam.jsp";
	private final transient ArtikelService artikelService = new ArtikelService();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getQueryString()!=null) {
			if (Artikel.isNaamValid(request.getQueryString())){
				String text = request.getParameter("text");
				request.setAttribute("artikels", artikelService.findArtikelHasInName(text));
				
			} else {
				request.setAttribute("fouten", "Een deel van de naam moet ingevuld zijn.");
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
