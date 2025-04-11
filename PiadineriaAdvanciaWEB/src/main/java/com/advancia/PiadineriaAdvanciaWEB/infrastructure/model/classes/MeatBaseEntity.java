package com.advancia.PiadineriaAdvanciaWEB.infrastructure.model.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeatBaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String type;
	private String description;
	private double price;
	
	@Override
	public boolean equals(Object o) {
	    if(this == o) return true;
	    if(o == null || getClass() != o.getClass()) return false;
	    MeatBaseEntity meatBaseEntity = (MeatBaseEntity) o;
	    return id == meatBaseEntity.id;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id);
	}
}
