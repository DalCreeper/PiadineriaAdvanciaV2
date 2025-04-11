package com.advancia.PiadineriaAdvanciaEJB.ejb.model.classes;

import com.advancia.PiadineriaAdvanciaEJB.ejb.model.enums.RoleEJB;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEE")
@XmlRootElement
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeEJB implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private int UID;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "SURNAME", nullable = false)
	private String surname;
	
	@Column(name = "USERNAME", nullable = false, unique = true)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "YOB", nullable = false)
	private int yob;
	
	@Column(name = "ROLE", nullable = false)
    private String roleRaw;
	
	@Transient
	private RoleEJB role;

	public RoleEJB getRole() {
		if(role == null && roleRaw != null) {
			role = RoleEJB.getEnumText(roleRaw);
		}
		return role;
	}

	public void setRole(RoleEJB role) {
		this.role = role;
		this.roleRaw = role != null ? role.getRaw() : null;
	}
}