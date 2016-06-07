package com.cabecadevento.controleredetelecom.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.cabecadevento.controleredetelecom.validation.Combobox;

@Entity
@Table(name = "preventivas")
public class Preventivas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue 
	Long id;
	private int ano;
	private String mes;
	private String uf;
	private String site;
	private String tipopreventiva;
	private String executor;
	private Date dataplanejada;
	private Date dataexecutada;
	private String auditor;
	private Date dataauditoria;
	private String resultadoauditoria;
	private String rejeicaointernamotivo;
	private String preventivacorrigida;
	private Date datacorrecao;
	private Date dataentrega;
	private String resultadocliente;
	private String rejeicaocliente;
	private int mesint;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@NotNull
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	@NotNull
	public String getMes() {
		return mes;
	}
	
	public void setMes(String mes) {
		this.mes = mes;
	}
	
	@NotNull
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	@NotNull
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	@NotNull
	public String getTipopreventiva() {
		return tipopreventiva;
	}
	
	public void setTipopreventiva(String tipopreventiva) {
		this.tipopreventiva = tipopreventiva;
	}
	
	public String getExecutor() {
		return executor;
	}
	
	public void setExecutor(String executor) {
		this.executor = executor;
	}
	
	public Date getDataplanejada() {
		return dataplanejada;
	}
	
	public void setDataplanejada(Date dataplanejada) {
		this.dataplanejada = dataplanejada;
	}
	
	public Date getDataexecutada() {
		return dataexecutada;
	}
	
	public void setDataexecutada(Date dataexecutada) {
		this.dataexecutada = dataexecutada;
	}
	
	public String getAuditor() {
		return auditor;
	}
	
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	
	public Date getDataauditoria() {
		return dataauditoria;
	}
	
	public void setDataauditoria(Date dataauditoria) {
		this.dataauditoria = dataauditoria;
	}
	
	public String getResultadoauditoria() {
		return resultadoauditoria;
	}
	
	public void setResultadoauditoria(String resultadoauditoria) {
		this.resultadoauditoria = resultadoauditoria;
	}
	
	public String getRejeicaointernamotivo() {
		return rejeicaointernamotivo;
	}
	
	public void setRejeicaointernamotivo(String rejeicaointernamotivo) {
		this.rejeicaointernamotivo = rejeicaointernamotivo;
	}
	
	public String getPreventivacorrigida() {
		return preventivacorrigida;
	}
	
	public void setPreventivacorrigida(String preventivacorrigida) {
		this.preventivacorrigida = preventivacorrigida;
	}
	
	public Date getDatacorrecao() {
		return datacorrecao;
	}
	
	public void setDatacorrecao(Date datacorrecao) {
		this.datacorrecao = datacorrecao;
	}
	
	public Date getDataentrega() {
		return dataentrega;
	}
	
	public void setDataentrega(Date dataentrega) {
		this.dataentrega = dataentrega;
	}
	public String getResultadocliente() {
		return resultadocliente;
	}
	public void setResultadocliente(String resultadocliente) {
		this.resultadocliente = resultadocliente;
	}
	public String getRejeicaocliente() {
		return rejeicaocliente;
	}
	public void setRejeicaocliente(String rejeicaocliente) {
		this.rejeicaocliente = rejeicaocliente;
	}

	public int getMesint() {
		return mesint;
	}
	public void setMesint(int mesint) {
		this.mesint = mesint;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Preventivas other = (Preventivas) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
