package com.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Role {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    @Column
    private String name;
    
    public Role() {
        super();
    }
    public Role(Long iD, String name) {
        super();
        ID = iD;
        this.name = name;
    }
    public Long getID() {
        return ID;
    }
    public void setID(Long iD) {
        ID = iD;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
            
}

