package com.uadec.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CatTipoTramite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CAT_TIPO_TRAMITE", schema = "DB2ADMIN")

public class CatTipoTramite implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTipoTramite;
	private String descripcion;
//	private Set<RelTramiteDocumento> relTramiteDocumentos = new HashSet<RelTramiteDocumento>(0);
//	private Set<Solicitud> solicituds = new HashSet<Solicitud>(0);

	// Constructors

	/** default constructor */
	public CatTipoTramite() {
	}

	/** full constructor */
	public CatTipoTramite(String descripcion) {
		this.descripcion = descripcion;
//		this.relTramiteDocumentos = relTramiteDocumentos;
//		this.solicituds = solicituds;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "ID_TIPO_TRAMITE", unique = true, nullable = false)

	public Integer getIdTipoTramite() {
		return this.idTipoTramite;
	}

	public void setIdTipoTramite(Integer idTipoTramite) {
		this.idTipoTramite = idTipoTramite;
	}

	@Column(name = "DESCRIPCION", length = 100)

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "catTipoTramite")
//
//	public Set<RelTramiteDocumento> getRelTramiteDocumentos() {
//		return this.relTramiteDocumentos;
//	}
//
//	public void setRelTramiteDocumentos(Set<RelTramiteDocumento> relTramiteDocumentos) {
//		this.relTramiteDocumentos = relTramiteDocumentos;
//	}
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "catTipoTramite")
//
//	public Set<Solicitud> getSolicituds() {
//		return this.solicituds;
//	}
//
//	public void setSolicituds(Set<Solicitud> solicituds) {
//		this.solicituds = solicituds;
//	}

}