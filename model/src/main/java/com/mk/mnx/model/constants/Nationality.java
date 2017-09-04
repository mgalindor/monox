package com.mk.mnx.model.constants;

public enum Nationality {
	
	AU("Australia"), BR("Brazil"), CA("Canada"), CH("Switzerland"), DE("Germany"), 
	DK("Denmark"), ES("Spain"), FI("Finland"), FR("France"), 
	GB("United Kingdom"), IE("Ireland"), IR("Iran"), NL("Netherlands"), 
	NZ("New Zealand"), TR("Turkey"), US("United States") , 
	
	;
	
	private String name;
	
	Nationality(String name) {
		this.name=name;	
	}
	
	public String getName() {
		return name;
	}
	 
	public static Nationality find(String name) {
		Nationality  n = null;
		for(Nationality a : Nationality.values()) {
			if(a.getName().equals(name)) {
				n = a;
				break;
			}
		}
		return n;
	} 
	
	

}
