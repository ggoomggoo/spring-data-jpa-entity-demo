package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="dept")
@RequiredArgsConstructor
@Getter
@Setter
@ToString(exclude={"emps"}) // 
public class Dept {
	
	@Id
	@GeneratedValue
	private Long deptno;
	
	@NonNull
	private String dname;
	
	@NonNull
	@OneToMany(mappedBy="dept", cascade=CascadeType.ALL)
	private Set<Emp> emps;

	public Dept(String dname) {
		super();
		this.dname = dname;
	}
	
}
