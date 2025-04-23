package com.advancia.PiadineriaAdvanciaWEB.application.model;

import com.advancia.PiadineriaAdvanciaWEB.application.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	private int UID;
	private String name;
	private String surname;
	private String username;
	private String password;
	private int yob;
    private String roleRaw;
	private Role role;

	public Role getRole() {
		if(role == null && roleRaw != null) {
			role = Role.getEnumText(roleRaw);
		}
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
		this.roleRaw = role != null ? role.getRaw() : null;
	}
}