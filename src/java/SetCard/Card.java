/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SetCard;

public class Card {
	private String shading;
	private String symbols;
	private String color;
	private String number;
        //private String url;
	
	public Card(String shading,String symbols,String color,String number){//, String url){
		this.shading=shading;
		this.symbols=symbols;
		this.color=color;
		this.number=number;
                //this.url = url;
	}

    //public String getUrl() {
        //return url;
    //}

          

	public String getShading() {
		return shading;
	}

	public String getSymbols() {
		return symbols;
	}

	public String getColor() {
		return color;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return shading +symbols + color + number ;//url;
	}	

}

