
package acme.entities.messages;

import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.SafeHtml.Tag;

import acme.framework.entities.DomainEntity;

public class Message extends DomainEntity {

	//Serialization identifier -----------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes

	@NotBlank
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				moment;

	@ManyToOne(optional = false)
	private List<Tag>			tags;

	@NotBlank
	private String				body;

}
