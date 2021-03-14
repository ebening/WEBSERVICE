package com.uadec.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CatTipoCuenta entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CAT_TIPO_CUENTA", schema = "DB2ADMIN")

public class CatTipoCuenta implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTipoCuenta;
	private String descripcion;

	// Constructors

	/** default constructor */
	public CatTipoCuenta() {
	}

	/** full constructor */
	public CatTipoCuenta(String descripcion) {
		this.descripcion = descripcion;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "ID_TIPO_CUENTA", unique = true, nullable = false)

	public Integer getIdTipoCuenta() {
		return this.idTipoCuenta;
	}

	public void setIdTipoCuenta(Integer idTipoCuenta) {
		this.idTipoCuenta = idTipoCuenta;
	}

	@Column(name = "DESCRIPCION", length = 20)

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}