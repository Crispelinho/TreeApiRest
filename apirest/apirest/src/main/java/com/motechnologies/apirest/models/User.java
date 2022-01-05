package com.motechnologies.apirest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Getter @Setter @NoArgsConstructor
public class User {
	@Id
    @GeneratedValue
    @Column(name = "ID")
	private Long id;

	private String name;
    
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
