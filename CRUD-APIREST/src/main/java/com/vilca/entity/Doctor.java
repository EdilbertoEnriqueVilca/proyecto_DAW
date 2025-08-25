package com.vilca.entity;

import java.sql.Date;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "doctor")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coddoc")
    private Integer coddoc;

    @Column(name = "dnidoc", nullable = false, length = 8)
    private String dnidoc;

    @Column(name = "nomdoc", nullable = false, length = 50)
    private String nomdoc;

    @Column(name = "apedoc", nullable = false, length = 50)
    private String apedoc;

    @Column(name = "codespe", nullable = false)
    private Integer codespe;

    @Column(name = "sexo", nullable = false, length = 15)
    private String sexo;

    @Column(name = "telefo", nullable = false, length = 9)
    private String telefo;

    @Column(name = "fechanaci", nullable = false)
    private Date fechanaci;

    @Column(name = "correo", nullable = false, length = 50)
    private String correo;

    @Column(name = "naciona", nullable = false, length = 35)
    private String naciona;

    @Column(name = "estado", nullable = false, length = 15)
    private String estado;

    @CreationTimestamp
    @Column(name = "fecha_create", nullable = false, updatable = false)
    private Timestamp fechaCreate;

    @ManyToOne
    @JoinColumn(name = "codespe", referencedColumnName = "codespe", insertable = false, updatable = false)
    private Specialty specialty;

	public Integer getCoddoc() {
		return coddoc;
	}

	public void setCoddoc(Integer coddoc) {
		this.coddoc = coddoc;
	}

	public String getDnidoc() {
		return dnidoc;
	}

	public void setDnidoc(String dnidoc) {
		this.dnidoc = dnidoc;
	}

	public String getNomdoc() {
		return nomdoc;
	}

	public void setNomdoc(String nomdoc) {
		this.nomdoc = nomdoc;
	}

	public String getApedoc() {
		return apedoc;
	}

	public void setApedoc(String apedoc) {
		this.apedoc = apedoc;
	}

	public Integer getCodespe() {
		return codespe;
	}

	public void setCodespe(Integer codespe) {
		this.codespe = codespe;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefo() {
		return telefo;
	}

	public void setTelefo(String telefo) {
		this.telefo = telefo;
	}

	public Date getFechanaci() {
		return fechanaci;
	}

	public void setFechanaci(Date fechanaci) {
		this.fechanaci = fechanaci;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNaciona() {
		return naciona;
	}

	public void setNaciona(String naciona) {
		this.naciona = naciona;
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

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}

}
