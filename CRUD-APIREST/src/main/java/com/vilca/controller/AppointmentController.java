package com.vilca.controller;

import com.vilca.DTO.AppointmentDTO;
import com.vilca.entity.Appointment;

import com.vilca.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
   
    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> listar() {
        return ResponseEntity.ok(appointmentService.listar());
    }
    
    @GetMapping("/{codcit}")
    public ResponseEntity<Appointment> obtener(@PathVariable Integer codcit) {
        Optional<Appointment> appointment = appointmentService.obtener(codcit);
        return appointment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Appointment> guardar(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.guardar(appointment);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    @PutMapping("/{codcit}")
    public ResponseEntity<Appointment> actualizar(@PathVariable Integer codcit, @RequestBody Appointment appointment) {
        Optional<Appointment> existingAppointment = appointmentService.obtener(codcit);
        return existingAppointment.map(record -> {
            appointment.setCodcit(codcit); // Asegurar que el ID en la URL se use
            Appointment updatedAppointment = appointmentService.guardar(appointment);
            return ResponseEntity.ok(updatedAppointment);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{codcit}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer codcit) {
        if (appointmentService.obtener(codcit).isPresent()) {
            appointmentService.eliminar(codcit);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}