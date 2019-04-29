package ru.softwerke.practice.app2019.model;

import com.fasterxml.jackson.annotation.JsonValue;

public class ColorRGB implements Comparable{
	private int R;
	private int G;
	private int B;
	public int RGB;
	public String name;
	public static ColorRGB[] standartColors=new ColorRGB[] {
			new ColorRGB("BLACK",0,0,0),
			new ColorRGB("WHITE",255,255,255),
			new ColorRGB("GREY",128,128,128),
			new ColorRGB("GREEN",0,255,0),
			new ColorRGB("RED",255,0,0),
			new ColorRGB("GOLD",255,215,0),
			new ColorRGB("BLUE",0,0,255),
			new ColorRGB("SILVER",192,192,192),
			new ColorRGB("BROWN",150,75,0),
			new ColorRGB("ORANGE",255,165,0),
			new ColorRGB("BEIGE",245,245,220),
			new ColorRGB("YELLOW",255,255,0),
			new ColorRGB("BLUE",66,170,255),
			new ColorRGB("PURPLE",139,0,255),
			new ColorRGB("PINK",252,15,192)};
			
	
	
	
	 
	 public ColorRGB() {
		 
	 }
	 
	 public ColorRGB(int colorRGB) {
		 RGB=colorRGB;
		 B=colorRGB& 0x000000FF;
		 colorRGB>>>=8;
		 G=colorRGB& 0x000000FF;
		 colorRGB>>>=8;
		 R=colorRGB& 0x000000FF;
		 
	 }
	 
	 public ColorRGB(String name,int R,int G,int B) {
		 this.name=name;
		 this.R=R;
		 this.G=G;
		 this.B=B;
		 this.RGB=getIntFromColor(R,G,B);
	 }
	 
	 public ColorRGB(String ColorRGB) {
		for(int i=0;i<standartColors.length;i++) {
			if(ColorRGB.equals(standartColors[i].name)){
				this.name=ColorRGB;
				this.R=standartColors[i].R;
				this.G=standartColors[i].G;
				this.B=standartColors[i].B;
				this.RGB=standartColors[i].RGB;
				return;
			}	
		}
		this.name="Undefined";
		this.RGB=-1;
		
	 }
	 
	@JsonValue 
	public Integer intValue() {
	return RGB;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
        if (!(obj instanceof ColorRGB)) return false;
        ColorRGB color = (ColorRGB) obj;
		return RGB==color.RGB;
	}
	
	
	public Integer getIntFromColor(int Red, int Green, int Blue){
	    Red = (Red << 16) & 0x00FF0000; //Shift red 16-bits and mask out other stuff
	    Green = (Green << 8) & 0x0000FF00; //Shift Green 8-bits and mask out other stuff
	    Blue = Blue & 0x000000FF; //Mask out anything not blue.

	    return  Red | Green | Blue; //0xFF000000 for 100% Alpha. Bitwise OR everything together.
	}

	@Override
	public int compareTo(Object obj) {
		return (new Integer(RGB)).compareTo(((ColorRGB) obj).intValue());
	}
}
