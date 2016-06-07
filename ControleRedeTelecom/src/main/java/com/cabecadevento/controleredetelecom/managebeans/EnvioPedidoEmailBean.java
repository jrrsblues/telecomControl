package com.cabecadevento.controleredetelecom.managebeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EnvioPedidoEmailBean  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public void adicionarMensagemErro() {
		System.out.println("Mensagens com Messages e Growl!!!");
	}
}
