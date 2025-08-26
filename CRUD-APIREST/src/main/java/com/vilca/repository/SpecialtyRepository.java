package com.vilca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vilca.entity.Specialty;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer>{

}
