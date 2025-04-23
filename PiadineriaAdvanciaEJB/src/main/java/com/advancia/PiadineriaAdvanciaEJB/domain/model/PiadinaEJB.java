package com.advancia.PiadineriaAdvanciaEJB.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class PiadinaEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NonNull
	private String name;

	@NonNull
	private DoughEJB dough;

	@NonNull
	private Set<MeatBaseEJB> meatBase;

	@NonNull
	private Set<SaucesEJB> sauces;

	@NonNull
	private Set<OptionalElementsEJB> optionalElements;

	@NonNull
	private double price;

	@NonNull
	private EmployeeEJB employee;
}