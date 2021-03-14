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
 * DetalleCuentas entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "DETALLE_CUENTAS", schema = "DB2ADMIN")

public class DetalleCuentas implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idDetalleCuentas;
	private CatTipoCuenta catTipoCuenta;
	private String numero;
	private String ciclo;
	private String cuentaPagar;

	// Constructors

	/** default constructor */
	public DetalleCuentas() {
	}

	/** minimal constructor */
	public DetalleCuentas(CatTipoCuenta catTipoCuenta) {
		this.catTipoCuenta = catTipoCuenta;
	}

	/** full constructor */
	public DetalleCuentas(CatTipoCuenta catTipoCuenta, String numero, String ciclo, String cuentaPagar) {
		this.catTipoCuenta = catTipoCuenta;
		this.numero = numero;
		this.ciclo = ciclo;
		this.cuentaPagar = cuentaPagar;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "ID_DETALLE_CUENTAS", unique = true, nullable = false)

	public Long getIdDetalleCuentas() {
		return this.idDetalleCuentas;
	}

	public void setIdDetalleCuentas(Long idDetalleCuentas) {
		this.idDetalleCuentas = idDetalleCuentas;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_CUENTA", nullable = false)

	public CatTipoCuenta getCatTipoCuenta() {
		return this.catTipoCuenta;
	}

	public void setCatTipoCuenta(CatTipoCuenta catTipoCuenta) {
		this.catTipoCuenta = catTipoCuenta;
	}

	@Column(name = "NUMERO", length = 20)

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "CICLO", length = 20)

	public String getCiclo() {
		return this.ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	@Column(name = "CUENTA_PAGAR", length = 20)

	public String getCuentaPagar() {
		return this.cuentaPagar;
	}

	public void setCuentaPagar(String cuentaPagar) {
		this.cuentaPagar = cuentaPagar;
	}

}