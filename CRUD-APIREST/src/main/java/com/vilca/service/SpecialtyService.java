package com.vilca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vilca.entity.Specialty;
import com.vilca.repository.SpecialtyRepository;

@Service
public class SpecialtyService {

	@Autowired
	private SpecialtyRepository repo;
	
	public List<Specialty> listar(){
		return repo.findAll();
	}
	
	public Specialty guardar(Specialty s) {
		return repo.save(s);
	}
	
	public void eliminar(Integer id) {
		repo.deleteById(id); 
	}
	
	public Optional<Specialty> obtener(Integer id){
		return repo.findById(id);
	}
	
}
