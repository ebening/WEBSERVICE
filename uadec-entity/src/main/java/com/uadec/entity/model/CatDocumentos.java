package com.uadec.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CatDocumentos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CAT_DOCUMENTOS", schema = "DB2ADMIN")

public class CatDocumentos implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idDocumento;
	private String descripcion;

	// Constructors

	/** default constructor */
	public CatDocumentos() {
	}

	/** full constructor */
	public CatDocumentos(String descripcion) {
		this.descripcion = descripcion;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "ID_DOCUMENTO", unique = true, nullable = false)

	public Integer getIdDocumento() {
		return this.idDocumento;
	}

	public void setIdDocumento(Integer idDocumento) {
		this.idDocumento = idDocumento;
	}

	@Column(name = "DESCRIPCION", length = 100)

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}