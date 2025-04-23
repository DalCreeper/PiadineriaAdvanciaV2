package com.advancia.PiadineriaAdvanciaEJB.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class PiadinaDeserializeEJB {
	private String name;
	private int dough;
	private List<Integer> meatBase;
	private List<Integer> sauces;
	private List<Integer> optionalElements;
	private double price;
	private String user;
}