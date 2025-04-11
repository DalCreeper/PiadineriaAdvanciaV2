package com.advancia.PiadineriaAdvanciaWEB.domain.model.classes;

import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Piadina implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NonNull
	private String name;

	@NonNull
	private Dough dough;

	@NonNull
	private Set<MeatBase> meatBase;

	@NonNull
	private Set<Sauces> sauces;

	@NonNull
	private Set<OptionalElements> optionalElements;

	@NonNull
	private double price;

	@NonNull
	private Employee employee;
}