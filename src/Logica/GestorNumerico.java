package Logica;

import java.util.Iterator;

import Controlador.CMatrizLCD;

//Clase encargada de la creación de números a mostrar en pantalla
public class GestorNumerico {

	private MatrizSegmentoLCD matrizLCD;
	private char numero;
	
	private GestorNumerico(char numeroLCD, MatrizSegmentoLCD matrizLCD){
		numero=numeroLCD;
		this.matrizLCD=matrizLCD;
	}
	
	public static GestorNumerico crearNumero(char numero, int tamano){
		MatrizSegmentoLCD numMatrizLCD;
		if(!Character.isDigit(numero)){
			throw  new IllegalArgumentException("Debe ingresar una cifra numérica");
		}
		numMatrizLCD=CMatrizLCD.getMatrizCreada(numero, tamano);
		return new GestorNumerico(numero, numMatrizLCD);
	}
	
	
	public int getAlto(){
		return matrizLCD.getAlto();
	}
	
	public int getAncho(){
		return matrizLCD.getAncho();
	}
	
	public String[][] getMatrizLCD(){
		return matrizLCD.getMatrizLCD();
	}
	
	public Iterator getFilaIterator(){
		return matrizLCD.iterator();
	}
	
	public String toString(){
		return matrizLCD.toString();
	}
}
