package com.vilca.controller;
import org.springframework.dao.DataIntegrityViolationException; // Importa la excepción
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
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

import com.vilca.DTO.DoctorDTO;
import com.vilca.entity.Doctor;
import com.vilca.entity.Specialty;
import com.vilca.repository.DoctorRepository;
import com.vilca.repository.SpecialtyRepository;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

    private final SpecialtyRepository repoSpeci;
    private final DoctorRepository repoDoc;

    public DoctorController(DoctorRepository repoDoc, SpecialtyRepository repoSpeci) {
        this.repoDoc = repoDoc;
        this.repoSpeci = repoSpeci;
    }

    // TRAE LOS DATOS EN BRUTO
/*
    @GetMapping("/listar")
    public List<Doctor> listarDoctores() {
        return repoDoc.findAll();
    }
*/
    // TRAE LOS DATOS PERSONALIZADOS
    private DoctorDTO convertirADTO(Doctor doctor) {
        DoctorDTO dto = new DoctorDTO();
        dto.setCoddoc(doctor.getCoddoc());
        dto.setDnidoc(doctor.getDnidoc());
        dto.setNomdoc(doctor.getNomdoc());
        dto.setApedoc(doctor.getApedoc());
        dto.setCodespe(doctor.getCodespe());
        dto.setSexo(doctor.getSexo());
        dto.setTelefo(doctor.getTelefo());
        dto.setFechanaci(doctor.getFechanaci());
        dto.setCorreo(doctor.getCorreo());
        dto.setNaciona(doctor.getNaciona());
        dto.setEstado(doctor.getEstado());
        if (doctor.getSpecialty() != null) {
            dto.setNomEspecialidad(doctor.getSpecialty().getNombrees());
        }
        return dto;
    }

    @GetMapping
    public List<DoctorDTO> listarDoctorDTO() {
        return repoDoc.findAll().stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public String crearDoctor(@RequestBody Doctor doctor) {
        // Asegurarnos que la especialidad existe
        Specialty specialty = repoSpeci.findById(doctor.getCodespe())
                .orElseThrow(() -> new RuntimeException("La especialidad no existe"));
        doctor.setSpecialty(specialty);
        repoDoc.save(doctor);
        return "El Doctor ha sido creado con éxito.";
    }

    @PutMapping("/{coddoc}")
    public Doctor actualizar(@PathVariable Integer coddoc, @RequestBody Doctor d) {
        d.setCoddoc(coddoc);
        return repoDoc.save(d);
    }
/*
    @DeleteMapping("/{coddoc}")
    public void eliminar(@PathVariable Integer coddoc) {
        repoDoc.deleteById(coddoc);
    }*/
    
    @DeleteMapping("/{coddoc}")
    public ResponseEntity<String> eliminar(@PathVariable Integer coddoc) {
        try {
            repoDoc.deleteById(coddoc);
            return ResponseEntity.noContent().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("No se puede eliminar el doctor con código " + coddoc +
                          " porque tiene registros asociados (probablemente citas).");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al intentar eliminar el doctor: " + e.getMessage());
        }
    }
}