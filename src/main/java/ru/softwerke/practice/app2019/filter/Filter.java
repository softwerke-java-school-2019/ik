package ru.softwerke.practice.app2019.filter;

import ru.softwerke.practice.app2019.model.Model;

//import java.util.UUID;

public abstract class Filter {
	public final static Filter EMPTY 
	     = new Filter() {
		public Integer getId() {
			return null;
		}
		public Filter withId(Integer id) {
			return null;
		}
	};
	public abstract Integer getId();
	public abstract Filter withId(Integer id);
	
	
	

}
