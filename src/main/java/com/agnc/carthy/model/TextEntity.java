package com.agnc.carthy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Entity
public class TextEntity extends BaseEntity {
	
    public void addComment(Comment comment){}
    
}
