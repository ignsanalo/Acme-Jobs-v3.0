
package acme.entities.messages;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Message extends DomainEntity {

	//Serialization identifier -----------------------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes

	@NotBlank
	@Length(max = 255)
	private String				title;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	private Date				moment;

	@Length(max = 255)
	private String				tags;

	@NotBlank
	@Length(max = 255)
	private String				body;

}