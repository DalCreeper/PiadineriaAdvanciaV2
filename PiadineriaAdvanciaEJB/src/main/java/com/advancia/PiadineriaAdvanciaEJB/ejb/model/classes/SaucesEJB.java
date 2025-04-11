package com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "SAUCES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaucesEJB implements Serializable {
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
	    SaucesEJB saucesEJB = (SaucesEJB) o;
	    return id == saucesEJB.id;
	}

	@Override
	public int hashCode() {
	    return Objects.hash(id);
	}
}