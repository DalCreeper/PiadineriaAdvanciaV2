package com.advancia.PiadineriaAdvanciaWEB.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dough implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String type;
	private String description;
	private double price;
}