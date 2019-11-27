
package acme.entities.messages;

import java.util.Date;
import java.util.List;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.framework.entities.DomainEntity;

public class MessageThreads extends DomainEntity {

	//Serialization identifier -----------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				moment;

	@NotBlank
	private List<String>		users;

	@NotBlank
	private List<Message>		messages;

}
