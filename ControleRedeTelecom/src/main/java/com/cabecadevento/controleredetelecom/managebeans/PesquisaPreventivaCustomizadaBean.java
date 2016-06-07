package com.cabecadevento.controleredetelecom.managebeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cabecadevento.controleredetelecom.model.Preventivas;
import com.cabecadevento.controleredetelecom.repository.PreventivasPesquisaCustomizada;
import com.cabecadevento.controleredetelecom.repository.filter.PreventivaFilter;



@Named
@ViewScoped
public class PesquisaPreventivaCustomizadaBean implements Serializable {

private static final long serialVersionUID = 1L;

  @Inject
  private PreventivasPesquisaCustomizada preventiva;
	
  private PreventivaFilter filtro;
  private List<Preventivas> preventivasFiltradas;
  
  public PesquisaPreventivaCustomizadaBean(){
	  filtro = new PreventivaFilter();
	  preventivasFiltradas = new ArrayList();
  }
  
  public void pesquisar(){
	  preventivasFiltradas = preventiva.filtrados(filtro);
  }

  public PreventivaFilter getFiltro() {
	return filtro;
  }

  public void setFiltro(PreventivaFilter filtro) {
	this.filtro = filtro;
  }

  public List<Preventivas> getPreventivasFiltradas() {
	return preventivasFiltradas;
  }

  public void setPreventivasFiltradas(List<Preventivas> preventivasFiltradas) {
	this.preventivasFiltradas = preventivasFiltradas;
  }

}
