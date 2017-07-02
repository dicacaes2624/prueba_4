package co.edu.usbcali.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.edu.usbcali.ws.rest.logic.CalculadoraLogica;
import co.edu.usbcali.ws.rest.vo.VOCalculadora;

@Path("/Calculadora")
public class ServiceCalculadora {
	
	private CalculadoraLogica calculadoraLogica = new CalculadoraLogica();
	
	@POST
	@Path("/sumaNumeros")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOCalculadora sumaNumeros(VOCalculadora vo){
		
		int nuNum1 = vo.getNuNumero1();
		int nuNum2 = vo.getNuNumero2();
		String sbOperacion = vo.getSbOperacion();
		int nuResultado;
		
		if (sbOperacion.toLowerCase().equals("suma")){
			nuResultado = calculadoraLogica.suma(nuNum1, nuNum2);
			vo.setSbProcesado("Ok");
		}else if (sbOperacion.toLowerCase().equals("resta")){
			nuResultado = calculadoraLogica.resta(nuNum1, nuNum2);
			vo.setSbProcesado("Ok");
		}else if (sbOperacion.toLowerCase().equals("division")){
			nuResultado = calculadoraLogica.division(nuNum1, nuNum2);
			vo.setSbProcesado("Ok");
		}else if (sbOperacion.toLowerCase().equals("multiplicacion")){
			nuResultado = calculadoraLogica.multiplicacion(nuNum1, nuNum2);
			vo.setSbProcesado("Ok");
		}else{
		    nuResultado = -1;
		    vo.setSbProcesado("Unknown");
		}
		
		vo.setNuResultado(nuResultado);
		
		return vo;
		
	}

}
