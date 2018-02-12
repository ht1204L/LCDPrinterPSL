package Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Controlador.CMatrizLCD;
import Controlador.Impresora;
import Logica.LCDInstruccion;
import Logica.MatrizSegmentoLCD;

public class PruebaImpresora {
	
	 	private ByteArrayOutputStream flujoSalida;
	    private PrintStream flujoPruebaSalida;
	    private PrintStream flujoSalidaSistema;
	
	//Prueba flujos de bits 
	@Before
	public void pruebaFlujoInicial() {
		flujoSalida = new ByteArrayOutputStream();
		flujoPruebaSalida = new PrintStream(flujoSalida);
		flujoSalidaSistema = System.out;
        System.setOut(new PrintStream(flujoPruebaSalida));
	}
	
	 @After
	  public void pruebaLimpiarConsola() {
	        System.setOut(flujoSalidaSistema);
	  }
	 
	 //Prueba para imprimir número
	 @Test
	 public void imprimirNumero() throws Exception{
		 Impresora imp=new Impresora();
		 imp.inputInstruccion(new LCDInstruccion("2,8"), 2);
		 MatrizSegmentoLCD m=CMatrizLCD.getMatrizCreada('8', 2);
		 assertEquals(m.toString(),flujoSalida.toString());
	 }

	 
	 
}
