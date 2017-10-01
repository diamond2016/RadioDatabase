package it.diamondsw.radio;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;


public class RadioServlet extends HttpServlet {
	static final long serialVersionUID = 1;
	private RadioService radioService = new RadioService();
	private GenreService genreService = new GenreService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("searchAction");
		if (action != null) {
			switch (action) {
			case "searchById":
				System.out.println("searchById");
				searchRadioById(req, resp);
				break;
			case "searchByName":
				System.out.println("searchByName");
				searchRadioByName(req, resp);
				break;
			case "searchRadioByGenre":
				System.out.println("searchByGenre");				
				searchRadioByGenre(req, resp);
			break;
			case "searchGenre":
				System.out.println("searchByGenre");				
				searchGenre(req, resp);
			break;			
		}			
		} else {
			List<RadioDesc> result = radioService.findAvailRadios();
			System.out.println("forwardListRadios no action");			
			forwardListRadios(req, resp, result);
		}			
	} // doGet
	
	private void searchRadioById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int radioId = Integer.valueOf(req.getParameter("id"));

		RadioDesc radio = null;
		ArrayList<RadioDesc> result = new ArrayList<RadioDesc>();
		radio = radioService.findRadio(radioId);
		result.add(radio);
	}

	private void searchRadioByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String radioName = req.getParameter("radioName");
		List<RadioDesc> result = radioService.findAvailRadiosByName(radioName);
		forwardListRadios(req, resp, result);
	} 


	private void searchRadioByGenre(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Genre radioGenre = genreService.findGenreByName(req.getParameter("name"));
		List<RadioDesc> result = radioService.findAvailRadiosByGenre(radioGenre.getId());
		forwardListRadios(req, resp, result);
	}

	private void forwardListRadios(HttpServletRequest req, HttpServletResponse resp, List<RadioDesc> radioDescList) throws ServletException, IOException {
		String nextJSP = "/view/list-radios.jsp";
		req.setAttribute("radioDescList", radioDescList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req, resp);		
	}

	private void searchGenre(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Genre> result = genreService.findAvailGenres();
		forwardListGenres(req, resp, result);
	}
	
	private void forwardListGenres(HttpServletRequest req, HttpServletResponse resp, List<Genre> genreList) throws ServletException, IOException {
		String nextJSP = "/view/list-genres.jsp";
		req.setAttribute("genreList", genreList);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req, resp);		
	}	
} // RadioServlet
