package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="emp")
@RequiredArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
public class Emp {
	
	@Id
	@GeneratedValue
	private Long empno;
	
	private String ename;
	
	@ManyToOne
	@JoinColumn(name="deptno") // 생략시 name="dept_deptno"
	private Dept dept;

	public Emp(String ename) {
		super();
		this.ename = ename;
	}
	
}
