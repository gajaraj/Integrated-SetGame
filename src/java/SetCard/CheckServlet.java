/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check")
public class CheckServlet extends HttpServlet {
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a =0,b =0,c=0;
        GenerateCards g=new GenerateCards();
        a = Integer.parseInt(req.getParameter("id1")); 
        b = Integer.parseInt(req.getParameter("id2")); 
        c = Integer.parseInt(req.getParameter("id3"));
        //g.getdetails(a,b,c);
    }
}
