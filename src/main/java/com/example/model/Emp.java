package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import lombok.Getter;
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
	
	@ManyToMany(cascade={
					CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
			})
	@JoinTable(
			name="emp_hobby",
			joinColumns=@JoinColumn(
					name="emp_id",
					referencedColumnName="empno"
					),
			inverseJoinColumns=@JoinColumn(
					name="hobby_id",
					referencedColumnName="id"
					)
			)
	private List<Hobby> hobbies;

	public Emp(String ename) {
		super();
		this.ename = ename;
	}
	
}
