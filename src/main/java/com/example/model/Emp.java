package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Emp {
	
	//
	// field
	// 
	
	private Long empno;
	private String ename;
	private Dept dept;
	
	// 
	// cunstructor
	// 
	
	public Emp() {
	}

	public Emp(String ename) {
		super();
		this.ename = ename;
	}

	public Emp(String ename, Dept dept) {
		super();
		this.ename = ename;
		this.dept = dept;
	}
	
	// 
	// 
	// 

	@Id
	@GeneratedValue
	public Long getEmpno() {
		return empno;
	}

	public void setEmpno(Long empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@ManyToOne
	@JoinColumn(name="deptno") // 생략시 name="dept_deptno"
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
	
	// 
	// 
	// 

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", dept=" + dept + "]";
	}
	
}
