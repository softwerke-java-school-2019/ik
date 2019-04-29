package ru.softwerke.practice.app2019.model;

import com.fasterxml.jackson.annotation.JsonValue;

public class ColorName implements Comparable{
	private String name;
	
	public  ColorName(int colorRGB) {
			for(int i=0;i<ColorRGB.standartColors.length;i++) {
				if(colorRGB==ColorRGB.standartColors[i].RGB){
					this.name=ColorRGB.standartColors[i].name;
					return;
				}
				
		  }
		  this.name="Undefined";	
	}
		
		
	 public  ColorName(String name) {
		  for(int i=0;i<ColorRGB.standartColors.length;i++) {
				if(name.equals(ColorRGB.standartColors[i].name)){
					this.name=name;
					return;
				}
				
		  }
		  this.name="Undefined";	  	
	}
	  
	  
	@JsonValue
	@Override
	public String toString() {
		return name;
	}
		
	
	@Override
	public boolean equals(Object obj) {
			if (this == obj) return true;
	        if (!(obj instanceof ColorName)) return false;
	        ColorName color = (ColorName) obj;
			return name.equals(color.name);
	}


	@Override
	public int compareTo(Object obj) {
		return name.compareTo(((ColorName) obj).toString());
	}
	

}


























