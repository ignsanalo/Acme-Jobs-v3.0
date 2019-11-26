
package acme.entities.roles;

import javax.validation.constraints.NotBlank;

import acme.framework.entities.UserRole;

public class Worker extends UserRole {

	//Serialization identifier --------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes ----------------------------------------------------------------------

	@NotBlank
	private String				qualifications;

	@NotBlank
	private String				skills;

}
