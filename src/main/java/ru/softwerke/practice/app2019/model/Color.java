package ru.softwerke.practice.app2019.model;

import java.math.BigDecimal;

import ru.softwerke.practice.app2019.filter.DeviceFilter;

public enum Color {
    RED,
    BLACK,
    WHITE,
    BLUE,
    PINK,
    GREEN;
  public static Color getColor(String color) {
	   switch (color) {
       case "RED": {
       	
       return RED;
       }
       case "BLACK": {//Works not properly so far
       
       return BLACK;
       }
       case "WHITE": {
       	
       return WHITE;
       }
       case "BLUE": {
          	
       return BLUE;
       }
       case "PINK": {
          	
       return PINK;
       }
       case "GREEN": {
         	
       return GREEN;
       }
       default: {
       System.out.println("Wrong Entry, default value=BLACK");
       return BLACK;
          
       }
   }
   }
}
