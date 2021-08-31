package com.thrillio.constants;

public enum Gender {
	MALE(0),
	FEMALE(1),
	TRANSGENDER(2);
    
	int index;
	private Gender(int index) 
	{
		this.index = index;
	}
	
	int getIndex() {
		return index;
	}
}
