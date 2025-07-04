package com.advancia.PiadineriaAdvanciaEJB.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "OPTIONAL_ELEMENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionalElementsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICE")
	private double price;

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		OptionalElementsEntity optionalElementsEntity = (OptionalElementsEntity) o;
		return id == optionalElementsEntity.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
