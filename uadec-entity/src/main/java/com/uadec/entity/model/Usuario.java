package com.uadec.entity.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Usuario entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "USUARIO", schema = "DB2ADMIN")

public class Usuario implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -809525922978214789L;
	private Long idUsuario;
	private Rol rol;
	private String apellidoPaterno;
	private String nombre;
	private String login;
	private String apellidoMaterno;
	private String password;
	private Set<DocumentoImportado> documentoImportados = new HashSet<DocumentoImportado>(0);
	private Set<Bitacora> bitacoras = new HashSet<Bitacora>(0);

	// Constructors

	/** default constructor */
	public Usuario() {
	}

	/** minimal constructor */
	public Usuario(Rol rol) {
		this.rol = rol;
	}

	/** full constructor */
	public Usuario(Rol rol, String apellidoPaterno, String nombre, String login, String apellidoMaterno,
			String password, Set<DocumentoImportado> documentoImportados, Set<Bitacora> bitacoras) {
		this.rol = rol;
		this.apellidoPaterno = apellidoPaterno;
		this.nombre = nombre;
		this.login = login;
		this.apellidoMaterno = apellidoMaterno;
		this.password = password;
		this.documentoImportados = documentoImportados;
		this.bitacoras = bitacoras;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "ID_USUARIO", unique = true, nullable = false)

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ROL", nullable = false)

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Column(name = "APELLIDO_PATERNO", length = 50)

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	@Column(name = "NOMBRE", length = 50)

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "LOGIN", length = 20)

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "APELLIDO_MATERNO", length = 50)

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	@Column(name = "PASSWORD", length = 20)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")

	public Set<DocumentoImportado> getDocumentoImportados() {
		return this.documentoImportados;
	}

	public void setDocumentoImportados(Set<DocumentoImportado> documentoImportados) {
		this.documentoImportados = documentoImportados;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")

	public Set<Bitacora> getBitacoras() {
		return this.bitacoras;
	}

	public void setBitacoras(Set<Bitacora> bitacoras) {
		this.bitacoras = bitacoras;
	}

}