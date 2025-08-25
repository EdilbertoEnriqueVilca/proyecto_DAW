package com.vilca.entity;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "specialty")
@Data
@NoArgsConstructor
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codespe")
    private Integer codespe;

    @Column(name = "nombrees", nullable = false, length = 50)
    private String nombrees;

    @CreationTimestamp
    @Column(name = "fecha_create", nullable = false, updatable = false)
    private Timestamp fechaCreate;

	public Integer getCodespe() {
		return codespe;
	}

	public void setCodespe(Integer codespe) {
		this.codespe = codespe;
	}

	public String getNombrees() {
		return nombrees;
	}

	public void setNombrees(String nombrees) {
		this.nombrees = nombrees;
	}

	public Timestamp getFechaCreate() {
		return fechaCreate;
	}

	public void setFechaCreate(Timestamp fechaCreate) {
		this.fechaCreate = fechaCreate;
	}
/*
	public Specialty(Integer codespe, String nombrees, Timestamp fechaCreate) {
		super();
		this.codespe = codespe;
		this.nombrees = nombrees;
		this.fechaCreate = fechaCreate;
	}   
  */
	
}
