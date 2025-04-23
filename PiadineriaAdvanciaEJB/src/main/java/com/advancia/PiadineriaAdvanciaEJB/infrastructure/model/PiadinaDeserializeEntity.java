package com.advancia.PiadineriaAdvanciaEJB.infrastructure.model;

import lombok.Data;

import java.util.List;

@Data
public class PiadinaDeserializeEntity {
	private String name;
	private int dough;
	private List<Integer> meatBase;
	private List<Integer> sauces;
	private List<Integer> optionalElements;
	private double price;
	private String user;
}