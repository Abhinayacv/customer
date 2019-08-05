package com.crud.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="first")
public class Amodel {
	@Id
	@Column(name="id")
	
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="username")
	private String username;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}//using foreign key
	/*@OneToOne
	@JoinColumn(name="Bmodel_bid")*/
	/*
	 -------using join table
	 @OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name="Amodel_Bmodel", joinColumns = @JoinColumn(name="Amodel_id"),
	inverseJoinColumns = @JoinColumn(name="Bmodel_bid"))*/
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Bmodel bm;

	public Bmodel getBmodel() {
		return bm;
	}
	public void setBmodel(Bmodel bm) {
		this.bm = bm;
	}
	
}
