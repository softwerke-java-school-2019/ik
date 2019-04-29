package ru.softwerke.practice.app2019.model;


import com.fasterxml.jackson.annotation.JsonValue;

public class DeviceTypeName implements Comparable{
	private String name;
    
  public  DeviceTypeName(String name) {
    	switch(name) {
		case "Smartphone":
			this.name="Smartphone";
			break;
		case "Laptop":
			this.name="Laptop";
			break;
		case "Smart Watches":
			this.name="Smart Watches";
			break;
		case "Tablet":
			this.name="Tablet";
			break;
		default:
			this.name="NON-EXISTENT";
			break; 
		
	    }
    	//this.name="NONE";
	}
	@JsonValue
	@Override
    public String toString() {
		return name;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
        if (!(obj instanceof DeviceTypeName)) return false;
        DeviceTypeName deviceType = (DeviceTypeName) obj;
		return name.equals(deviceType.toString());
	}
	@Override
	public int compareTo(Object obj) {
		return name.compareTo(((DeviceTypeName) obj).toString());
	}
	
	

}





