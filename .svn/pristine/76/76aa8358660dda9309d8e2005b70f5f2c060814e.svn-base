package com.uadec.entity.model;

import java.math.BigDecimal;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * Solicitud entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SOLICITUD", schema = "DB2ADMIN")

public class Solicitud implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7046920425944104562L;
	private Long idSolicitud;
	private CatTipoTramite catTipoTramite;
	private Date fechaSolicitud;
	private String fondo;
	private String NCbancaria;
	private String unidadOrg;
	private BigDecimal importe;
	private String autorizador;
	private String elaborador;
	private String contrato;
	private String rfcProveedor;
	private String cheque;
	private String cuentaPagar;
	private String ciclo;
	private String folioVentanilla;
	private String folioSdr;
	private String NCompromiso;
	private String claveBeneficiario;

	private String fechaSolicitudStr;
	private String importeStr;
	
	// Constructors

	/** default constructor */
	public Solicitud() {
	}

	/** minimal constructor */
	public Solicitud(CatTipoTramite catTipoTramite, String cuentaPagar, String ciclo) {
		this.catTipoTramite = catTipoTramite;
		this.cuentaPagar = cuentaPagar;
		this.ciclo = ciclo;
	}

	/** full constructor */
	public Solicitud(CatTipoTramite catTipoTramite, Date fechaSolicitud, String fondo, String NCbancaria,
			String unidadOrg, BigDecimal importe, String autorizador, String elaborador, String contrato,
			String rfcProveedor, String cheque, String cuentaPagar, String ciclo, String folioVentanilla,
			String folioSdr, String NCompromiso, String claveBeneficiario) {
		this.catTipoTramite = catTipoTramite;
		this.fechaSolicitud = fechaSolicitud;
		this.fondo = fondo;
		this.NCbancaria = NCbancaria;
		this.unidadOrg = unidadOrg;
		this.importe = importe;
		this.autorizador = autorizador;
		this.elaborador = elaborador;
		this.contrato = contrato;
		this.rfcProveedor = rfcProveedor;
		this.cheque = cheque;
		this.cuentaPagar = cuentaPagar;
		this.ciclo = ciclo;
		this.folioVentanilla = folioVentanilla;
		this.folioSdr = folioSdr;
		this.NCompromiso = NCompromiso;
		this.claveBeneficiario = claveBeneficiario;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "ID_SOLICITUD", unique = true, nullable = false)

	public Long getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(Long idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_TRAMITE", nullable = false)

	public CatTipoTramite getCatTipoTramite() {
		return this.catTipoTramite;
	}

	public void setCatTipoTramite(CatTipoTramite catTipoTramite) {
		this.catTipoTramite = catTipoTramite;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_SOLICITUD", length = 10)

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	@Column(name = "FONDO", length = 20)

	public String getFondo() {
		return this.fondo;
	}

	public void setFondo(String fondo) {
		this.fondo = fondo;
	}

	@Column(name = "N_CBANCARIA", length = 20)

	public String getNCbancaria() {
		return this.NCbancaria;
	}

	public void setNCbancaria(String NCbancaria) {
		this.NCbancaria = NCbancaria;
	}

	@Column(name = "UNIDAD_ORG", length = 20)

	public String getUnidadOrg() {
		return this.unidadOrg;
	}

	public void setUnidadOrg(String unidadOrg) {
		this.unidadOrg = unidadOrg;
	}

	@Column(name = "IMPORTE", precision = 17)

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	@Column(name = "AUTORIZADOR", length = 100)

	public String getAutorizador() {
		return this.autorizador;
	}

	public void setAutorizador(String autorizador) {
		this.autorizador = autorizador;
	}

	@Column(name = "ELABORADOR", length = 100)

	public String getElaborador() {
		return this.elaborador;
	}

	public void setElaborador(String elaborador) {
		this.elaborador = elaborador;
	}

	@Column(name = "CONTRATO", length = 20)

	public String getContrato() {
		return this.contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	@Column(name = "RFC_PROVEEDOR", length = 30)

	public String getRfcProveedor() {
		return this.rfcProveedor;
	}

	public void setRfcProveedor(String rfcProveedor) {
		this.rfcProveedor = rfcProveedor;
	}

	@Column(name = "CHEQUE", length = 20)

	public String getCheque() {
		return this.cheque;
	}

	public void setCheque(String cheque) {
		this.cheque = cheque;
	}

	@Column(name = "CUENTA_PAGAR", nullable = false, length = 20)

	public String getCuentaPagar() {
		return this.cuentaPagar;
	}

	public void setCuentaPagar(String cuentaPagar) {
		this.cuentaPagar = cuentaPagar;
	}

	@Column(name = "CICLO", nullable = false, length = 4)

	public String getCiclo() {
		return this.ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	@Column(name = "FOLIO_VENTANILLA", length = 20)

	public String getFolioVentanilla() {
		return this.folioVentanilla;
	}

	public void setFolioVentanilla(String folioVentanilla) {
		this.folioVentanilla = folioVentanilla;
	}

	@Column(name = "FOLIO_SDR", length = 20)

	public String getFolioSdr() {
		return this.folioSdr;
	}

	public void setFolioSdr(String folioSdr) {
		this.folioSdr = folioSdr;
	}

	@Column(name = "N_COMPROMISO", length = 20)

	public String getNCompromiso() {
		return this.NCompromiso;
	}

	public void setNCompromiso(String NCompromiso) {
		this.NCompromiso = NCompromiso;
	}

	@Column(name = "CLAVE_BENEFICIARIO", length = 20)

	public String getClaveBeneficiario() {
		return this.claveBeneficiario;
	}

	public void setClaveBeneficiario(String claveBeneficiario) {
		this.claveBeneficiario = claveBeneficiario;
	}
	
	@Transient
	public String getFechaSolicitudStr() {
		return fechaSolicitudStr;
	}
	
	
	public void setFechaSolicitudStr(String fechaSolicitudStr) {
		this.fechaSolicitudStr = fechaSolicitudStr;
	}
	
	@Transient
	public String getImporteStr() {
		return importeStr;
	}
	
	public void setImporteStr(String importeStr) {
		this.importeStr = importeStr;
	}

}