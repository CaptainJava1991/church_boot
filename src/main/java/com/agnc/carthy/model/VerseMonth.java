package com.agnc.carthy.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class VerseMonth extends BaseEntity {
	@NotEmpty(message = "Not Empty")
	@Column
	private String textEn;
	
	@NotEmpty(message = "Not Empty")
	@Column
	private String textIn;
	
	@NotEmpty(message = "Not Empty")
	@Column
	private String textFr;
	
	@NotEmpty(message = "Not Empty")
	@Column
	private String sourceEn;
	
	@NotEmpty(message = "Not Empty")
	@Column
	private String sourceIn;
	
	@NotEmpty(message = "Not Empty")
	@Column
	private String sourceFr;	
}
