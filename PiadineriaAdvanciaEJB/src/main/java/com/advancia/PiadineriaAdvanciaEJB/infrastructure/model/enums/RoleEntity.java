package com.advancia.PiadineriaAdvanciaEJB.infrastructure.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@Getter
@AllArgsConstructor
public enum RoleEntity {
	OWNER("Owner"),
	COOK("Cook"),
	COUNTER_STAFF("Counter Staff"),
	CASHIER("Cashier"),
	WAITER("Waiter"),
	CLEANING_STAFF("Cleaning Staff");
	
	private final String raw;

    public static RoleEntity random() {
		Random rand = new Random();
		return RoleEntity.values()[rand.nextInt(RoleEntity.values().length)];
	}

	public static RoleEntity getEnumText(String text) {
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