/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetCard;

/**
 *
 * @author Gajaraj Sekar
 */
public class setItem implements Comparable<setItem > {
    
	private Card a;
	private Card b;
	private Card c;
	
	public setItem(Card a,Card b,Card c){
		this.a=a;
		this.b=b;
		this.c=c;
	}

	public Card getA() {
		return a;
	}

	public Card getB() {
		return b;
	}

	public Card getC() {
		return c;
	}

	@Override
	public int compareTo(setItem o) {
		if(this.getA().getShading()==o.getA().getShading() && 
		   this.getB().getShading()==o.getB().getShading() &&
		   this.getC().getShading()==o.getC().getShading() &&
		   this.getA().getSymbols()==o.getA().getSymbols() &&
	       this.getB().getSymbols()==o.getB().getSymbols() &&
	       this.getC().getSymbols()==o.getC().getSymbols() &&
	       this.getA().getColor()==o.getA().getColor() &&
	       this.getB().getColor()==o.getB().getColor() &&
	       this.getC().getColor()==o.getC().getColor() &&
	       this.getA().getNumber()==o.getA().getNumber() &&	
	       this.getB().getNumber()==o.getB().getNumber() &&	
	       this.getC().getNumber()==o.getC().getNumber() )
		{return 1;}
		
		return 0;
	}
}
