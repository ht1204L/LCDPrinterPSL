package Vista;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import Controlador.Impresora;
import Logica.LCDInstruccion;
/*
 * Autor: Héctor Triana
 * */
//Clase encargada de operar el ingreso de números por instrucciones en consola
// e imprimirlos en formato LCD
public class LCDImpresoraTester {
	static final String CADENA_FINAL = "0,0";
	
	//Método para ingresar instrucciones numéricas y mostrar formato LCD
	public static void inputData(){
		
		 List<String> commandList = new ArrayList<>();
	     String instruccion;
	     int spaceBetweenDigits;
	     
	    try{
	    	 try(Scanner input = new Scanner(System.in)){
	    		 System.out.print("Espacio entre Digitos (0 a 5): ");
	    		// Valida si es un numero
	                if (!input.hasNextInt()) {
	                    input.next();
	                    throw new IllegalArgumentException("La entrada no es un entero");
	                }

	                spaceBetweenDigits = input.nextInt();

	                // se valida que el espaciado este entre 0 y 5
	                if(spaceBetweenDigits <0 || spaceBetweenDigits >5) {
	                    throw new IllegalArgumentException("El espacio entre "
	                            + "digitos debe estar entre 0 y 5");
	                }

	                do {
	                    System.out.print("Ingrese Comando: ");
	                    instruccion = input.next();
	                    if(!instruccion.equalsIgnoreCase(CADENA_FINAL)) {
	                        commandList.add(instruccion);
	                    }
	                }while (!instruccion.equalsIgnoreCase(CADENA_FINAL));
	    		 
	    	 }
	    	 Impresora impLCD=new Impresora();
	    	 Iterator<String> iterator = commandList.iterator();
	    	 while (iterator.hasNext()) {
	                try {
	                	impLCD.inputInstruccion(new LCDInstruccion(iterator.next()), spaceBetweenDigits);
	                } catch (Exception e) {
	                    System.out.println("Error (1): " + e.getMessage());
	                }
	            }
	     }catch(Exception ex){
	    	 System.out.println("Error: "+ex.getMessage());
	     }

	}
}
