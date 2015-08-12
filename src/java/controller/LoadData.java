package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameDTO;
import bizlogic.GameManager;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class for Servlet: LoadData
 *
 */
@WebServlet("/loadservlet")
 public class LoadData extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;

	public LoadData() {
		super();
	}   	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}   	  
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		GameManager gm = new GameManager();
                String userid = "p3";
		ArrayList<GameDTO> data = gm.findAvailGame(userid);
		request.setAttribute("games", data);
		RequestDispatcher rd = request.getRequestDispatcher("GameSelect.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}