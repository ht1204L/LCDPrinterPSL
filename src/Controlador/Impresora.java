package Controlador;

import Logica.GestorNumerico;
import Logica.LCDInstruccion;

//Clase encargada de imprimir matriz LCD
public class Impresora {
	private int contador=0;
	private MatrizLCDImpresora mLCD;
	
	public Impresora(){
		
	}
	
	//Esta funci�n recibe las instrucciones LCD digitadas para comenzar el proceso de impresi�n
	public void inputInstruccion(LCDInstruccion instruc, int espaciado){
		mLCD=new MatrizLCDImpresora(espaciado);
		int size=instruc.getTamano();
		char[] cadenas=instruc.numerosCadena();
		for(char num: cadenas){
			GestorNumerico gesNum=GestorNumerico.crearNumero(num, size);
			mLCD.escribeMatriz(gesNum);
		}
		imprimirLinea(mLCD);
	}
	
	//Verificador de n�meros digitados en cadena
	public boolean esNumerico(String instruc){
		 try {
	            Integer.parseInt(instruc);
	            return true;
	        } catch (NumberFormatException ex) {
	            return false;
	        }
	}
	
	//M�todo encargada de imprimir l�neas de matriz LCD
	private void imprimirLinea(MatrizLCDImpresora mLCD){
		if(contador>0) System.out.print("\n\n");
		System.out.print(mLCD);
		contador++;
	}
	
}
