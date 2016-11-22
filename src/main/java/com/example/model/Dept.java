package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class Dept {
	private Long deptno;
	private String dname;
	private Set<Emp> emps;
	
	public Dept() {
	}
	
	public Dept(String dname) {
		super();
		this.dname = dname;
	}

	public Dept(String dname, Set<Emp> emps) {
		super();
		this.dname = dname;
		this.emps = emps;
	}

	@Id
	@GeneratedValue
	public Long getDeptno() {
		return deptno;
	}

	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@OneToMany(mappedBy="dept", cascade=CascadeType.ALL)
	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", emps=" + emps + "]";
	}
	
}
