package com.advancia.PiadineriaAdvanciaWEB.application.model;

import lombok.Data;

import java.util.List;

@Data
public class PiadinaDeserialize {
	private String name;
	private int dough;
	private List<Integer> meatBase;
	private List<Integer> sauces;
	private List<Integer> optionalElements;
	private double price;
	private String user;
}
