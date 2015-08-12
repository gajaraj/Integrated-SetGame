/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginPackage;

//import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

@WebServlet("/loginuser")
public class LoginServlet extends HttpServlet {
    @EJB private LoginBean loginBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String username =req.getParameter("userid2");
        String password =req.getParameter("userpassword2");
        
        
        List<LOGINUSER> loginuser1 = loginBean.validate(username, password);
        String msg;
        
        resp.setContentType("text/plain");
        if(loginuser1.isEmpty()){//.getUserpassword().toString() != password.toString()){//
        //if (null == loginuser) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            msg = "Cannot find customer " + username;
        } else {
            //resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            //msg = loginuser1.toString();
            RequestDispatcher rd = req.getRequestDispatcher("/loadservlet"); //use the Webservlet Resource name i.e @Webservlet "/setcards"
            rd.forward(req, resp);
        }
        
        //try (PrintWriter pw = resp.getWriter()) {
           // pw.println(msg);
        //}
    }
}
