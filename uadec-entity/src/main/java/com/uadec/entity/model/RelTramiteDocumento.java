package com.uadec.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RelTramiteDocumento entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "REL_TRAMITE_DOCUMENTO", schema = "DB2ADMIN")

public class RelTramiteDocumento implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idTramiteDoc;
	private CatDocumentos catDocumentos;
	private CatTipoTramite catTipoTramite;

	// Constructors

	/** default constructor */
	public RelTramiteDocumento() {
	}

	/** full constructor */
	public RelTramiteDocumento(CatDocumentos catDocumentos, CatTipoTramite catTipoTramite) {
		this.catDocumentos = catDocumentos;
		this.catTipoTramite = catTipoTramite;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "ID_TRAMITE_DOC", unique = true, nullable = false)

	public Long getIdTramiteDoc() {
		return this.idTramiteDoc;
	}

	public void setIdTramiteDoc(Long idTramiteDoc) {
		this.idTramiteDoc = idTramiteDoc;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DOCUMENTO", nullable = false)

	public CatDocumentos getCatDocumentos() {
		return this.catDocumentos;
	}

	public void setCatDocumentos(CatDocumentos catDocumentos) {
		this.catDocumentos = catDocumentos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_TRAMITE", nullable = false)

	public CatTipoTramite getCatTipoTramite() {
		return this.catTipoTramite;
	}

	public void setCatTipoTramite(CatTipoTramite catTipoTramite) {
		this.catTipoTramite = catTipoTramite;
	}

}