package com.dwes.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="subcriptors")
@Entity
public class Subcriptor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String address;
	@ManyToMany(mappedBy = "subcriptors")
	@JsonIgnore
	private List<Newspaper> newspaper = new ArrayList<Newspaper>();
	
	public Subcriptor(String name, String address) {
		this.name = name;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Subscriptor [id="+id+", name="+name+", address="+address+"]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Newspaper> getNewspaper() {
		return newspaper;
	}

	public void setNewspaper(List<Newspaper> newspaper) {
		this.newspaper = newspaper;
	}

	public Long getId() {
		return id;
	}

	public Subcriptor() {
		super();
	}
	
	
}
