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
@Table(name = "customers")
@Data
@NoArgsConstructor
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codpaci")
    private Integer codpaci;

    @Column(name = "dnipa", nullable = false, length = 8)
    private String dnipa;

    @Column(name = "nombrep", nullable = false, length = 50)
    private String nombrep;

    @Column(name = "apellidop", nullable = false, length = 50)
    private String apellidop;

    @Column(name = "seguro", nullable = false, length = 10)
    private String seguro;

    @Column(name = "tele", nullable = false, length = 9)
    private String tele;

    @Column(name = "sexo", nullable = false, length = 15)
    private String sexo;

    @Column(name = "usuario", nullable = false, length = 15)
    private String usuario;

    @Column(name = "clave", nullable = false)
    private String clave;

    @Column(name = "cargo", nullable = false, length = 1)
    private String cargo;

    @Column(name = "estado", nullable = false, length = 15)
    private String estado;

    @CreationTimestamp
    @Column(name = "fecha_create", nullable = false, updatable = false)
    private Timestamp fechaCreate;

	public Integer getCodpaci() {
		return codpaci;
	}

	public void setCodpaci(Integer codpaci) {
		this.codpaci = codpaci;
	}

	public String getDnipa() {
		return dnipa;
	}

	public void setDnipa(String dnipa) {
		this.dnipa = dnipa;
	}

	public String getNombrep() {
		return nombrep;
	}

	public void setNombrep(String nombrep) {
		this.nombrep = nombrep;
	}

	public String getApellidop() {
		return apellidop;
	}

	public void setApellidop(String apellidop) {
		this.apellidop = apellidop;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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


    
}
