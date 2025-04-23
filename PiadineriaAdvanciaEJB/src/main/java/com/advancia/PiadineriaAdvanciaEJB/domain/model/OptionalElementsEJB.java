package com.advancia.PiadineriaAdvanciaEJB.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionalElementsEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String type;
	private String description;
	private double price;

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		OptionalElementsEJB optionalElementsEJB = (OptionalElementsEJB) o;
		return id == optionalElementsEJB.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}