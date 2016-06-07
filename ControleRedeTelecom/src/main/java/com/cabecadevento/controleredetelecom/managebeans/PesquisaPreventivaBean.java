package com.cabecadevento.controleredetelecom.managebeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.cabecadevento.controleredetelecom.model.Preventivas;
import com.cabecadevento.controleredetelecom.repository.PreventivasRepository;
import com.cabecadevento.controleredetelecom.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaPreventivaBean  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int anofim;
	private String uffim;
	private String mesfim;
	private String sitefim;
	

	@Inject
	private Preventivas preventiva;
	
	@Inject
	private PreventivasRepository preventivas;
	
    private List<Preventivas> anoRaizes;
	
	private List<Preventivas> mesRaizes;
	
	private List<Preventivas> ufRaizes;
	
	private List<Preventivas> siteRaizes;
	
	private List<Preventivas> tipopreventivaRaizes;
	
		
	public void inicializar() {
		System.out.println("Carregando comboboxes...");
		if(FacesUtil.isNotPostback()){
			  ufRaizes = preventivas.buscarUfRaizes();
			  mesRaizes = preventivas.buscarMesRaizes();
			  anoRaizes = preventivas.buscarAnoRaizes();
		} 
	}
	
	public void pesquisar(){
		//System.out.println("O ano selecionado é: " + preventiva.getAno());
		//System.out.println("O mês selecionado é: " + preventiva.getMes());
		anofim = preventiva.getAno();
		uffim = preventiva.getUf();
		mesfim = preventiva.getMes();
		//System.out.println("O uf selecionado é: " + preventiva.getUf());
		//System.out.println("O site selecionado é: " + preventiva.getSite());
		//System.out.println("O Tipo preventiva selecionado é: " + preventiva.getTipopreventiva());
		preventiva = preventivas.buscaPreventivaPorAnoMesUTipopreventivaSite( preventiva.getAno(), preventiva.getMes(), preventiva.getUf(), preventiva.getTipopreventiva(), preventiva.getSite());
	}
	
	public void atualizar(){
		int msg = preventivas.atualizaPreventivaPorId(preventiva.getId(), anofim, mesfim,
		uffim,preventiva.getSite(), preventiva.getTipopreventiva(),
		preventiva.getExecutor(),preventiva.getDataplanejada(),preventiva.getDataexecutada(),
		preventiva.getAuditor(),preventiva.getDataauditoria(),preventiva.getResultadoauditoria(),
		preventiva.getRejeicaointernamotivo(),preventiva.getPreventivacorrigida(),preventiva.getDatacorrecao());
		
		if(msg==1){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Atualização ocorreu com sucesso!"));
		  }else{
			  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ocorreu erro na atualização; Favor tentar novamente ou contatar administrador!"));
		}
	}
	
	public void excluir(){
		int msg = preventivas.remover(preventiva.getId());
		if(msg==1){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Exclusão ocorreu com sucesso!"));
			//Limpar formulário
			this.preventiva = new Preventivas();
		  }else{
			  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Ocorreu erro na exclusão; Favor tentar novamente ou contatar administrador!"));
		}
	}
	
	public void carregarSiteNames(){
		siteRaizes = preventivas.buscarSitePorPreventivas(preventiva.getAno(),preventiva.getMes(),preventiva.getUf());
	}
	
	public void carregarTipoPreventiva(){
		tipopreventivaRaizes = preventivas.buscarTipoPreventivaPorPreventivas(preventiva.getAno(),preventiva.getMes(),preventiva.getUf(),preventiva.getSite());
	}

	public PreventivasRepository getPreventivas() {
		return preventivas;
	}

	public List<Preventivas> getAnoRaizes() {
		return anoRaizes;
	}

	public List<Preventivas> getMesRaizes() {
		return mesRaizes;
	}

	public List<Preventivas> getUfRaizes() {
		return ufRaizes;
	}

	public Preventivas getPreventiva() {
		return preventiva;
	}

	public List<Preventivas> getSiteRaizes() {
		return siteRaizes;
	}

	public List<Preventivas> getTipopreventivaRaizes() {
		return tipopreventivaRaizes;
	}


	public String getUffim() {
		return uffim;
	}


	public void setUffim(String uffim) {
		this.uffim = uffim;
	}


	public int getAnofim() {
		return anofim;
	}


	public void setAnofim(int anofim) {
		this.anofim = anofim;
	}


	public String getMesfim() {
		return mesfim;
	}


	public void setMesfim(String mesfim) {
		this.mesfim = mesfim;
	}


	public String getSitefim() {
		return sitefim;
	}


	public void setSitefim(String sitefim) {
		this.sitefim = sitefim;
	}

}
