package com.advancia.PiadineriaAdvanciaEJB.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public enum RoleEJB {
	OWNER("Owner"),
	COOK("Cook"),
	COUNTER_STAFF("Counter Staff"),
	CASHIER("Cashier"),
	WAITER("Waiter"),
	CLEANING_STAFF("Cleaning Staff");
	
	private final String raw;

    public static RoleEJB random() {
		Random rand = new Random();
		return RoleEJB.values()[rand.nextInt(RoleEJB.values().length)];
	}

	public static RoleEJB getEnumText(String text) {
    	switch(text) {
            case "Cook" :
	    		return COOK;
	    	case "Counter Staff" :
	    		return COUNTER_STAFF;
	    	case "Cashier" :
	    		return CASHIER;
	    	case "Waiter" :
	    		return WAITER;
	    	case "Cleaning Staff" :
	    		return CLEANING_STAFF;
			default :
				return OWNER;
    	}
    }
}