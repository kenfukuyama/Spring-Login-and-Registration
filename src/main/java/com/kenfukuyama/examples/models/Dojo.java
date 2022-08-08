package com.kenfukuyama.examples.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


//Domain Model
@Entity // Related to databases
@Table(name="dojos") // table name books
public class Dojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    

	// before it created
    @PrePersist 
    protected void onCreate(){
        this.createdAt = new Date();
    }
    // before it updates, null at first
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
    
    // one to one relationship
    @OneToMany(mappedBy="dojo", fetch=FetchType.LAZY)
    private List<Ninja> ninjas;
    
    
    
    // contructors
    public Dojo() {}
	public Long getId() {
		return id;
	}
	
	// getter and setter
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ninja> getNinjas() {
		return ninjas;
	}
	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
	

}
