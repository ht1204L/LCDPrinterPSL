package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Controlador.MatrizLCDImpresora;
import Logica.GestorNumerico;

//Prueba para verificar la impresi�n de los n�meros LCD
public class PruebaMatrizLCDImpresora {

	@Test
	public void escribirMatriz() throws Exception {
		MatrizLCDImpresora mImp=new MatrizLCDImpresora(10);
		GestorNumerico gesLCDNumero=GestorNumerico.crearNumero('3', 3);
		mImp.escribeMatriz(gesLCDNumero);
	}

}
