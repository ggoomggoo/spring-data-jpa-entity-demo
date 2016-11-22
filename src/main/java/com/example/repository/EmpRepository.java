package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Emp;

public interface EmpRepository extends JpaRepository<Emp, Long> {
}
