package com.cabecadevento.controleredetelecom.managebeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.cabecadevento.controleredetelecom.model.Contagem;
import com.cabecadevento.controleredetelecom.model.Preventivas;
import com.cabecadevento.controleredetelecom.repository.PreventivasRepository;

@Named
@ViewScoped
public class GraficoContagemPorAnoMesBean  implements Serializable {

    private BarChartModel barModel;
    
    String uf[] = new String[7];

    @Inject
	private Contagem contagens;
	
	@Inject
	private PreventivasRepository preventivas;
 
    @PostConstruct
    public void init() {
        createBarModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
 
    private BarChartModel initBarModel() {
    	
    	BarChartModel model = new BarChartModel();
   	
    	uf[0] = "AC";
    	uf[1] = "DF";
    	uf[2] = "GO";
    	uf[3] = "MT";
    	uf[4] = "MS";
    	uf[5] = "RO";
    	uf[5] = "TO";
        
    	ChartSeries chart[] = new ChartSeries[7];
    	for (int x = 0; x < 6; x++) {
    		
    		contagens = preventivas.buscaContagemPorAnoMesTipopreventiva(2016,"Maio","Infra",uf[x]);
    		
    		chart[x] = new ChartSeries(); 
    		chart[x].setLabel(contagens.getUf());
    		chart[x].set("Planejado", contagens.getPlanejado());
    		chart[x].set("Realizado", contagens.getRealizado());
    		chart[x].set("Aprovado", contagens.getAprovado());
    		
    	}
        
    	for (int x = 0; x < 6; x++) { 
    		model.addSeries(chart[x]);
    	}

         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
     }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Progresso de Execução de Preventivas - Maio");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Progresso");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Estado");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }

	//public Contagem getContagens() {
		//return contagens;
	//}

	//public void setContagens(Contagem contagens) {
		//this.contagens = contagens;
	//}

	//public PreventivasRepository getPreventivas() {
		//return preventivas;
	//}

	//public void setPreventivas(PreventivasRepository preventivas) {
		//this.preventivas = preventivas;
	//}
     

}
