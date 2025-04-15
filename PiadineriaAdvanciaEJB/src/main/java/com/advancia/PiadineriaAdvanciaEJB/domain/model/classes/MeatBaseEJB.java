package com.advancia.PiadineriaAdvanciaEJB.domain.model.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeatBaseEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String type;
	private String description;
	private double price;

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		MeatBaseEJB meatBaseEJB = (MeatBaseEJB) o;
		return id == meatBaseEJB.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
