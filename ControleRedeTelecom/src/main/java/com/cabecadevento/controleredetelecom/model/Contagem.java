package com.cabecadevento.controleredetelecom.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contagem")
public class Contagem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private int ano;
	private String mes;
	private String tipopreventiva;
	private String uf;
	private int planejado;
	private int realizado;
	private int aprovado;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getTipopreventiva() {
		return tipopreventiva;
	}
	public void setTipopreventiva(String tipopreventiva) {
		this.tipopreventiva = tipopreventiva;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public int getPlanejado() {
		return planejado;
	}
	public void setPlanejado(int planejado) {
		this.planejado = planejado;
	}
	public int getRealizado() {
		return realizado;
	}
	public void setRealizado(int realizado) {
		this.realizado = realizado;
	}
	public int getAprovado() {
		return aprovado;
	}
	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
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
