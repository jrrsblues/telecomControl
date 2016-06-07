package com.cabecadevento.controleredetelecom.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.cabecadevento.controleredetelecom.model.Preventivas;
import com.cabecadevento.controleredetelecom.repository.PreventivasRepository;
import com.cabecadevento.controleredetelecom.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Preventivas.class)
public class PreventivasConverter implements Converter {
	
	   //@Inject
		private PreventivasRepository repositorio;
		
		public PreventivasConverter() {
			repositorio = CDIServiceLocator.getBean(PreventivasRepository.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Preventivas retorno = null;
			
			if (value != null) {
				Long id = new Long(value);
				retorno = repositorio.porID(id);
			}
			
			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				return ((Preventivas) value).getId().toString();
			}
			
			return "";
		}

}
