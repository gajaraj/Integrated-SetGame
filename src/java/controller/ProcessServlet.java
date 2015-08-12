package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameDTO;
import bizlogic.GameManager;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class for Servlet: ProcessServlet
 *
 */
@WebServlet("/process")
 public class ProcessServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ProcessServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}   	  	   
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		GameManager gm = new GameManager();
		GameDTO game = new GameDTO();
                game.setGameid(request.getParameter("gameid"));
                game.setDescription(request.getParameter("descripton"));
                game.setFeature1(request.getParameter("feature1"));
                game.setFeature2(request.getParameter("feature2"));
		//hero.setName(request.getParameter("name"));
		//hero.setDescription(request.getParameter("description"));
		//hero.setPlay(request.getParameter("play"));
		String ins = (String) request.getParameter("ins");
		Logger.getLogger(getClass().getName()).log(Level.INFO,
				"Insert Flag: " + ins);
		System.out.println("MESSAGE");
		//if (ins.equalsIgnoreCase("true")) {
			gm.insertGame(game);
		//} else {
			//gm.updateGame(game);
		//}
		ArrayList<GameDTO> data = gm.findAllGame();
		request.setAttribute("game", data);
		RequestDispatcher rd = request.getRequestDispatcher("GameSelect.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}