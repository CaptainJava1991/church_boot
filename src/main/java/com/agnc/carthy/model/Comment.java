package com.agnc.carthy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import com.church.validator.ValidEmail;
import com.church.validator.ValidName;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Comment extends BaseEntity {
	
	@ManyToOne(fetch = FetchType.LAZY) 
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	private TextEntity text;
	
	@Column
	private String imgURL;
	
	@ValidName
	@Column(length = 50)
	private String name;
	
	@ValidEmail
	@Column(length = 50)
	private String mail;
	
	@NotNull
	@Column
	private Date date;
	
	@NotEmpty
	@Column
	@Type(type = "text")
	private String comment;
	
	@Column
	private boolean approved;
	
	@NotNull
	@Column(length = 7)
	private String lang;

	
	public Comment(){
		date = new Date();
		approved = false;
	}
	
	public void setUser(User user) {
		this.user = user;
		user.addComment(this);

	}
	
	public void removeUser(){
		this.user = null;
	}

	public void setText(TextEntity text) {
		this.text = text;
		text.addComment(this);
	}

	public void removeText(){
		this.text = null;
	}	
}
