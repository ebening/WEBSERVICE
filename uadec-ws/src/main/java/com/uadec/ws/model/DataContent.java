/**
 * 
 */
package com.uadec.ws.model;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.uadec.entity.model.CatDocumentos;
import com.uadec.entity.model.CatTipoCuenta;
import com.uadec.entity.model.CatTipoTramite;
import com.uadec.entity.model.DetalleCuentas;
import com.uadec.entity.model.DocumentoImportado;
import com.uadec.entity.model.Solicitud;
import com.uadec.entity.model.Usuario;

/**
 * @author adinfi
 *
 */
public class DataContent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9143580773269827713L;
	private Solicitud solicitud;
	private CatTipoTramite catTipoTramite;
	private CatTipoCuenta catCuenta;
	private CatTipoCuenta catSubCuenta;
	private CatTipoCuenta catSubSubCuenta;
	private Usuario usuario;
	private DocumentoImportado documentoImportado;
	private CatDocumentos catDocumentos;
	private MultipartFile file;
	private String ip;
	private DetalleCuentas detalleCuenta;
	
	public Solicitud getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	public CatTipoTramite getCatTipoTramite() {
		return catTipoTramite;
	}
	public void setCatTipoTramite(CatTipoTramite catTipoTramite) {
		this.catTipoTramite = catTipoTramite;
	}
	public CatTipoCuenta getCatCuenta() {
		return catCuenta;
	}
	public void setCatCuenta(CatTipoCuenta catCuenta) {
		this.catCuenta = catCuenta;
	}
	public CatTipoCuenta getCatSubCuenta() {
		return catSubCuenta;
	}
	public void setCatSubCuenta(CatTipoCuenta catSubCuenta) {
		this.catSubCuenta = catSubCuenta;
	}
	public CatTipoCuenta getCatSubSubCuenta() {
		return catSubSubCuenta;
	}
	public void setCatSubSubCuenta(CatTipoCuenta catSubSubCuenta) {
		this.catSubSubCuenta = catSubSubCuenta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public DocumentoImportado getDocumentoImportado() {
		return documentoImportado;
	}
	public void setDocumentoImportado(DocumentoImportado documentoImportado) {
		this.documentoImportado = documentoImportado;
	}
	public CatDocumentos getCatDocumentos() {
		return catDocumentos;
	}
	public void setCatDocumentos(CatDocumentos catDocumentos) {
		this.catDocumentos = catDocumentos;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public DetalleCuentas getDetalleCuenta() {
		return detalleCuenta;
	}
	public void setDetalleCuenta(DetalleCuentas detalleCuenta) {
		this.detalleCuenta = detalleCuenta;
	}
	
}
