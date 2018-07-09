package be.vdab.servlets.artikels;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Artikel;
import be.vdab.services.ArtikelService;
import be.vdab.util.StringUtils;


@WebServlet("/artikels/kortingen.htm")
public class KortingenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final transient ArtikelService artikelService = new ArtikelService();
	private final static String VIEW = "/WEB-INF/JSP/artikels/kortingen.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Artikel> artikels = artikelService.findAll();
		request.setAttribute("artikels", artikels);
		String idString = request.getParameter("id");
		if (idString!=null) {
			if (StringUtils.isLong(idString)) {
				long id = Long.parseLong(idString);
				request.setAttribute("artikel", artikelService.read(id));
			}
		}
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

}
