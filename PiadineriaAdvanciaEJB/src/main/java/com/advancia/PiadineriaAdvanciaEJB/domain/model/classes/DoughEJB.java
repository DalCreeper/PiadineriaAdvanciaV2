package com.advancia.PiadineriaAdvanciaEJB.domain.model.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoughEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String type;
	private String description;
	private double price;
}