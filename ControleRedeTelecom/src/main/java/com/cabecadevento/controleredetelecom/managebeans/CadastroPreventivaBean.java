package com.cabecadevento.controleredetelecom.managebeans;

import java.io.Serializable;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.cabecadevento.controleredetelecom.model.Preventivas;
import com.cabecadevento.controleredetelecom.repository.PreventivasRepository;
import com.cabecadevento.controleredetelecom.util.jpa.Transactional;
import com.cabecadevento.controleredetelecom.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroPreventivaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Preventivas preventiva;
	
	@Inject
	private PreventivasRepository preventivas;
	
	@Transactional
	public void salvar(){
		this.preventiva = preventivas.salvar(this.preventiva);
		FacesUtil.addInfoMessage("Preventiva salva com sucesso!");
		preventiva = new Preventivas();
	}
	
	public Preventivas getPreventiva() {
		return preventiva;
	}

	public void setPreventiva(Preventivas preventiva) {
		this.preventiva = preventiva;
	}

	public PreventivasRepository getPreventivas() {
		return preventivas;
	}

	public void setPreventivas(PreventivasRepository preventivas) {
		this.preventivas = preventivas;
	}

}
