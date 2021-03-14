package com.uadec.entity.model;


import java.util.Date;

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
 * Bitacora entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BITACORA", schema = "DB2ADMIN")

public class Bitacora implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idBitacora;
	private Usuario usuario;
	private String modulo;
	private String accion;
	private String ip;
	private Date fechaHora;
	private String detalle;

	// Constructors

	/** default constructor */
	public Bitacora() {
	}

	/** minimal constructor */
	public Bitacora(Usuario usuario) {
		this.usuario = usuario;
	}

	/** full constructor */
	public Bitacora(Usuario usuario, String modulo, String accion, String ip, Date fechaHora, String detalle) {
		this.usuario = usuario;
		this.modulo = modulo;
		this.accion = accion;
		this.ip = ip;
		this.fechaHora = fechaHora;
		this.detalle = detalle;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "ID_BITACORA", unique = true, nullable = false)

	public Long getIdBitacora() {
		return this.idBitacora;
	}

	public void setIdBitacora(Long idBitacora) {
		this.idBitacora = idBitacora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO", nullable = false)

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "MODULO", length = 50)

	public String getModulo() {
		return this.modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	@Column(name = "ACCION", length = 15)

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	@Column(name = "IP", length = 15)

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "FECHA_HORA", length = 26)

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Column(name = "DETALLE", length = 250)

	public String getDetalle() {
		return this.detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

}