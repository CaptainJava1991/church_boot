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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.i18n.LocaleContextHolder;


@Entity
@Table(name = "MESSAGETEXT")
public class MessageText extends TextEntity{
	
	@NotEmpty
	@Column(length = 50)
	private String titleEn;
	
	@NotEmpty
	@Column(length = 50)
	private String titleIn;
	
	@NotEmpty
	@Column(length = 50)
	private String titleFr;
		
	@Column(length = 50)
	private String auteur;
	
	@NotNull
	@Column
	private Date date;
	
	@NotEmpty
	@Basic(fetch = FetchType.LAZY)
	@Column
	@Type(type="text")
	private String textEn;
	
	@NotEmpty
	@Basic(fetch = FetchType.LAZY)
	@Column
	@Type(type="text")
	private String textIn;
	
	@NotEmpty
	@Basic(fetch = FetchType.LAZY)
	@Column
	@Type(type="text")
	private String textFr;
	
	@NotNull
	@Column
	private EnumCategoryTheme categoryTheme;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "text", orphanRemoval=true, cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	
	
	public MessageText(){
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



/*	public List<String> getImgURLS() {
		return imgURLS;
	}


	public void addImgURLS(String URL) {
		imgURLS.add(URL);
	}


	public void removeImage(String URL){
		imgURLS.remove(URL);
	}*/
	
	public int getNbComments() {
		
		return comments.size();

	}


	public EnumCategoryTheme getCategoryTheme() {
		return categoryTheme;
	}


	public void setCategoryTheme(EnumCategoryTheme categoryTheme) {
		this.categoryTheme = categoryTheme;
	}
	
	public String getTitle(){
		Locale locale = LocaleContextHolder.getLocale();
		String language = locale.getLanguage();
		
		if(language.equals("en")){
			return getTitleEn();
		}else if(language.equals("in")){
			return getTitleIn();
		}else{
			return getTitleFr();
		}
	}

	public String getTitleEn() {
		return titleEn;
	}


	public void setTitleEn(String titleEn) {
		this.titleEn = titleEn;
	}


	public String getTitleIn() {
		return titleIn;
	}


	public void setTitleIn(String titleIn) {
		this.titleIn = titleIn;
	}


	public String getTitleFr() {
		return titleFr;
	}


	public void setTitleFr(String titleFr) {
		this.titleFr = titleFr;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteurFr) {
		this.auteur = auteurFr;
	}
	
	public Date getDate(){
		return date;
	}
	
	public String getText(){
		Locale locale = LocaleContextHolder.getLocale();
		String language = locale.getLanguage();
		
		if(language.equals("en")){
			return getTextEn();
		}else if(language.equals("in")){
			return getTextIn();
		}else{
			return getTextFr();
		}
	}


	public String getTextEn() {
		return textEn;
	}


	public void setTextEn(String textEn) {
		this.textEn = textEn;
	}


	public String getTextIn() {
		return textIn;
	}


	public void setTextIn(String textIn) {
		this.textIn = textIn;
	}


	public String getTextFr() {
		return textFr;
	}


	public void setTextFr(String textFr) {
		this.textFr = textFr;
	}
	


	public List<Comment> getComments() {
		return comments;
	}



}
