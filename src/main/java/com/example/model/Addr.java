package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class Addr {
	
	@Id
	private Long id;
	
	private String address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@MapsId
	@JoinColumn(name="empno")
	private Emp emp;

	public Addr(String address) {
		super();
		this.address = address;
	}

}
