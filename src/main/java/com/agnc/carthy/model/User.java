package com.agnc.carthy.model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import org.springframework.security.core.userdetails.UserDetails;

import com.church.validator.ValidName;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity implements Serializable, UserDetails {
	
	@Column
	private String imgURL;
	
	@ValidName(message = "Erreur Name")
	@Column(nullable = false, length = 50)
	private String username;
	
	@ValidName(message = "Erreur Fristame")
	@Column(nullable = false, length = 50)
	private String firstname;
		
	@NotEmpty
	@Column(unique = true, length = 50)
	private String mail;

	@Size(min = 4)
	@Column(nullable = false, length = 50)
	private String password;
	
	@Column
	private String phone;
	
	@Column(nullable = false)
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "user")
	private List<Comment> comments;
	
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Authority> authorities = new ArrayList<>();
	
	public User(){
		comments = new LinkedList<Comment>();
		enabled = false;
	}
	
	@Override
	public boolean equals(Object obj) {
		User user = null;
		try{
			user = (User) obj;
		}catch(Exception e){
			e.printStackTrace();
		}
		if(user != null){
			return getId() == user.getId();
		}
		return false;
	}
	
	public void addComment(Comment comment){
		comments.add(comment);
	}
	
	public void removeComment(Comment comment){
		Comment commentList = comments.get(comments.indexOf(comment));
		commentList.removeUser();
		commentList.removeText();
		comments.remove(comment);
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}
}
