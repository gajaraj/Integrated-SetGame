/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetCard;

import java.io.IOException;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/gencard")
public class GenerateCards extends HttpServlet {
	String[]shading ={"solid","striped","outline"};
	String[]symbols={"squiggle","diamond","oval"};
	String[]color={"red","purple","green"};
	String [] number={"1","2","3"};       
	List<Card> l=new ArrayList<Card>();
	List<Card> table=new ArrayList<Card>();
	List<setItem> goodset=new ArrayList<setItem>();
	List<setItem> userSI= new ArrayList<setItem>();
        Map<String,List> map =new HashMap();
        Map<String,List> fmap =new HashMap();
        Map<String,List<setItem>> map2 =new HashMap();

//	Method to generate cards: total 81 cards
	public void generateCard(){
		for(int i=0;i<3;i++){
			String cShading=shading[i];
			for(int k=0;k<3;k++){
				String cSymbols=symbols[k];
				for(int n=0;n<3;n++){
					String cColor=color[n];
					for(int m=0;m<3;m++){
						String cNumber=number[m];
                                                //String cUrl = url[m];
//                      This output is for testing
//                      System.out.println(z + ". "+cShading+cSymbols+cColor+cNumber); z++;
						//This one is for store the String info into l 
						//String s= cShading+cSymbols+cColor+cNumber;
						Card a =new Card(cShading,cSymbols,cColor,cNumber);
						l.add(a);                    
					}

				}                  
			}			
		}//		
	}

        public void shuffle()
        {
            //Shuffle the Deck of cards
		Collections.shuffle(l);
        }

//	Find the number of set present in the table
	public void verifyTable(){
		
		boolean color=false;
		boolean shading=false;
		boolean symbols=false;
		boolean number=false;
		boolean gameSet=false;
		for(int i=0;i<12;i++){
			for(int k=i+1;k<12;k++){
			    for(int m=k+1;m<12;m++){
			    	if(table.get(i).getColor()!=table.get(k).getColor() && 
			    	   table.get(k).getColor()!=table.get(m).getColor()	
			    	   &&table.get(m).getColor()!=table.get(i).getColor()
			    	  )
			    	{
			    		color=true;
			    		
		    		}
			        else if(table.get(i).getColor()==table.get(k).getColor() && 
					    	   table.get(k).getColor()==table.get(m).getColor()	
					    	   &&table.get(m).getColor()==table.get(i).getColor())
			        {
			        	color=true;
			        }
			    	
			    	 if(table.get(i).getShading()!=table.get(k).getShading() && 
					    	   table.get(k).getShading()!=table.get(m).getShading()	
					    	   &&table.get(m).getShading()!=table.get(i).getShading()){shading=true;}
			    	
			        else if(table.get(i).getShading()==table.get(k).getShading() && 
					    	   table.get(k).getShading()==table.get(m).getShading()	
					    	   &&table.get(m).getShading()==table.get(i).getShading()){shading=true;}
			    	
			        if(table.get(i).getSymbols()!=table.get(k).getSymbols() && 
					    	   table.get(k).getSymbols()!=table.get(m).getSymbols()	
					    	   &&table.get(m).getSymbols()!=table.get(i).getSymbols()){symbols=true;}
			    	
			        else if(table.get(i).getSymbols()==table.get(k).getSymbols() && 
					    	   table.get(k).getSymbols()==table.get(m).getSymbols()	
					    	   &&table.get(m).getSymbols()==table.get(i).getSymbols()){symbols=true;}
			       
			        if(table.get(i).getNumber()!=table.get(k).getNumber() && 
					    	   table.get(k).getNumber()!=table.get(m).getNumber()	
					    	   &&table.get(m).getNumber()!=table.get(i).getNumber()){number=true;}
			       
			        else if(table.get(i).getNumber()==table.get(k).getNumber() && 
					    	   table.get(k).getNumber()==table.get(m).getNumber()	
					    	   &&table.get(m).getNumber()==table.get(i).getNumber()){number=true;}
			    	
    	
			    	if(color== true && shading== true && symbols== true && number==true){
			    		
			    		setItem s=new setItem(table.get(i),table.get(k),table.get(m));
			    		goodset.add(s);
			    		System.out.println((i+1)+" "+table.get(i).toString()+"  "+(k+1)+"  "+table.get(k).toString()+"  "+(m+1)+"  "+table.get(m).toString());
			    		
			    	}
			    	color=false;shading=false;symbols=false;number=false;
			    }		
			}
		}
            while(goodset.isEmpty())
            {
                add();
                shuffle();
                initialtable();
                verifyTable();
            }
	}
	
//	Create a table with 12 cards (first of 12 shuffles)
	public Map initialtable(){
//		Moving the cards from the deck to the table
		for(int i=0;i<12;i++){
			table.add(l.get(i));
//			Remove 12 cards from the Deck
			l.remove(i);
		}
                fmap.put("tList",table);
                fmap.put("lList",l);  
                return fmap;
	}
        
        public void initialtable2(int x,int y,int z){
//		Moving the cards from the deck to the table
		int i=0;
			table.add(x,l.get(i));
                        table.remove(x+1);
			l.remove(i);table.add(y,l.get(i+1));
                        table.remove(y+1);
			l.remove(i+1);table.add(z,l.get(i+2));
                        table.remove(z+1);
			l.remove(i+2);
		
	}

        //public void display(){
            
//		Moving the cards from the deck to the table
		//for(int i=0;i<12;i++){
			//System.out.print((i+1)+" "+table.get(i)+"\t\t\t\t");
                        //if((i+5)%4 == 0)
			//System.out.print("\n");                            
		//}
	//}
	
        public Map<String,List> check(Map<String,List> f, HttpSession count, HttpSession select)
        {
            if((int)count.getAttribute("gc"+(String)select.getAttribute("v"))== 0)
            {
                table = f.get("tList");
                l = f.get("lList");
            }
            else
            {
                table = f.get("gt"+(String)select.getAttribute("v"));
                l = f.get("gl"+(String)select.getAttribute("v"));
            }
            //while(!(l.isEmpty()))
            //{
            verifyTable();           
            //public Map<String,List<EmailUID>> getList()
                       
            //}
            map.put("emailList",table);
            map.put("eventList",l);           
            map.put("good",goodset);
            return map;

            //display(); 
            //getdetails();
            //goodset.clear();
            //}
            //System.out.println("Game over");
        }
        
        public void add()
        {
            for(int i=0;i<12;i++){
			l.add(table.get(0));
//			Remove 12 cards from the Deck
			table.remove(0);
            }
        }
        public void getdetails(int a, int b,int c, Map<String,List> map3, String v)
        {
           table = map3.get("gt"+v);
           goodset = map3.get("gg"+v);
           int[] i = new int[3];
           i[0] = a;
           i[1] = b;
           i[2] = c;
           
           Arrays.sort(i);
           System.out.println(table.size());
           for(int h=0;h<table.size();h++)
           //while(!table.isEmpty())
           {
           System.out.println(table.get(h));
           //h++;
           }
           setItem s=new setItem(table.get(i[0]-1),table.get(i[1]-1),table.get(i[2]-1));
           int value = verifyUserSelection(s, goodset);
           if(value == 1)
           {
          ////      System.out.println("One set found");
                initialtable2((i[0]-1),(i[1]-1),(i[2]-1));    
           }
           // else
           //     System.out.println("No sets found");
        }
        
//  To check the user selection with the set present in the 12 cards on table
	public int verifyUserSelection(setItem si,List<setItem> goodset){
		Iterator<setItem> it1 = goodset.iterator();
		while(it1.hasNext()){
			if( it1.next().compareTo(si)==1){
				userSI.add(si);
				return 1;
			}
		}
		return 0;
	}	
}

