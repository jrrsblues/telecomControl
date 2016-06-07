package com.cabecadevento.controleredetelecom.repository.filter;

import java.io.Serializable;
import java.util.Date;

public class PreventivaFilter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long idDe;
	private Long idAte; 
	private Date dataPlanejadaDe;
	private Date dataPlanejadaAte;
	private String executor;
	
	public Long getIdDe() {
		return idDe;
	}
	public void setIdDe(Long idDe) {
		this.idDe = idDe;
	}
	public Long getIdAte() {
		return idAte;
	}
	public void setIdAte(Long idAte) {
		this.idAte = idAte;
	}
	public Date getDataPlanejadaDe() {
		return dataPlanejadaDe;
	}
	public void setDataPlanejadaDe(Date dataPlanejadaDe) {
		this.dataPlanejadaDe = dataPlanejadaDe;
	}
	public Date getDataPlanejadaAte() {
		return dataPlanejadaAte;
	}
	public void setDataPlanejadaAte(Date dataPlanejadaAte) {
		this.dataPlanejadaAte = dataPlanejadaAte;
	}
	public String getExecutor() {
		return executor;
	}
	public void setExecutor(String executor) {
		this.executor = executor;
	}
}
