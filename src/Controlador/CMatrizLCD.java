package Controlador;

import java.util.HashMap;

import Logica.MatrizSegmentoLCD;


/*
 * Autor: Héctor Triana
 * */

//Esta clase se encarga de darle forma a la matriz LCD antes de mostrar en pantalla
public class CMatrizLCD {

	//Definiendo variable hash para recorrido
	private static HashMap<String, MatrizSegmentoLCD> matrizHash = new HashMap<>();
	
	
	//Método para obtener matriz que contiene al número en formato LCD
	public static MatrizSegmentoLCD getMatrizCreada(char numero, int tamano){
		String instruc=numero+" "+tamano;
		if(!matrizHash.containsKey(instruc)){
			MatrizSegmentoLCD matAux=crearMatriz(numero, tamano);
			matrizHash.put(instruc, matAux);
		}
		return matrizHash.get(instruc);
	}
	
	//Método para crear matriz que contiene número en formato LCD
	private static MatrizSegmentoLCD crearMatriz(char numero, int tamanoMatriz){
		MatrizSegmentoLCD matriz;
		matriz=new MatrizSegmentoLCD(tamanoMatriz);
		
		 switch (numero){
		 	case '0':
		 		matriz.dibujarSegmento1();
		 		matriz.dibujarSegmento2();
		 		matriz.dibujarSegmento3();
		 		matriz.dibujarSegmento4();
		 		matriz.dibujarSegmento5();
		 		matriz.dibujarSegmento6();
		 		matriz.dibujarSegmento7();
		 	break;
		 	case '1':
		 		matriz.dibujarSegmento2();
		 		matriz.dibujarSegmento3();
		 	break;
		 	case '2':
		 		matriz.dibujarSegmento1();
		 		matriz.dibujarSegmento2();
		 		matriz.dibujarSegmento7();
		 		matriz.dibujarSegmento4();
		 		matriz.dibujarSegmento5();
		 	break;
		 	case '3':
		 		matriz.dibujarSegmento1();
		 		matriz.dibujarSegmento2();
		 		matriz.dibujarSegmento7();
		 		matriz.dibujarSegmento3();
		 		matriz.dibujarSegmento4();
		 	break;
		 	case '4':
		 		matriz.dibujarSegmento2();
		 		matriz.dibujarSegmento3();
		 		matriz.dibujarSegmento6();
		 		matriz.dibujarSegmento7();
		 	break;
		 	case '5':
		 		matriz.dibujarSegmento1();
		 		matriz.dibujarSegmento3();
		 		matriz.dibujarSegmento4();
		 		matriz.dibujarSegmento6();
		 		matriz.dibujarSegmento7();
		 	break;
		 	case '6':
		 		matriz.dibujarSegmento1();
		 		matriz.dibujarSegmento3();
		 		matriz.dibujarSegmento4();
		 		matriz.dibujarSegmento5();
		 		matriz.dibujarSegmento6();
		 		matriz.dibujarSegmento7();
		 	break;
		 	case '7':
		 		matriz.dibujarSegmento1();
		 		matriz.dibujarSegmento2();
		 		matriz.dibujarSegmento3();
		 	break;
		 	case '8':
		 		matriz.dibujarSegmento1();
		 		matriz.dibujarSegmento2();
		 		matriz.dibujarSegmento3();
		 		matriz.dibujarSegmento4();
		 		matriz.dibujarSegmento5();
		 		matriz.dibujarSegmento6();
		 		matriz.dibujarSegmento7();
		 	break;
		 	case '9':
		 		matriz.dibujarSegmento1();
		 		matriz.dibujarSegmento2();
		 		matriz.dibujarSegmento3();
		 		matriz.dibujarSegmento4();
		 		matriz.dibujarSegmento6();
		 		matriz.dibujarSegmento7();
		 	break;

		 }
		 return matriz;				
		
	}
	
	
	
	
	
	
}
