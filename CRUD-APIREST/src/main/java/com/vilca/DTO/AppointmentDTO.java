package com.vilca.DTO;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class AppointmentDTO {
    private Integer codcit;
    private Date dates;
    private Time hour;
    private String estado;
    private Timestamp fechaCreate;
    private String patientName;
    private String doctorName;
    private String specialtyName;

    public Integer getCodcit() {
		return codcit;
	}
	public void setCodcit(Integer codcit) {
		this.codcit = codcit;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	public Time getHour() {
		return hour;
	}
	public void setHour(Time hour) {
		this.hour = hour;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Timestamp getFechaCreate() {
		return fechaCreate;
	}
	public void setFechaCreate(Timestamp fechaCreate) {
		this.fechaCreate = fechaCreate;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialtyName() {
		return specialtyName;
	}
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
    

    
}