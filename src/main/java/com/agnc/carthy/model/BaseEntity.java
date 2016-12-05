package com.agnc.carthy.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class BaseEntity{
    @Id
    @GeneratedValue
    private Long id;

    public boolean isNew(){
        return id == null;
    }
}