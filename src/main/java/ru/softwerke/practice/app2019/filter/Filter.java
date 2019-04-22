package ru.softwerke.practice.app2019.filter;

import java.util.UUID;

public interface Filter {
	public final static Filter EMPTY 
	     = new Filter() {
		public UUID getId() {
			return null;
		}
		public DeviceFilter withId(UUID id) {
			return null;
		}
	};
	public UUID getId();
	public Filter withId(UUID id);

}
