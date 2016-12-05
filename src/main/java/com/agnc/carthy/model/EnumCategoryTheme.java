package com.agnc.carthy.model;

import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

public enum EnumCategoryTheme {
	PENSEEDUJOUR("THINK OF DAY","THINK OF DAY","PENS�E DU JOUR","PENSEEDUJOUR"),
	ACTUALITES("NEWS","NEWS","ACTUALIT�S","ACTUALITES"),
	PARENT("PARENTS","PARENTS","PARENTS","PARENT"),
	MUSIQUE("MUSIC","MUSIC","MUSIQUE","MUSIQUE"),
	ENSEIGNEMENT("EDUCATION","EDUCATION","ENSEIGNEMENT","ENSEIGNEMENT"),
	FEMME("WOMEN","WOMEN","FEMME","FEMME"),
	COUPLE("COUPLE","COUPLE","COUPLE","COUPLE"),
	TEMOIGNAGE("TESTIMONY","TESTIMONY","T�MOIGNAGE","TEMOIGNAGE"),
	SERVITEUR("SERVANT","SERVANT","SERVITEUR","SERVITEUR"),
	HOMME("MEN","MEN","HOMME","HOMME"),
	ENFANT("KID","KID","ENFANT","ENFANT"),
	JEUNE("YOUNG","YOUNG","JEUNE","JEUNE"),
	BIBLE("BIBLE","BIBLE","BIBLE","BIBLE");
	
	  private String textEn;
	  private String textIn;
	  private String textFr;
	  private String imgTheme;
	  

	  EnumCategoryTheme(String textEn, String textIn, String textFr, String imgTheme) {
	    this.textEn = textEn;
	    this.textIn = textIn;
	    this.textFr = textFr;
	    this.imgTheme = imgTheme;
	  }

	  public String toString() {
		Locale locale = LocaleContextHolder.getLocale();
		String language = locale.getLanguage();
		if(language.equals("en")){
			return this.textEn;
		}else if(language.equals("in")){
			return this.textIn;
		}else{
			return this.textFr;
		}
	  }
	  
	  public String getImgTheme(){
		  return imgTheme;
	  }

	  public static EnumCategoryTheme fromString(String text) {
	    if (text != null) {
	      for (EnumCategoryTheme b : EnumCategoryTheme.values()) {
	        if (text.equalsIgnoreCase(b.textEn)) {
	          return b;
	        }
	      }
	    }
	    return null;
	  }
}
