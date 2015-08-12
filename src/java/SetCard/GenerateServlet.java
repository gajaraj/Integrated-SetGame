/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetCard;

import bizlogic.GameManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.GameDTO;
import model.GameSearchDTO;
import model.PointDTO;

/**
 *
 * @author A0136420U
 */

@WebServlet("/setcard")
public class GenerateServlet extends HttpServlet {
        GenerateCards g=new GenerateCards();
        Map<String,List> map1=new HashMap();
        Map<String,List> fmap=new HashMap();
        List l=new ArrayList<Card>();
	List table=new ArrayList<Card>();
        Map<String,List> map;
        String v = "";
        int count;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int a =0,b =0,c=0;
        int count = 0;
        HttpSession gamesession = req.getSession(true);
        HttpSession selectsession = req.getSession(true);
        HttpSession countsession = req.getSession(true);
        v = req.getParameter("gameid"); 
        selectsession.setAttribute("v",v);
        GameManager gm = new GameManager();
	GameDTO game = new GameDTO();
        PointDTO point = new PointDTO();
        
        ArrayList<GameDTO> gameuser = gm.findGame(v);
        int gg = Integer.parseInt(gameuser.get(0).getFeature1());
        int uu = Integer.parseInt(gameuser.get(0).getUsers());
        String status="";
        if(gg-uu == 0)
            status = "true";
        else
             status = "false";
        
        GameSearchDTO gso = new GameSearchDTO();
			gso.setGameid(v);
			gso.setUserid("p3");
			GameManager hm = new GameManager();
			ArrayList<PointDTO> gamelist = hm.findGameByCriteria(gso); 
                        if(gamelist==null)
                        {
                            int us = (Integer.parseInt(gameuser.get(0).getUsers()))-1;
                            String uss = Integer.toString(us);
                            game.setGameid(v);
                            game.setDescription(gameuser.get(0).getDescription());
                            game.setFeature1(gameuser.get(0).getFeature1());
                            game.setFeature2(gameuser.get(0).getFeature2());
                            game.setUsers(uss);
                            gm.updateGame(game);
                            
                            point.setGameid(v);
                            point.setUserid("p3");//.set(req.getParameter("descripton"));
                            point.setPoint("0");//.setFeature1(req.getParameter("feature1"));
                            gm.insertPoint(point);
                        }
                        //else{}
        
        
        
        //try {
		//	if((int)countsession.getAttribute("gc"+v)== 0){}
                            
		//} catch (NullPointerException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
                //         countsession.setAttribute("gc"+v,count);
               // }
        //if(countsession.getAttribute("gc"+v).equals(null))
            
        if(status == "true")
        //if((req.getParameter("id1")== null)&&((int)countsession.getAttribute("gc"+v)== 0))
        {
            g.generateCard();
            g.shuffle();
            fmap = g.initialtable();  
        }
        
        else
        {
            v = (String)selectsession.getAttribute("v");
            map1 = (Map)gamesession.getAttribute("map");
            a = Integer.parseInt(req.getParameter("id1")); 
            b = Integer.parseInt(req.getParameter("id2")); 
            c = Integer.parseInt(req.getParameter("id3"));
            g.getdetails(a,b,c,map1,v);
        }
                  
       
       countsession.setAttribute("gc"+v,count); 
       if(status == "true")
       //if((int)countsession.getAttribute("gc"+v)== 0)
       {
            map = g.check(fmap, countsession, selectsession); 
            l = map.get("eventList");
            table = map.get("emailList");
            //count = count+1;
       }
       else
       {
           map1 = (Map)gamesession.getAttribute("map");
           map = g.check(map1, countsession, selectsession); 
           l = map.get("eventList");
           table = map.get("emailList");
           //count = count + 1;
       }
        //gamesession.setAttribute();
        map1.put("gt"+v,table);
        map1.put("gl"+v,l);
        map1.put("gg"+v,map.get("good")); 
        countsession.setAttribute("gc"+v,count);
        gamesession.setAttribute("map", map1);        
         
        while(!(l.isEmpty()))
            {
        
                req.setAttribute("cards", table);
		RequestDispatcher rd = req.getRequestDispatcher("game.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}           
            }
        
        
                //List<Card> tab = 
    }
   // public void display(List table){
         //       List<Card> tab =new ArrayList<Card>(); 
            //    tab = table;
   // }      //      
}