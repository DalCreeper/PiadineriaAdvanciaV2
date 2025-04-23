package com.advancia.PiadineriaAdvanciaEJB.domain.model;

import com.advancia.PiadineriaAdvanciaEJB.domain.model.enums.RoleEJB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	private int UID;
	private String name;
	private String surname;
	private String username;
	private String password;
	private int yob;
	private String roleRaw;
	private RoleEJB role;
}