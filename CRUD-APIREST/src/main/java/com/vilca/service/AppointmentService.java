package com.vilca.service;

import com.vilca.DTO.AppointmentDTO;
import com.vilca.entity.Appointment;
import com.vilca.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<AppointmentDTO> listar() {
        return appointmentRepository.findAll().stream()
            .map(this::convertToDTO)
            .collect(Collectors.toList());
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO();
        dto.setCodcit(appointment.getCodcit());
        dto.setDates(appointment.getDates());
        dto.setHour(appointment.getHour());
        dto.setEstado(appointment.getEstado());
        dto.setFechaCreate(appointment.getFechaCreate());
        dto.setPatientName(appointment.getCustomer().getNombrep() + " " + appointment.getCustomer().getApellidop());
        dto.setDoctorName(appointment.getDoctor().getNomdoc() + " " + appointment.getDoctor().getApedoc());
        dto.setSpecialtyName(appointment.getSpecialty().getNombrees());
        return dto;
    }

    public Appointment guardar(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
    
    public Optional<Appointment> obtener(Integer id) {
        return appointmentRepository.findById(id);
    }
    
    public void eliminar(Integer id) {
        appointmentRepository.deleteById(id);
    }

    // UPDATE
    public Appointment actualizar(Appointment citaActualizada) {
        return appointmentRepository.save(citaActualizada);
    }
    
}