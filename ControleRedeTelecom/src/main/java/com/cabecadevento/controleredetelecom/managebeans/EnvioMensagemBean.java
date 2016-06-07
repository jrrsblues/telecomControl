package com.cabecadevento.controleredetelecom.managebeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cabecadevento.controleredetelecom.model.Preventivas;
import com.cabecadevento.controleredetelecom.repository.PreventivasRepository;
import com.cabecadevento.controleredetelecom.util.mail.Mailer;
import com.outjected.email.api.MailMessage;
import com.outjected.email.impl.templating.velocity.VelocityTemplate;

@Named
@RequestScoped
public class EnvioMensagemBean implements Serializable {

	private static final long serialVersionUID = 1L;
	String client;
	@Inject
	private Mailer mailer;
	
	@Inject
	private PreventivasRepository preventivas;
	
	private Preventivas preventiva;
	
	private List<Preventivas> preventivasExecutadas;
	
	private String texto;
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String montarTexto(){
		texto = texto + "<html>";
		texto = texto + "<body>";
		texto = texto + "<table>";
		texto = texto + "<table border='1' cellspacing='0' cellpadding='3'>";
		texto = texto + "<tr>";
		texto = texto + "<th>Mês</th>";
		texto = texto + "<th>UF</th>";
		texto = texto + "<th>Site</th>";
		texto = texto + "<th>Tipo Preventiva</th>";
		texto = texto + "<th>Executor</th>";
		texto = texto + "<th>Resultado</th>";
		texto = texto + "</tr>";
		preventivasExecutadas = preventivas.buscarPreventivasExecutadas();
		Iterator itr = preventivasExecutadas.iterator();
		while(itr.hasNext()){
			Object[] obj = (Object[]) itr.next();
			texto = texto + "<tr>";
			texto = texto + "<td>" + String.valueOf(obj[1]) + "</td>";
			texto = texto + "<td>" + String.valueOf(obj[2]) + "</td>";
			texto = texto + "<td>" + String.valueOf(obj[3]) + "</td>";
			texto = texto + "<td>" + String.valueOf(obj[4]) + "</td>";
			texto = texto + "<td>" + String.valueOf(obj[5]) + "</td>";
			texto = texto + "<td>" + String.valueOf(obj[6]) + "</td>";
			texto = texto + "</tr>";
		}
		texto = texto + "</table>";
		texto = texto + "</body>";
		texto = texto + "</html>";
		return texto;
	}

	public void enviarMensagem(){
        MailMessage message = mailer.novaMensagem();
        	message.to("jrrsblues@gmail.com")
			.subject("Teste de envio de e-mail")
			.bodyHtml(montarTexto())
			.send();
		System.out.println("Mensagem enviada com sucesso!");
	}

}