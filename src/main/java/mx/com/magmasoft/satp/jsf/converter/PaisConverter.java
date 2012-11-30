/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.magmasoft.satp.jsf.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import mx.com.magmasoft.satp.service.PaisService;
import mx.com.magmasoft.satp.vo.Pais;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Carlos
 */
public class PaisConverter implements Converter
{
	private static final Logger logger = Logger.getLogger(PaisConverter.class);

	private PaisService paisService;

	public PaisService getPaisService()
	{
		logger.debug("getPaisService: " + paisService);
		return paisService;
	}

	@Autowired
	public void setPaisService(PaisService paisService)
	{
		logger.debug("setPaisService: " + paisService);
		this.paisService = paisService;
	}

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String submittedValue)
	{
		logger.debug("getAsObject: " + submittedValue);
		
		
		logger.debug("paso por aqui: 1:" + submittedValue);
		if (submittedValue.trim().equals(""))
		{
			logger.debug("return null");
			return null;
		}
		
		logger.debug("paso por aqui: 2:" + submittedValue);

		try
		{
			logger.debug("paso por aqui: 3:" + submittedValue);
			int number = Integer.parseInt(submittedValue);
			logger.debug("return Pais");
			return new Pais(number, "MX", "México", "MX");

			/*
			paises = paisService.listaPaises();
			logger.debug("paises: " + paises) ;
			
			for (Pais p : paises)
			{
				if (p.getIdPais() == number)
				{
					logger.debug("return p: " + p) ;
					return p;
				}
			} 
			 */


		}
		catch (NumberFormatException exception)
		{
			logger.debug("paso por aqui: 4:" + submittedValue, exception);
			throw new ConverterException(
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión", "No es un País válido"));
		}

		//logger.debug("return null 2");
		//return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object value)
	{
		logger.debug("getAsString");
		if (value == null || value.equals(""))
		{
			logger.debug("return \"\"");
			return "";
		}
		else
		{
			logger.debug("return: " + String.valueOf(((Pais) value).getIdPais()) + "->" + ((Pais) value).getNombre() );
			return String.valueOf(((Pais) value).getIdPais());
		}
	}
}
