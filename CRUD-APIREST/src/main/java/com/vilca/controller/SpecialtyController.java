package com.vilca.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vilca.entity.Specialty;
//import com.vilca.repository.SpecialtyRepository;
import com.vilca.service.SpecialtyService;

@RestController
@RequestMapping("/specialties") 
@CrossOrigin(origins = "http://localhost:4200")
public class SpecialtyController {
	 @Autowired
	 private SpecialtyService service;
	 //private SpecialtyRepository specialtyRepository;
	 
	 /*
	 public SpecialtyController(SpecialtyRepository repoSpecis) {
		 this.service = repoSpecis;
	 }*/
	 
    @GetMapping
    public List<Specialty> listar(){
    	return service.listar();
    }
    
    @PostMapping
    public Specialty guardar(@RequestBody Specialty specialty) {
    	return service.guardar(specialty);
    }
        
    //llama por codigo
    @GetMapping("/{codespe}")
    public ResponseEntity<Specialty> obtener(@PathVariable Integer codespe) {
    	return service.obtener(codespe).map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{codespe}")
    public ResponseEntity<Specialty> actualizar (@PathVariable Integer codespe,@RequestBody Specialty specialty){
    	return service.obtener(codespe)
    			.map(record->{ 
    				record.setNombrees(specialty.getNombrees());
    				return ResponseEntity.ok(service.guardar(specialty));
    	}).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{codespe}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer codespe){
    	service.eliminar(codespe);
    	return ResponseEntity.noContent().build();
    }

	
}
