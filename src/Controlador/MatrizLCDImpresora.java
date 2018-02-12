package Controlador;

import java.util.Iterator;

import Logica.GestorNumerico;

//
public class MatrizLCDImpresora {
	private String []fila;
	private int espaciado;
	
	//Constructor con espaciado entre numeros como par�metro
	public MatrizLCDImpresora(int espaciado){
		this.setEspaciado(espaciado);
		this.setFila();
	}
	//Ajustar fila de matriz por defecto
	private void setFila(){
		fila=new String[0];
	}
	//Capturando espacio entre d�gitos en clase
	private void setEspaciado(int espacio){
		espaciado=espacio;
	}
	
	private int getAltura(){
		return fila.length;
	}
	
	private int getAncho(){
		return fila[0].length();
	}
	
	private boolean estaVacio(){
		return fila.length == 0;
	}
	
	//Escribir matriz que contiene n�mero para formato LCD
	public void escribeMatriz(GestorNumerico gesNum){
		String[] ampliarMatriz=matrizExtender(gesNum);
		crearEspacios(ampliarMatriz);
		
	}
	
	//Extender matriz para empezar a darle formato LCD al n�mero
	private String[] matrizExtender(GestorNumerico gesNum){
		Iterator<String> filaIte=gesNum.getFilaIterator();
		String[] extend=new String[gesNum.getAlto()];
		int posSegmento=0;
		while(filaIte.hasNext()){
			String filaAux=filaIte.next();
			extend[posSegmento]=filaAux;
			posSegmento++;
		}
		return extend;
	}
	
	//M�todo para crear espacios en matriz ampliada, necesario para
	//dar formato LCD al n�mero 
	private void crearEspacios(String[] ampliarMatriz){
		int altura;
		if(ampliarMatriz.length>this.getAltura()){
			altura=ampliarMatriz.length;
		}else{
			altura=this.getAltura();
		}
		
		String[] filaActual;
		String[] nuevaFila=new String[altura];
		
		if(estaVacio()){
			filaActual=filaVaciaCreada(altura);
		}else{
			filaActual=filaEspaciadaCreada();
		}
		
		for(int i=0;i<altura;i++){
			nuevaFila[i]=filaActual[i]+ampliarMatriz[i];
		}
		
		fila=nuevaFila;
	}
	
	//M�todo para crear fila vac�a en matriz que contiene n�mero con formato LCD
	private String[] filaVaciaCreada(int altura){
		String[] filaVacia=new String[altura];
		for(int i=0;i<filaVacia.length;i++){
			filaVacia[i]="";
		}
		return filaVacia;
	}
	
	//M�todo para crear fila con espacios en blanco
	private String[] filaEspaciadaCreada(){
		String[] filaConEspaciado=fila.clone();
		String espacioEnBlanco="";
		
		for(int i=0;i<espaciado;i++){
			 espacioEnBlanco+=" ";
		}
		
		for(int i=0;i<filaConEspaciado.length;i++){
			filaConEspaciado[i]+=espacioEnBlanco;
		}
		
		return filaConEspaciado;
	}
	
	//M�todo para retornar cadena con n�mero en formato LCD
	public String toString(){
		String print="";
		for(int i = 0; i < this.getAltura(); i++){
            print+=fila[i];
            if(i != this.getAltura() -1){
                print+="\n";
            }
        }

        return print;
	}
	
}
