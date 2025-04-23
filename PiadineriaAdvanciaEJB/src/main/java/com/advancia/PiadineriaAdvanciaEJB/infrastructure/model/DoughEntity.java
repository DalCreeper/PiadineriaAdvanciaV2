package com.advancia.PiadineriaAdvanciaEJB.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DOUGH")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoughEntity implements Serializable {
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
}