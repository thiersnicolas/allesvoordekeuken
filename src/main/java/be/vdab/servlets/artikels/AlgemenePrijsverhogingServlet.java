package be.vdab.servlets.artikels;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.ArtikelService;
import be.vdab.util.StringUtils;

/**
 * Servlet implementation class AlgemenePrijsverhogingServlet
 */
@WebServlet("/artikels/prijsverhoging.htm")
public class AlgemenePrijsverhogingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/artikels/algemeneprijsverhoging.jsp";
	private final transient ArtikelService artikelService = new ArtikelService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> fouten = new HashMap<>();
		String percentageString = request.getParameter("percentage");
		if (StringUtils.isBigDecimal(percentageString)) {
			BigDecimal percentage = new BigDecimal(percentageString);
			if (percentage.compareTo(BigDecimal.ZERO) <=0) {
				fouten.put("percentage", "geef een positief getal in");
			} else {
			artikelService.algemenePrijsverhoging(percentage);
			}
		} else {
			fouten.put("percentage", "geef een positie getal in");
		}
		if (fouten.isEmpty()) {
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
		} else {
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}
}
