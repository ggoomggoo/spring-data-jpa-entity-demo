package com.example.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@RequiredArgsConstructor
@Getter @Setter
@ToString
public class Hobby {
	
	@Id
	private Long id;
	
	@ManyToMany(mappedBy="hobbies")
	private Set<Emp> emps;

}
