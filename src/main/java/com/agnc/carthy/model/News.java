package com.agnc.carthy.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.i18n.LocaleContextHolder;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class News extends TextEntity{
	
	@NotEmpty
	@Column(length = 50)
	private String title;
		
	@Column(length = 50)
	private String auteur;
	
	@NotNull
	@Column
	private Date date;
	
	@NotEmpty
	@Basic(fetch = FetchType.LAZY)
	@Column
	@Type(type="text")
	private String text;
	
	@NotEmpty
	@NotNull
	@Column(length = 7)
	private String lang;
	
	@NotNull
	@Column
	private EnumCategoryTheme categoryTheme;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "text", orphanRemoval=true, cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	
	
	public News(){
		super();
		date = new Date();
		//imgURLS = new LinkedList<String>();
		comments = new LinkedList<Comment>();	
	}
	
	public void addComment(Comment comment){
		comments.add(comment);
	}
	

	public void removeComment(Comment comment){
		
		Comment commentList = comments.get(comments.indexOf(comment));
		commentList.removeText();
		commentList.removeUser();
		comments.remove(comment);
	}



/*	public void addImgURLS(String URL) {
		imgURLS.add(URL);
	}


	public void removeImage(String URL){
		imgURLS.remove(URL);
	}*/
	
	public int getNbComments() {
		Locale locale = LocaleContextHolder.getLocale();
		String lang = locale.getLanguage();
		int n = 0;

		for(Comment c : comments){
			if(c.getLang().equals(lang)){
				n++;
			}
		}

		return n;
	}
	
}
