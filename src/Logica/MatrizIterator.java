package Logica;

import java.util.Iterator;

/*
 * Esta clase colabora con la clase MatrizSegmentoLCD para manejar operaciones
 * con interfaz Iterator<String> para recorrer la matriz de caracteres.
 * */
 public class MatrizIterator implements Iterator<String>{

	private String[][] matriz;
	private int posicion=0;
	
	public MatrizIterator(String [][] matriz) {
		this.matriz=matriz;		
	}

	//verifica contenido de siguiente posición de matriz LCD
	public boolean hasNext(){
		if(matriz.length >= posicion + 1){
			return true;
		}
		return false;
		
	}

	@Override
	public String next() {
		String linea="";
		String lineaAux="";
			for(int i=0;i<matriz[posicion].length;i++){
				lineaAux+=matriz[posicion][i]+"";
			}
		linea=lineaAux;	
		posicion++;
		return linea;
	}
}
