package com.kenfukuyama.examples.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



//Domain Model
@Entity // Related to databases
@Table(name="ninjas") // table name books
public class Ninja {		
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    
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
	
    
    // one to one relationsihp
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;

    // Empty contrsuctor
    public Ninja() {}
    
    // getter and setter
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Dojo getDojo() {
		return dojo;
	}
	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
    
    
    
	
	
	

}
