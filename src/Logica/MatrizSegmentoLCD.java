package Logica;

import java.util.Iterator;

//Clase encargada de crear las representaciones de los números en forma de
//consola LCD
public class MatrizSegmentoLCD implements Iterable<String>{
	
	//Definiendo caracteres que aparecen en matriz 7 segmentos
	private static String caracterH="-";//Horizontal
	private static String caracterV="|";//Vertical
	
	//Definiendo matriz LCD y sus características de funcionalidad al imprimir
	private int tamano,ancho,alto;
	private String[][] matrizLCD;
	
	public MatrizSegmentoLCD(int tamano){
		//Definiendo características funcionales de matriz LCD
		setTamano(tamano);
	}
	//Captura el tamaño que debe tener el número
	private void setTamano(int size){
		if(size<1){
			throw  new IllegalArgumentException("El tamaño debe ser mayor a uno (1) ");
		}
		tamano=size;
		this.setAlto(tamano);
		this.setAncho(tamano);
		crearMatriz(this.getAncho(), this.getAlto());
	}
	//Creandco alto y ancho de la matrz LCD
	private void setAlto(int size){
		this.alto=(size*2)+3;
	}
	
	private void setAncho(int size){
		this.ancho=size+2;
	}
	
	//Obteniendo valores de alto y ancho de la matriz LCD
	public int getAlto(){
		return this.alto;
	}
	
	public int getAncho(){
		return this.ancho;
	}
	
	public int getTamano(){
		return this.tamano;
	}
	
	public String[][] getMatrizLCD(){
		return matrizLCD.clone();//Se obtiene un clon de la matriz LCD
	}
	
	//Creando matriz LCD: Dimensiones y espacios en blanco
	private void crearMatriz(int ancho, int alto){
		matrizLCD=new String[alto][ancho];
		 for (int i = 0; i < alto; i++) {
	            for (int j = 0; j < ancho; j++) {
	            	matrizLCD[i][j] = " ";
	            }
	        }
		
	}
	
	//Métodos para dibujar segmentos de matriz a imprimir
	
	public void dibujarSegmento1(){
		for(int i=1;i<tamano+1;i++){
			matrizLCD[0][i]=caracterH;
		}
	}
	
	public void dibujarSegmento2(){
		for(int i=1;i<tamano+1;i++){
			matrizLCD[i][ancho - 1] = caracterV;
		}
	}
	
	public void dibujarSegmento3(){
		int inicio = (((tamano * 2) + 3)/2 )+ 1;
        for(int i = inicio; i < inicio + tamano ; i++){
            matrizLCD[i][ancho- 1] = caracterV;
        }
	}
	
	public void dibujarSegmento4(){
		   for(int i = 1; i < tamano + 1; i++){
	            matrizLCD[alto - 1][i] = caracterH;
	        }
	}
	
	public void dibujarSegmento5(){
		int inicio= (((tamano * 2) + 3)/2) + 1;
        for(int i = inicio; i < inicio + tamano; i++){
            matrizLCD[i][0] = caracterV;
        }
	}
	
	public void dibujarSegmento6(){
		 for(int i = 1; i < tamano+ 1; i++){
	           matrizLCD[i][0] = caracterV;
	        }
	}
	
	public void dibujarSegmento7(){
		int inicio = ((tamano* 2) + 3)/2 ;
        for(int i = 1; i < tamano + 1; i++){
            matrizLCD[inicio][i] = caracterH;
        }
	}
	
	
	
	//Aplicando interfaz iterable para tener recorridos procesados de la matriz
	@Override
	public Iterator<String> iterator() {
		return new MatrizIterator(matrizLCD);
	}

	//Obteniendo representación de matriz en String
	 @Override
	 public String toString() {
	     return String.join("\n", this);
	  }
	
		
}
