package com.markting.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.markting.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
