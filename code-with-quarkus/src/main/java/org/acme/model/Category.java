package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {
    
    @Id
    public int id_category;
    public String name;
    public String wording;

    public Category() {
        
    }

    public Category(int id_category, String name, String wording){
        this.id_category = id_category;
        this.name = name;
        this.wording = wording;
    }
}
