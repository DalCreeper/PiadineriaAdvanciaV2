package com.advancia.PiadineriaAdvanciaWEB.infrastructure.model.classes;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class PiadinaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@NonNull
	private String name;

	@NonNull
	private DoughEntity doughEntity;

	@NonNull
	private Set<MeatBaseEntity> meatBaseEntity;

	@NonNull
	private Set<SaucesEntity> sauces;

	@NonNull
	private Set<OptionalElementsEntity> optionalElementEntities;

	@NonNull
	private double price;

	@NonNull
	private EmployeeEntity employeeEntity;
}