package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Addr;

public interface AddrRepository extends JpaRepository<Addr, Long> {
}
