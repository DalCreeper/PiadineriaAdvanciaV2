package com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PIADINA")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class PiadinaEJB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private int id;

	@NonNull
	@Column(name = "NAME")
	private String name;

	@NonNull
	@ManyToOne
    @JoinColumn(name = "DOUGH_ID")
	private DoughEJB dough;

	@NonNull
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "PIADINA_MEATBASE",
        joinColumns = @JoinColumn(name = "PIADINA_ID"),
        inverseJoinColumns = @JoinColumn(name = "MEATBASE_ID")
    )
	private Set<MeatBaseEJB> meatBase;

	@NonNull
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "PIADINA_SAUCES",
        joinColumns = @JoinColumn(name = "PIADINA_ID"),
        inverseJoinColumns = @JoinColumn(name = "SAUCES_ID")
    )
	private Set<SaucesEJB> sauces;

	@NonNull
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "PIADINA_OPTIONAL_ELEMENTS",
        joinColumns = @JoinColumn(name = "PIADINA_ID"),
        inverseJoinColumns = @JoinColumn(name = "OPTIONAL_ELEMENTS_ID")
    )
	private Set<OptionalElementsEJB> optionalElements;

	@NonNull
	@Column(name = "PRICE")
	private double price;

	@NonNull
	@ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
	private EmployeeEJB employee;
}