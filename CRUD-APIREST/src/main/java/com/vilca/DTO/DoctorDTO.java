package com.vilca.DTO;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorDTO {

    private Integer coddoc;
    private String dnidoc;
    private String nomdoc;
    private String apedoc;
    private Integer codespe; // Podrías querer el nombre de la especialidad en lugar del código
    private String nomEspecialidad; // Campo para el nombre de la especialidad
    private String sexo;
    private String telefo;
    private Date fechanaci;
    private String correo;
    private String naciona;
    private String estado;

    // Constructor con todos los campos (opcional, puedes generar los que necesites)
    public DoctorDTO(Integer coddoc, String dnidoc, String nomdoc, String apedoc, Integer codespe, String nomEspecialidad, String sexo, String telefo, Date fechanaci, String correo, String naciona, String estado) {
        this.coddoc = coddoc;
        this.dnidoc = dnidoc;
        this.nomdoc = nomdoc;
        this.apedoc = apedoc;
        this.codespe = codespe;
        this.nomEspecialidad = nomEspecialidad;
        this.sexo = sexo;
        this.telefo = telefo;
        this.fechanaci = fechanaci;
        this.correo = correo;
        this.naciona = naciona;
        this.estado = estado;
    }


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

	public String getNomEspecialidad() {
		return nomEspecialidad;
	}

	public void setNomEspecialidad(String nomEspecialidad) {
		this.nomEspecialidad = nomEspecialidad;
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
    
    
}