package com.crud.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="btable")
public class Bmodel {
	@Id
	@Column(name="id")
	private int bid;
	@Column(name="state")
	private String state;
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}//using foreign key
	/*@OneToOne(
	mappedBy="bm")*/
	@OneToOne(mappedBy="bm", cascade=CascadeType.ALL)
   private Amodel am;

public Amodel getAmodel() {
	return am;
}
public void setAmodel(Amodel am) {
	this.am = am;
}
	

}
