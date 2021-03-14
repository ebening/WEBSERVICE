package com.uadec.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rol entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ROL", schema = "DB2ADMIN")

public class Rol implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 283066799666711442L;
	private Long idRol;
	private String nombreRol;

	// Constructors

	/** default constructor */
	public Rol() {
	}

	/** full constructor */
	public Rol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_ROL", unique = true, nullable = false)

	public Long getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	@Column(name = "NOMBRE_ROL", length = 20)

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
}