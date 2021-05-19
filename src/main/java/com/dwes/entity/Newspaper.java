package com.dwes.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="newspapers")
@Entity
public class Newspaper {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="newspaper_subscriptor", 
	joinColumns=@JoinColumn(name="newspaper_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="subcriptor_id", referencedColumnName = "id"))
	@JsonIgnore
	private List<Subcriptor> subcriptors = new ArrayList<Subcriptor>();
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subcriptor> getSubcriptors() {
		return subcriptors;
	}

	public void setSubcriptors(List<Subcriptor> subcriptors) {
		this.subcriptors = subcriptors;
	}

	public Long getId() {
		return id;
	}

	public Newspaper(String name) {
		this.name = name;
	}

	public Newspaper() {
		super();
	}
	
	
	
	
}
